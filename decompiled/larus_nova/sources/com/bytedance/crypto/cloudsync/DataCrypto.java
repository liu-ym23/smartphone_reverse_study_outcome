package com.bytedance.crypto.cloudsync;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.keymanager.SyncKeyManager;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.SecretKey;
import kotlin.UByte;

/* JADX INFO: loaded from: classes15.dex */
public class DataCrypto {
    public static final String TAG = "DataCrypto";
    private static volatile DataCrypto dataCrypto;

    public DataCrypto() {
    }

    private byte[] bytesDecrypt(Context r100, int r101, String r102, byte[] r110) {
        byte[] r103 = new byte[4];
        if (r110.length >= 4) goto L9;
        String r104 = TAG;
        StringBuilder r105 = new StringBuilder("Input data len is too short! len:");
    L5:
        r105.append(r110.length);
    L6:
        String r106 = r105.toString();
    L7:
        LogUtils.e(r104, r106);
        return new byte[0];
    L9:
        System.arraycopy(r110, 0, r103, 0, 4);
        int r107 = CryptoUtils.byteArrayToInt(r103);
        if (r107 == 315429581) goto L13;
        r104 = TAG;
        r105 = new StringBuilder("Cannot parse input cipher data! magic:");
        r105.append(r107);
        goto L6
    L13:
        if (r110.length >= 5) goto L15;
        r104 = TAG;
        r105 = new StringBuilder("Input data len is too short!! len:");
        goto L5
    L15:
        int r108 = r110[4] & UByte.MAX_VALUE;
        if (r108 == 1) goto L21;
        if (r108 == 2) goto L21;
        r104 = TAG;
        r105 = new StringBuilder("Input cipher data version is wrong! version:");
        r105.append(r108);
    L21:
        if (r110.length >= 17) goto L23;
        r104 = TAG;
        r105 = new StringBuilder("Input data len is too short for iv! len:");
        goto L5
    L23:
        byte[] r109 = new byte[12];
        System.arraycopy(r110, 5, r109, 0, 12);
        if (r110.length >= 82) goto L26;
        r104 = TAG;
        r105 = new StringBuilder("Input data len is too short for key cipher! len:");
        goto L5
    L26:
        byte[] r111 = new byte[65];
        System.arraycopy(r110, 17, r111, 0, 65);
        if (r110.length >= 98) goto L29;
        r104 = TAG;
        r105 = new StringBuilder("Input data len is too short for data cipher! len:");
        goto L5
    L29:
        int r112 = r110.length - 82;
        byte[] r113 = new byte[r112];
        System.arraycopy(r110, 82, r113, 0, r112);
        String r114 = CloudConfig.getInstance().getPkgName(r102) + r102;
        byte[] r115 = SyncKeyManager.getInstance().decryptByKeyManager(r100, r102, r111, r114);
        if (r115 != null) goto L32;
    L41:
        r104 = TAG;
        r106 = "Data key decrypt failed!!";
        goto L7
    L32:
        if (r115.length == 0) goto L41;
        byte[] r116 = AES.gcmXcrypt(r101, r115, r114.getBytes(), r109, r113);
        if (r116 != null) goto L37;
    L40:
        r104 = TAG;
        r106 = "AES GCM decrypt failed!!";
        goto L7
    L37:
        if (r116.length == 0) goto L40;
        return r116;
    }

    private byte[] bytesEncrypt(Context r100, int r101, String r102, byte[] r110) {
        byte[] r103 = CryptoUtils.generateSecureRandom(32);
        if (r103.length != 0) goto L8;
        String r104 = TAG;
        String r105 = "Generate data key failed!!";
    L5:
        LogUtils.e(r104, r105);
    L7:
        return new byte[0];
    L8:
        byte[] r106 = CryptoUtils.generateSecureRandom(12);
        if (r106.length != 0) goto L11;
        r104 = TAG;
        r105 = "Generate IV failed!!";
        goto L5
    L11:
        String r107 = CloudConfig.getInstance().getPkgName(r102) + r102;
        byte[] r108 = AES.gcmXcrypt(r101, r103, r107.getBytes(), r106, r110);
        if (r108 != null) goto L14;
    L27:
        r104 = TAG;
        r105 = "AES GCM encrypt failed!!";
        goto L5
    L14:
        if (r108.length == 0) goto L27;
        byte[] r109 = SyncKeyManager.getInstance().encryptByKeyManager(r100, r102, r103, r107);
        if (r109 != null) goto L19;
    L26:
        r104 = TAG;
        r105 = "Data key encrypt failed!!";
        goto L5
    L19:
        if (r109.length == 0) goto L26;
        if (r109.length == 65) goto L24;
        LogUtils.e(TAG, "Data key cipher length is error, length:" + r109.length);
        goto L7
    L24:
        byte[] r111 = new byte[(r109.length + 17) + r108.length];
        System.arraycopy(CryptoUtils.intToBytes(CryptoConst.BYTES_CIPHER_MAGIC_NUM), 0, r111, 0, 4);
        r111[4] = 2;
        System.arraycopy(r106, 0, r111, 5, 12);
        System.arraycopy(r109, 0, r111, 17, 65);
        System.arraycopy(r108, 0, r111, 82, r108.length);
        return r111;
    }

