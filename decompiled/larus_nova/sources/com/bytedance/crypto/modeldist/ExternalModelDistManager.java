package com.bytedance.crypto.modeldist;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ECDHHelper;
import com.bytedance.crypto.engine.KeyPairHelper;
import com.bytedance.crypto.network.ChallengeManager;
import com.bytedance.crypto.obfuscated.b;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.d;
import com.bytedance.crypto.obfuscated.e;
import com.bytedance.crypto.obfuscated.i;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.LogUtils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes15.dex */
public class ExternalModelDistManager {
    public static final String TAG = "ExternalModelDistManager";
    private static volatile ExternalModelDistManager externalModelDistManager;

    private ExternalModelDistManager() {
    }

    public static ExternalModelDistManager getInstance() {
        if (externalModelDistManager != null) goto L15;
        monitor-enter(ExternalModelDistManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (externalModelDistManager != null) goto L9;
        externalModelDistManager = new ExternalModelDistManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ExternalModelDistManager.class);     // Catch: Throwable -> L11
    L15:
        return externalModelDistManager;
    }

    public int checkModelIntegrity(InputStream r100) {
        return c.a().a(r100);
    }

    public int decryptModelFile(Context r100, InputStream r101, OutputStream r102, String r103) {
        return c.a().a(r100, r101, r102, r103);
    }

    public long calculateModelSize(InputStream r110) {
        c.a().getClass();
        ConcurrentHashMap<String, Object> r100 = b.f204233a;
        if (r110 != null) goto L37;
        LogUtils.e("ModelDistUtils", "InputStream is null.");
        return -2;
    L37:
        DataInputStream r101 = new DataInputStream(r110);     // Catch: IOException -> L32
        d r111 = b.a(r101);     // Catch: Throwable -> L26
        if (r111 != null) goto L9;
        String r112 = "parseModelHeader failed.";
    L17:
        LogUtils.e("ModelDistUtils", r112);     // Catch: Throwable -> L26
        long r102 = -8;
    L24:
        r101.close();     // Catch: IOException -> L32
        return r102;
    L9:
        int r103 = r101.readInt();     // Catch: Throwable -> L26
        if (r103 >= 0) goto L14;
        StringBuilder r113 = new StringBuilder("Model cipher length is invalid: ");     // Catch: Throwable -> L26
        r113.append(r103);     // Catch: Throwable -> L26
    L13:
        r112 = r113.toString();     // Catch: Throwable -> L26
        goto L17
    L14:
        r101.skip(r103);     // Catch: Throwable -> L26
        long r104 = r101.readLong();     // Catch: Throwable -> L26
        if (r104 >= 0) goto L18;
        r113 = new StringBuilder("Model cipher length is invalid: ");     // Catch: Throwable -> L26
        r113.append(r104);     // Catch: Throwable -> L26
        goto L13
    L18:
        int r114 = r111.f204236b;     // Catch: Throwable -> L26
        int r105 = r114 + 16;     // Catch: Throwable -> L26
        int r106 = r103 / r105;     // Catch: Throwable -> L26
        int r107 = r103 % r105;     // Catch: Throwable -> L26
        int r108 = r106 * r114;
        if (r107 == 0) goto L23;
        r108 = r108 + (r107 - 16);
    L23:
        r102 = ((long) r108) + r104;
    L26:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: IOException -> L32
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L32
    L32:
        e = move-exception;
        LogUtils.e("ModelDistUtils", "calculateModelSize failed, exception: " + e.getMessage());
        return -100;
    }

    public int deleteAttestKey(Context r100, String r101) {
        c.a().getClass();
        if (r100 != null) goto L5;
    L8:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return -2;
    L5:
        if (b.a(r101) == false) goto L8;
        KeyPairHelper.deleteKey(r101);
        return 0;
    }

