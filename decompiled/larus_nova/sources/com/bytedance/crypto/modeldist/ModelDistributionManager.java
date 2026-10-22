package com.bytedance.crypto.modeldist;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.engine.AES;
import com.bytedance.crypto.engine.ChaCha20;
import com.bytedance.crypto.obfuscated.b;
import com.bytedance.crypto.obfuscated.c;
import com.bytedance.crypto.obfuscated.d;
import com.bytedance.crypto.obfuscated.e;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes15.dex */
public class ModelDistributionManager {
    private static final String TAG = "ModelDistributionManager";
    private static volatile ModelDistributionManager modelDistributionManager;

    private ModelDistributionManager() {
    }

    public static ModelDistributionManager getInstance() {
        if (modelDistributionManager != null) goto L15;
        monitor-enter(ModelDistributionManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (modelDistributionManager != null) goto L9;
        modelDistributionManager = new ModelDistributionManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ModelDistributionManager.class);     // Catch: Throwable -> L11
    L15:
        return modelDistributionManager;
    }

    public int checkModelIntegrity(InputStream r100) {
        return c.a().a(r100);
    }

    public ModelInitResult initModelRequest(Context r100, String r101, Bundle r102) {
        return c.a().a(r100, r101, "", r102);
    }

    public ModelInitResult initModelRequestV2(Context r100, String r101, String r102, Bundle r103) {
        return c.a().a(r100, r101, r102, r103);
    }

    public int deleteAttestKey(Context r100, String r101) {
        c.a().getClass();
        if (r100 != null) goto L5;
    L8:
        return -2;
    L5:
        if (b.a(r101) == false) goto L8;
        return FrameworkSecurityCompat.deleteKey(r100, r101, new Bundle());
    }

    public int decryptModelFile(Context r110, InputStream r111, OutputStream r112, String r113, String r114) {
        c.a().getClass();
        if (r110 == null) goto L43;
        if (r111 == null) goto L43;
        if (r112 == null) goto L43;
        if (b.a(r113) == false) goto L43;
        if (r114 == null) goto L43;
        DataInputStream r115 = new DataInputStream(r111);     // Catch: IOException -> L41
        d r100 = b.a(r115);     // Catch: Throwable -> L33
        int r101 = -8;
        if (r100 != null) goto L16;
        String r102 = "Parse model file header information failed.";
    L15:
        LogUtils.e("ModelDistributionManagerImpl", r102);     // Catch: Throwable -> L33
    L31:
        r115.close();     // Catch: IOException -> L41
        return r101;
    L16:
        e r103 = b.a(r114, ModelDistConst.EPHEMERAL_PUBLIC_KEY);     // Catch: Throwable -> L33
        if (r103 != null) goto L19;
        r102 = "Parse model key cipher failed.";
        goto L15
    L19:
        Bundle r104 = new Bundle();     // Catch: Throwable -> L33
        r104.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());     // Catch: Throwable -> L33
        r104.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);     // Catch: Throwable -> L33
        FrameworkSecurityCompat.KmResult r105 = FrameworkSecurityCompat.keyAgreement(r110, r113, CryptoUtils.hexStringToByteArray(r103.f204239c), r104);     // Catch: Throwable -> L33
        if (r105.getResultCode() == FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L22;
        LogUtils.e("ModelDistributionManagerImpl", "keyAgreement failed, system errorCode: " + r105.getResultCode());     // Catch: Throwable -> L33
        r101 = -100;
        goto L31
    L22:
        byte[] r106 = AES.gcmXcrypt(2, r105.getOutData(), null, r103.f204237a, r103.f204238b);     // Catch: Throwable -> L33
        if (r106.length == 32) goto L25;
        LogUtils.e("ModelDistributionManagerImpl", "decrypt dataKeyCipher failed or dataKey length invalid");     // Catch: Throwable -> L33
        r101 = -4;
        goto L31
    L25:
        SecretKeySpec r107 = new SecretKeySpec(r106, CryptoConst.ALGORITHM_CHACHA20);     // Catch: Throwable -> L33
        int r108 = r115.readInt();     // Catch: Throwable -> L33
        LogUtils.d("ModelDistributionManagerImpl", "cipherLength: " + r108);     // Catch: Throwable -> L33
        int r109 = ChaCha20.decryptStreamWithPoly1305(r107, r100.f204235a, r100.f204236b, r108, r111, r112);     // Catch: Throwable -> L33
        if (r109 == 0) goto L30;
        LogUtils.e("ModelDistributionManagerImpl", "decrypt model cipher failed, ret: " + r109);     // Catch: Throwable -> L33
        r115.close();     // Catch: IOException -> L41
        return r109;
    L30:
        r101 = b.a(r111, r115.readLong(), r112);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r115.close();     // Catch: Throwable -> L37
    L49:
        throw th;     // Catch: IOException -> L41
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L41
        throw th;     // Catch: IOException -> L41
    L41:
        e = move-exception;
        LogUtils.e("ModelDistributionManagerImpl", "decryptModelFile failed, exception: " + e.getMessage());
        return -100;
    L43:
        LogUtils.e("ModelDistributionManagerImpl", "Input params is invalid.");
        return -2;
    }
}