    private int checkInputParams(Context r100, int r101, String r102, byte[] r103) {
        if (r100 != null) goto L7;
        String r104 = TAG;
        String r105 = "Context is null!!";
    L5:
        LogUtils.e(r104, r105);
        return -2;
    L7:
        if (r103 != null) goto L9;
    L27:
        r104 = TAG;
        r105 = "Input data is empty!!";
        goto L5
    L9:
        if (r103.length == 0) goto L27;
        if (r101 != 1) goto L14;
        int r106 = 1048576;
    L16:
        if (r103.length <= r106) goto L19;
        r104 = TAG;
        r105 = "Input data is too large!! len:" + r103.length;
        goto L5
    L19:
        if (TextUtils.isEmpty(r102) == false) goto L21;
        r104 = TAG;
        r105 = "Input alias is empty!!";
        goto L5
    L21:
        if (r101 != 1) goto L23;
    L25:
        LogUtils.i(TAG, "Byte xcrypt params check ok, mode:" + r101 + ", alias:" + r102 + ", data len:" + r103.length);
        return 0;
    L23:
        if (r101 == 2) goto L25;
        r104 = TAG;
        r105 = "Input mode is invalid!! mode:" + r101;
        goto L5
    L14:
        r106 = CryptoConst.DECRYPT_BYTES_MAX_SIZE;
        goto L16
    }

    private int checkInputParams(CryptoContext r100, int r101, InputStream r102, OutputStream r103) {
        if (r100 != null) goto L7;
        String r104 = TAG;
        String r105 = "CryptoContext is null!!";
    L5:
        LogUtils.e(r104, r105);
        return -2;
    L7:
        if (r102 == null) goto L32;
        if (r103 == null) goto L32;
        if (TextUtils.isEmpty(r100.getAppId()) == false) goto L14;
        r104 = TAG;
        r105 = "Input appid is empty!!";
        goto L5
    L14:
        if (r101 == 1) goto L33;
        if (r101 == 2) goto L33;
        r104 = TAG;
        r105 = "Input mode is invalid!! mode:" + r101;
    L33:
        int r106 = r102.available();     // Catch: Exception -> L21
    L23:
        if (r101 != 1) goto L25;
        int r107 = 1073741824;
    L26:
        if (r106 == 0) goto L31;
        if (r106 > r107) goto L31;
        LogUtils.i(TAG, "Stream xcrypt params check ok, mode:" + r101 + ", app:" + r100.getAppId() + ", data len:" + r106);
        return 0;
    L31:
        r104 = TAG;
        r105 = "Input stream data is empty or too large, len:" + r106;
        goto L5
    L25:
        r107 = CryptoConst.DECRYPT_STREAM_MAX_SIZE;
    L21:
        e = move-exception;
        LogUtils.e(TAG, "Input stream each block is encrypted, a TAG will be added to the ciphertexteach block is encrypted, a TAG will be added to the ciphertextatch exception:" + e.getMessage());
        r106 = 0;
    L32:
        r104 = TAG;
        r105 = "Input stream is null!!";
        goto L5
    }

    public static DataCrypto getInstance() {
        if (dataCrypto != null) goto L15;
        monitor-enter(DataCrypto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (dataCrypto != null) goto L9;
        dataCrypto = new DataCrypto();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DataCrypto.class);     // Catch: Throwable -> L11
    L15:
        return dataCrypto;
    }

    public byte[] bytesXcrypt(Context r110, int r111, String r112, byte[] r113) {
        int r100 = checkInputParams(r110, r111, r112, r113);
        if (r111 != 1) goto L5;
        int r101 = 4;
    L7:
        if (r100 == 0) goto L10;
        LogUtils.e(TAG, "Input param is invalid!!");
        int r102 = r101;
        EventTrace.eventTrace(r100, r102, r110.getPackageName(), r112, 0, 0);
        return new byte[0];
    L10:
        long r103 = System.currentTimeMillis();
        if (r111 != 1) goto L13;
        byte[] r114 = bytesEncrypt(r110, r111, r112, r113);
    L14:
        long r104 = System.currentTimeMillis() - r103;
        if (r114.length != 0) goto L17;
        int r105 = -4;
    L18:
        EventTrace.eventTrace(r105, r101, r110.getPackageName(), r112, r104, r113.length);
        return r114;
    L17:
        r105 = 0;
        goto L18
    L13:
        r114 = bytesDecrypt(r110, r111, r112, r113);
        goto L14
    L5:
        r101 = 5;
        goto L7
    }

