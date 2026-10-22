package com.facebook.net;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.facebook.common.logging.FLog;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes23.dex */
public class EncryptUtil {
    public static final String ANDROID_TRANSFORMATION = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    public static final int MAX_DECRYPT_SIZE = 1000;
    public static final int MAX_ENCRYPT_SIZE = 1000;
    private static final String TAG = "EncryptUtil";

    public EncryptUtil() {
    }

    public static PublicKey getPublicKey(String r100) throws Exception {
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(Base64.decode(r100.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replace("-----BEGIN RSA PUBLIC KEY-----", "").replace("-----END RSA PUBLIC KEY-----", "").replace("\n", ""), 0));
        return KeyFactory.getInstance(d.f25615a).generatePublic(r101);
    }

    public static byte[] encryptByPublicKey(byte[] r110, RSAPublicKey r111) throws Exception {
        Cipher r100 = Cipher.getInstance(ANDROID_TRANSFORMATION);
        r100.init(1, r111);
        int r112 = r100.getOutputSize(r110.length);
        byte[] r101 = new byte[r112];
        FLog.e(TAG, "encryptByPublicKey: data.len = " + r110.length + " outLen = " + r112);
        int r113 = r110.length / 1000;
        int r102 = 0;
        int r114 = 0;
        int r115 = 0;
    L3:
        if (r102 >= r113) goto L6;
        int r103 = r100.update(r110, r114, 1000, r101, r115);
        FLog.e(TAG, "encryptByPublicKey: outLen = " + r103 + " inLen = 1000");
        r114 = r114 + 1000;
        r115 = r115 + r103;
        r102 = r102 + 1;
        goto L3
    L6:
        if (r114 > r110.length) goto L9;
        r100.update(r110, r114, r110.length - r114, r101, r115);
    L9:
        return r100.doFinal();
    }

    public static String encryptByPublicKey(String r100, String r101) {
        return Base64.encodeToString(encryptByPublicKey(r101.getBytes(), (RSAPublicKey) getPublicKey(r100)), 2);
    L6:
        e = move-exception;
        FLog.d(TAG, "encryptByPublicKey:2 Exception = " + e);
        e.printStackTrace();
        return "";
    L9:
        e = move-exception;
        FLog.d(TAG, "encryptByPublicKey:getPublicKey exception = " + e);
        e.printStackTrace();
        return "";
    }
}