    public ModelInitResult initModelRequest(Context r100, String r101, Bundle r102) {
        c.a().getClass();
        if (r100 != null) goto L5;
    L35:
        LogUtils.e("ModelDistributionManagerImpl", "Invalid input params.");
        return new ModelInitResult(-2, "");
    L5:
        if (b.a(r101) == false) goto L35;
        if (r102 == null) goto L35;
        int r103 = r102.getInt(ModelDistConst.KEY_ATTEST_STRATEGY, 0);
        Certificate[] r104 = null;
        Certificate[] r105 = KeyPairHelper.getCertificateChain(r101);     // Catch: CloudTransException -> L11
    L13:
        if (r105 != null) goto L15;
    L21:
        String r106 = ChallengeManager.requestChallenge();
        if (r106 != null) goto L24;
    L30:
        String r107 = "Request challenge failed!!";
    L31:
        LogUtils.e("ModelDistUtils", r107);
    L32:
        if (r104 != null) goto L44;
        return new ModelInitResult(-100, "");
    L44:
        return b.a(Arrays.asList(r104), false);
    L24:
        if (r106.isEmpty() == true) goto L30;
        KeyPairHelper.deleteKey(r101);     // Catch: CloudTransException -> L28
        KeyPairHelper.generateECDSAKeyPair(r101, r106);     // Catch: CloudTransException -> L28
        r104 = KeyPairHelper.getCertificateChain(r101);     // Catch: CloudTransException -> L28
    L28:
        e = move-exception;
        r107 = "generateECDSAKeyPair failed, errorCode: " + e.getErrorCode() + ", message: " + e.getMessage();
        goto L31
    L15:
        if (r103 != 1) goto L18;
        return b.a(Arrays.asList(r105), false);
    L18:
        if (r103 == 2) goto L42;
        LogUtils.i("ModelDistributionManagerImpl", "Re-generating certificate chain as per strategy.");
        goto L21
    L42:
        return new ModelInitResult(-13, "");
    L11:
        e = move-exception;
        LogUtils.e("ModelDistributionManagerImpl", "getCertificateChain of alias: " + r101 + " failed, exception: " + e.getMessage());
        r105 = null;
        goto L13
    }

    public String reEncryptFEK(Context r100, String r101, String r102) {
        c.a().getClass();
        if (r100 != null) goto L5;
    L30:
        String r103 = "Invalid input params.";
    L31:
        LogUtils.e("ModelDistributionManagerImpl", r103);
        return null;
    L5:
        if (b.a(r101) == false) goto L30;
        if (r102 == null) goto L30;
        LogUtils.d("ModelDistributionManagerImpl", "reEncryptFEK keyInfo: ".concat(r102));
        e r104 = b.a(r102, ModelDistConst.EPHEMERAL_PUBLIC_KEY);
        if (r104 != null) goto L33;
        LogUtils.e("ModelDistributionManagerImpl", "Parse model key cipher failed!!");
        return null;
    L33:
        byte[] r105 = ECDHHelper.generateSharedSecret(KeyPairHelper.loadKeyPair(r101).getPrivate(), CryptoUtils.byteArrayToECPublicKey(CryptoUtils.hexStringToByteArray(r104.f204239c)));     // Catch: Exception -> L25 CloudTransException -> L27
        LogUtils.d("ModelDistributionManagerImpl", "sharedSecret.length: " + r105.length);     // Catch: Exception -> L25 CloudTransException -> L27
        byte[] r106 = AES.gcmXcrypt(2, r105, null, r104.f204237a, r104.f204238b);
        if (r106.length == 32) goto L15;
        r103 = "decrypt dataKeyCipher failed or dataKey length invalid";
        goto L31
    L15:
        i r107 = b.a(r100, ModelDistConst.EXTERNAL_DEVICE_KEY_ALIAS);
        if (r107 != null) goto L18;
        r103 = "prepareExternalDeviceKey failed.";
        goto L31
    L18:
        byte[] r108 = AES.gcmXcrypt(1, CryptoUtils.hexStringToByteArray(r107.f204255f), null, CryptoUtils.hexStringToByteArray(r107.f204253d), r106);
        if (r108 != null) goto L21;
    L24:
        r103 = "Re-encrypt FEK failed.";
        goto L31
    L21:
        if (r108.length == 0) goto L24;
        return CryptoUtils.byteArrayToHexString(r108);
    L27:
        e = move-exception;
        StringBuilder r109 = new StringBuilder("loadKeyPair failed, errorCode: ");
        r109.append(e.getErrorCode());
        r109.append(", message: ");
        Exception r110 = e;
    L29:
        r109.append(r110.getMessage());
        r103 = r109.toString();
    L25:
        e = move-exception;
        r109 = new StringBuilder("generateSharedSecret failed, exception: ");
        r110 = e;
        goto L29
    }
}
