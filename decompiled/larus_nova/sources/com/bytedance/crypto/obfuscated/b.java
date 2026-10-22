package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.modeldist.ModelInitResult;
import com.bytedance.crypto.utils.CertUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f204233a = null;

    static {
        f204233a = new ConcurrentHashMap();
    }

    public static int a(InputStream r100, long r101, OutputStream r110) {
        byte[] r102 = new byte[32768];
    L4:
        if (r101 <= 0) goto L11;
        int r103 = r100.read(r102, 0, (int) Math.min(32768, r101));     // Catch: IOException -> L13
        if (r103 == (-1)) goto L8;
        r110.write(r102, 0, r103);     // Catch: IOException -> L13
        r101 = r101 - ((long) r103);     // Catch: IOException -> L13
        goto L4
    L8:
        LogUtils.e("ModelDistUtils", "InputStream ended before reading the required length!!");     // Catch: IOException -> L13
        return -1;
    L13:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "concatModelPlainData failed, exception: " + e.getMessage());
        return -1;
    L11:
        r110.flush();     // Catch: IOException -> L13
        return 0;
    }

    public static ModelInitResult a(List<Certificate> r100, boolean r101) {
        if (r100 != null) goto L5;
    L16:
        StringBuilder r102 = new StringBuilder("Invalid certs: ");
        if (r100 != null) goto L19;
        String r103 = "null";
    L20:
        r102.append(r103);
        LogUtils.e("ModelDistUtils", r102.toString());
        return new ModelInitResult(-100, "");
    L19:
        r103 = r100.size() + "";
        goto L20
    L5:
        if (r100.size() < 4) goto L16;
        if (r101 == false) goto L11;
        LogUtils.d("ModelDistUtils", "ByteDance device");     // Catch: Exception -> L13
        return new ModelInitResult(0, CertUtils.certsToPemString(r100, r100.size() - 1));
    L11:
        LogUtils.d("ModelDistUtils", "Third-party device");     // Catch: Exception -> L13
        return new ModelInitResult(0, CertUtils.certsToPemString(r100, r100.size()));
    L13:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "Convert certificates to PEM String failed! Exception: " + e.getMessage());
        return new ModelInitResult(-100, "");
    }

    public static d a(DataInputStream r110) {
        int r100 = r110.readInt();     // Catch: Exception -> L20
        if (r100 == 329978795) goto L7;
        LogUtils.e("ModelDistUtils", "magicNum mismatch, excepted: 329978795, actually: " + r100);     // Catch: Exception -> L20
        return null;
    L7:
        byte r101 = r110.readByte();     // Catch: Exception -> L20
        LogUtils.d("ModelDistUtils", "version: " + r101);     // Catch: Exception -> L20
        int r102 = r110.readByte();     // Catch: Exception -> L20
        if (r102 == 12) goto L11;
        LogUtils.e("ModelDistUtils", "Invalid iv len: " + r102);     // Catch: Exception -> L20
        return null;
    L11:
        byte[] r103 = new byte[r102];     // Catch: Exception -> L20
        r110.readFully(r103);     // Catch: Exception -> L20
        LogUtils.d("ModelDistUtils", "dataIVLen: " + r102);     // Catch: Exception -> L20
        int r111 = r110.readInt();     // Catch: Exception -> L20
        if (r111 > 0) goto L14;
    L18:
        LogUtils.e("ModelDistUtils", "Invalid cipherBlockSize: " + r111);     // Catch: Exception -> L20
        return null;
    L14:
        if (r111 > 1048576) goto L18;
        LogUtils.d("ModelDistUtils", "cipherBlockSize: " + r111);     // Catch: Exception -> L20
        return new d(r100, r101, r103, r111);
    L20:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed, exception: " + e.getMessage());
        return null;
    }

    public static e a(String r110, String r111) {
        JSONObject r112 = new JSONObject(r110);     // Catch: Exception -> L17
        String r113 = JSONObjectProtectorUtils.getString(r112, r111);     // Catch: Exception -> L17
        if (r111.equals(ModelDistConst.EPHEMERAL_PUBLIC_KEY) == false) goto L6;
        LogUtils.d("ModelDistUtils", "EPHEMERAL_PUBLIC_KEY");     // Catch: Exception -> L17
        r113 = CryptoUtils.byteArrayToHexString(Base64.getUrlDecoder().decode(r113));     // Catch: Exception -> L17
    L7:
        LogUtils.d("ModelDistUtils", "pubKey: " + r113);     // Catch: Exception -> L17
        ByteBuffer r100 = ByteBuffer.wrap(Base64.getUrlDecoder().decode(JSONObjectProtectorUtils.getString(r112, ModelDistConst.DATA_KEY_CIPHER)));     // Catch: Exception -> L17
        int r114 = r100.getInt();     // Catch: Exception -> L17
        if (r114 == 329978795) goto L11;
        LogUtils.e("ModelDistUtils", "MagicNum: " + r114 + " mismatch!!");     // Catch: Exception -> L17
        return null;
    L11:
        byte r115 = r100.get();     // Catch: Exception -> L17
        LogUtils.d("ModelDistUtils", "version: " + r115);     // Catch: Exception -> L17
        int r101 = r100.get();     // Catch: Exception -> L17
        if (r101 == 12) goto L15;
        LogUtils.e("ModelDistUtils", "Invalid ivLen: " + r101);     // Catch: Exception -> L17
        return null;
    L15:
        LogUtils.d("ModelDistUtils", "ivLen: " + r101);     // Catch: Exception -> L17
        byte[] r116 = new byte[r101];     // Catch: Exception -> L17
        r100.get(r116);     // Catch: Exception -> L17
        LogUtils.d("ModelDistUtils", "FEK IV: " + CryptoUtils.byteArrayToHexString(r116));     // Catch: Exception -> L17
        byte[] r102 = new byte[48];     // Catch: Exception -> L17
        r100.get(r102);     // Catch: Exception -> L17
        LogUtils.d("ModelDistUtils", "FEK Cipher: " + CryptoUtils.byteArrayToHexString(r102));     // Catch: Exception -> L17
        return new e(r114, r115, r116, r102, r113);
    L6:
        LogUtils.d("ModelDistUtils", "PLATFORM_BUSINESS_PUBLIC_KEY");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "parseModelKeyCipher failed! exception: " + e.getMessage());
        return null;
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.isEmpty() == true) goto L8;
        if (r100.length() > 128) goto L8;
        return true;
    }

    public static /* synthetic */ Object b(String r100) {
        return new Object();
    }

    public static i a(Context r100, String r101) {
        j r102 = j.a();
        if (b(r100, r101) == true) goto L5;
        Object r103 = f204233a.computeIfAbsent(r101, new fj4.a());
        monitor-enter(r103);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (b(r100, r101) == false) goto L13;
        i r104 = a(r100, r101, r102);     // Catch: Throwable -> L21
        monitor-exit(r103);     // Catch: Throwable -> L21
        return r104;
    L13:
        SecureRandom r105 = new SecureRandom();     // Catch: Throwable -> L21
        byte[] r106 = new byte[32];     // Catch: Throwable -> L21
        byte[] r107 = new byte[12];     // Catch: Throwable -> L21
        r105.nextBytes(r106);     // Catch: Throwable -> L21
        r105.nextBytes(r107);     // Catch: Throwable -> L21
        i r108 = new i();     // Catch: Throwable -> L21
        r108.f204250a = r101;     // Catch: Throwable -> L21
        r108.f204251b = "AESKey";     // Catch: Throwable -> L21
        r108.f204255f = CryptoUtils.byteArrayToHexString(r106);     // Catch: Throwable -> L21
        r108.f204253d = CryptoUtils.byteArrayToHexString(r107);     // Catch: Throwable -> L21
        if (r102.a(r100, r108, new Bundle()).f204232a == 0) goto L19;
        LogUtils.e("ModelDistUtils", "Save key&iv to SecretDataService failed.");     // Catch: Throwable -> L21
        monitor-exit(r103);     // Catch: Throwable -> L21
        return null;
    L19:
        monitor-exit(r103);     // Catch: Throwable -> L21
        return r108;
    L5:
        return a(r100, r101, r102);
    }

    public static boolean b(Context r100, String r101) {
        j r102 = j.a();
        Bundle r103 = new Bundle();
        r103.putInt("query_mode", 0);
        h r104 = r102.a(r100, r101, r103);
        int r105 = r104.f204248a;
        if (r105 == 0) goto L8;
        if (r105 == (-5)) goto L8;
        r104 = r102.a(r100, r101, r103);
    L8:
        if (r104.f204248a != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public static i a(Context r100, String r101, j r102) {
        Bundle r103 = new Bundle();
        r103.putInt("query_mode", 2);
        h r104 = r102.a(r100, r101, r103);
        if (r104.f204248a == 0) goto L6;
        r104 = r102.a(r100, r101, r103);
    L6:
        if (r104.f204248a == 0) goto L8;
    L11:
        LogUtils.e("ModelDistUtils", "Query the data of the alias failed, errorCode: " + r104.f204248a);
        return null;
    L8:
        if (r104.f204249b.size() != 1) goto L11;
        return (i) ListProtector.get(r104.f204249b, 0);
    }

    public static byte[] a(Context r110, InputStream r111, String r112, String r113) {
        LogUtils.d("ModelDistUtils", "decryptModelByFEKCipher enter");
        DataInputStream r114 = new DataInputStream(r111);     // Catch: IOException -> L48
        LogUtils.i("ModelDistUtils", "in.available(): " + r111.available());     // Catch: Throwable -> L40
        d r100 = a(r114);     // Catch: Throwable -> L40
        if (r100 != null) goto L9;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed.");     // Catch: Throwable -> L40
        byte[] r101 = new byte[0];     // Catch: Throwable -> L40
        r114.close();     // Catch: IOException -> L48
        return r101;
    L9:
        int r102 = r114.readInt();     // Catch: Throwable -> L40
        if (r102 >= 0) goto L14;
        LogUtils.e("ModelDistUtils", "Model cipher length is invalid: " + r102);     // Catch: Throwable -> L40
        byte[] r103 = new byte[0];     // Catch: Throwable -> L40
        r114.close();     // Catch: IOException -> L48
        return r103;
    L14:
        LogUtils.d("ModelDistUtils", "cipherLen: " + r102);     // Catch: Throwable -> L40
        ByteArrayOutputStream r115 = new ByteArrayOutputStream();     // Catch: Throwable -> L40
        i r104 = a(r110, r113);     // Catch: Throwable -> L40
        if (r104 != null) goto L19;
        LogUtils.e("ModelDistUtils", "Get external device key failed.");     // Catch: Throwable -> L40
        byte[] r105 = new byte[0];     // Catch: Throwable -> L40
        r114.close();     // Catch: IOException -> L48
        return r105;
    L19:
        LogUtils.d("ModelDistUtils", CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(CryptoUtils.hexStringToByteArray(r104.f204255f), "SHA-256")));     // Catch: Throwable -> L40
        byte[] r106 = AES.gcmXcrypt(2, CryptoUtils.hexStringToByteArray(r104.f204255f), null, CryptoUtils.hexStringToByteArray(r104.f204253d), CryptoUtils.hexStringToByteArray(r112));     // Catch: Throwable -> L40
        if (r106 != null) goto L22;
    L37:
        LogUtils.e("ModelDistUtils", "decrypt FEKCipher failed.");     // Catch: Throwable -> L40
        byte[] r107 = new byte[0];     // Catch: Throwable -> L40
        r114.close();     // Catch: IOException -> L48
        return r107;
    L22:
        if (r106.length != 32) goto L37;
        LogUtils.d("ModelDistUtils", "FEK: " + CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r106, "SHA-256")));     // Catch: Throwable -> L40
        int r108 = ChaCha20.decryptStreamWithPoly1305(new SecretKeySpec(r106, CryptoConst.ALGORITHM_CHACHA20), r100.f204235a, r100.f204236b, r102, r111, r115);     // Catch: Throwable -> L40
        if (r108 == 0) goto L29;
        LogUtils.e("ModelDistUtils", "decrypt model cipher failed, ret: " + r108);     // Catch: Throwable -> L40
        byte[] r109 = new byte[0];     // Catch: Throwable -> L40
        r114.close();     // Catch: IOException -> L48
        return r109;
    L29:
        int r116 = a(r111, r114.readLong(), r115);     // Catch: Throwable -> L40
        if (r116 == 0) goto L34;
        LogUtils.e("ModelDistUtils", "concat model plain data failed, ret: " + r116);     // Catch: Throwable -> L40
        byte[] r117 = new byte[0];     // Catch: Throwable -> L40
        r114.close();     // Catch: IOException -> L48
        return r117;
    L34:
        byte[] r118 = r115.toByteArray();     // Catch: Throwable -> L40
        r114.close();     // Catch: IOException -> L48
        return r118;
    L40:
        th = move-exception;
        r114.close();     // Catch: Throwable -> L44
    L55:
        throw th;     // Catch: IOException -> L48
    L44:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L48
        throw th;     // Catch: IOException -> L48
    L48:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "decryptModelByFEKCipher failed, exception: " + e.getMessage());
        return new byte[0];
    }

    public static int a(Context r110, InputStream r111, OutputStream r112, String r113, String r114) {
        LogUtils.d("ModelDistUtils", "decryptModelByFEKCipher enter");
        DataInputStream r100 = new DataInputStream(r111);     // Catch: IOException -> L45
        d r101 = a(r100);     // Catch: Throwable -> L37
        if (r101 != null) goto L9;
        LogUtils.e("ModelDistUtils", "parseModelHeader failed.");     // Catch: Throwable -> L37
        r100.close();     // Catch: IOException -> L45
        return -8;
    L9:
        int r115 = r100.readInt();     // Catch: Throwable -> L37
        if (r115 >= 0) goto L14;
        LogUtils.e("ModelDistUtils", "Model cipher length is invalid: " + r115);     // Catch: Throwable -> L37
        r100.close();     // Catch: IOException -> L45
        return -8;
    L14:
        LogUtils.d("ModelDistUtils", "cipherLen: " + r115);     // Catch: Throwable -> L37
        i r102 = a(r110, r114);     // Catch: Throwable -> L37
        if (r102 != null) goto L20;
        LogUtils.e("ModelDistUtils", "Get external device key failed.");     // Catch: Throwable -> L37
        r100.close();     // Catch: IOException -> L45
        return -15;
    L20:
        LogUtils.d("ModelDistUtils", CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(CryptoUtils.hexStringToByteArray(r102.f204255f), "SHA-256")));     // Catch: Throwable -> L37
        byte[] r103 = AES.gcmXcrypt(2, CryptoUtils.hexStringToByteArray(r102.f204255f), null, CryptoUtils.hexStringToByteArray(r102.f204253d), CryptoUtils.hexStringToByteArray(r113));     // Catch: Throwable -> L37
        if (r103 != null) goto L23;
    L33:
        LogUtils.e("ModelDistUtils", "decrypt FEKCipher failed.");     // Catch: Throwable -> L37
        r100.close();     // Catch: IOException -> L45
        return -4;
    L23:
        if (r103.length != 32) goto L33;
        LogUtils.d("ModelDistUtils", "FEK: " + CryptoUtils.byteArrayToHexString(CryptoUtils.messageDigest(r103, "SHA-256")));     // Catch: Throwable -> L37
        int r104 = ChaCha20.decryptStreamWithPoly1305(new SecretKeySpec(r103, CryptoConst.ALGORITHM_CHACHA20), r101.f204235a, r101.f204236b, r115, r111, r112);     // Catch: Throwable -> L37
        if (r104 == 0) goto L30;
        LogUtils.e("ModelDistUtils", "decrypt model cipher failed, ret: " + r104);     // Catch: Throwable -> L37
        r100.close();     // Catch: IOException -> L45
        return r104;
    L30:
        int r105 = a(r111, r100.readLong(), r112);     // Catch: Throwable -> L37
        r100.close();     // Catch: IOException -> L45
        return r105;
    L37:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L41
    L52:
        throw th;     // Catch: IOException -> L45
    L41:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L45
        throw th;     // Catch: IOException -> L45
    L45:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "decryptModelByFEKCipher failed, exception: " + e.getMessage());
        return -100;
    }
}