    public int streamXcrypt(CryptoContext r210, int r211, InputStream r212, OutputStream r213) {
        int r100 = checkInputParams(r210, r211, r212, r213);
        if (r100 == 0) goto L6;
        LogUtils.e(TAG, "Input param is invalid!!");
        return r100;
    L6:
        long r101 = System.currentTimeMillis();
        if (r211 != 1) goto L45;
        SecretKey r102 = r210.getFileEncryptKey();
        LogUtils.d(TAG, "data key len:" + r102.getEncoded().length);
        byte[] r103 = CryptoUtils.generateSecureRandom(12);     // Catch: Exception -> L11
        r213.write(CryptoUtils.intToBytes(CryptoConst.STREAM_CIPHER_MAGIC_NUM));     // Catch: Exception -> L11
        r213.write(2);     // Catch: Exception -> L11
        r213.write(r103.length);     // Catch: Exception -> L11
        r213.write(r103);     // Catch: Exception -> L11
        int r104 = ChaCha20.encryptStreamWithPoly1305(r102, r103, 32768, r212.available(), r212, r213);     // Catch: Exception -> L11
    L10:
        int r110 = r104;
    L35:
        long r105 = System.currentTimeMillis() - r101;
        int r214 = r212.available();     // Catch: Exception -> L38
    L40:
        if (r211 != 1) goto L42;
        int r111 = 6;
    L43:
        EventTrace.eventTrace(r110, r111, r210.getContext().getPackageName(), r210.getAppId(), r105, r214);
        LogUtils.i(TAG, "Stream xcrypt end. result:" + r110 + " cost time:" + r105);
        return r110;
    L42:
        r111 = 7;
    L38:
        e = move-exception;
        LogUtils.e(TAG, "Get input stream length failed, exception:" + e.getMessage());
        r214 = 0;
    L11:
        e = e;
        String r106 = TAG;
        StringBuilder r107 = new StringBuilder("Data encrypt failed! exception:");
    L34:
        r107.append(e.getMessage());
        LogUtils.e(r106, r107.toString());
        r110 = -4;
        goto L35
    L45:
        byte[] r112 = new byte[4];     // Catch: Exception -> L32
        r212.read(r112);     // Catch: Exception -> L32
        int r113 = CryptoUtils.byteArrayToInt(r112);     // Catch: Exception -> L32
        if (r113 == 313201323) goto L18;
        LogUtils.e(TAG, "Cannot parse input cipher data! magic:" + r113);     // Catch: Exception -> L32
        return -2;
    L18:
        int r108 = r212.read();     // Catch: Exception -> L32
        String r109 = TAG;     // Catch: Exception -> L32
        LogUtils.i(r109, "Cipher Version:" + r108);     // Catch: Exception -> L32
        if (r108 == 2) goto L23;
        if (r108 == 1) goto L23;
        LogUtils.e(r109, "Input cipher data version is wrong! version:" + r108);     // Catch: Exception -> L32
        return -2;
    L23:
        int r114 = r212.read();     // Catch: Exception -> L32
        LogUtils.d(r109, "ivLen:" + r114);     // Catch: Exception -> L32
        if (r114 == 12) goto L27;
        LogUtils.e(r109, "IV length is wrong! len:" + r114);     // Catch: Exception -> L32
        return -2;
    L27:
        byte[] r115 = new byte[r114];     // Catch: Exception -> L32
        r212.read(r115);     // Catch: Exception -> L32
        SecretKey r116 = r210.getFileEncryptKey();     // Catch: Exception -> L32
        LogUtils.d(r109, "data key len:" + r116.getEncoded().length);     // Catch: Exception -> L32
        if (r108 != 2) goto L30;
        r104 = ChaCha20.decryptStreamWithPoly1305(r116, r115, 32768, r212.available(), r212, r213);     // Catch: Exception -> L32
        goto L10
    L30:
        r104 = ChaCha20.decryptStream(r116, r115, r212, r213);     // Catch: Exception -> L32
    L32:
        e = e;
        r106 = TAG;
        r107 = new StringBuilder("Data decrypt failed! exception:");
        goto L34
    }
}
