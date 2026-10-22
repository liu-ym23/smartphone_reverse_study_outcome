package com.bytedance.crypto.engine;

import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.LogUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes15.dex */
public class AES {
    public static final String TAG = "AES";

    public AES() {
    }

    public static byte[] gcmXcrypt(int r100, byte[] r101, byte[] r102, byte[] r103, byte[] r110) {
        String r104 = TAG;
        LogUtils.i(r104, "gcmXcrypt enter, mode: " + r100);
        StringBuilder r105 = new StringBuilder("gcmXcrypt enter, aadLen: ");
        if (r102 != null) goto L5;
        int r106 = 0;
    L6:
        r105.append(r106);
        LogUtils.i(r104, r105.toString());
        byte[] r107 = new byte[0];
        SecretKeySpec r108 = new SecretKeySpec(r101, CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L14
        Cipher r109 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L14
        r109.init(r100, r108, new GCMParameterSpec(128, r103));     // Catch: Exception -> L14
        if (r102 != null) goto L10;
    L12:
        r107 = r109.doFinal(r110);     // Catch: Exception -> L14
        LogUtils.i(r104, "gcmXcrypt success, mode: " + r100 + ", outputLen: " + r107.length);     // Catch: Exception -> L14
        return r107;
    L10:
        if (r102.length <= 0) goto L12;
        r109.updateAAD(r102);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        LogUtils.e(TAG, "AES-GCM xcrypt failed, mode:" + r100 + " error:" + e.getMessage());
        return r107;
    L5:
        r106 = r102.length;
        goto L6
    }
}
