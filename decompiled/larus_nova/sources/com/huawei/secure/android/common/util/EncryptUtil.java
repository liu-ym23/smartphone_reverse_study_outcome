package com.huawei.secure.android.common.util;

import android.os.Build;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes23.dex */
public class EncryptUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278203a = "EncryptUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278204b = "RSA";

    public EncryptUtil() {
    }

    public static byte[] generateSecureRandom(int r100) {
        byte[] r101 = new byte[r100];
    L7:
        LogsUtil.e(f278203a, "getSecureRandomBytes: NoSuchAlgorithmException");
    L8:
        SecureRandom r102 = null;
    L9:
        if (r102 == null) goto L20;
    L11:
        r102.nextBytes(r101);     // Catch: Exception -> L13 NoSuchAlgorithmException -> L15
        return r101;
    L15:
        LogsUtil.e(f278203a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
    L17:
        return new byte[0];
    L13:
        e = move-exception;
        LogsUtil.e(f278203a, "getSecureRandomBytes getInstance: exception : " + e.getMessage());
        goto L17
    L20:
        r102 = SecureRandom.getInstance("SHA1PRNG");     // Catch: Exception -> L13 NoSuchAlgorithmException -> L15
        goto L11
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L8;
        r102 = SecureRandom.getInstanceStrong();     // Catch: NoSuchAlgorithmException -> L7
        goto L9
    }

    public static String generateSecureRandomStr(int r100) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(r100));
    }

    public static PrivateKey getPrivateKey(String r100) {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(r100, 0)));
    L6:
        e = move-exception;
        LogsUtil.e(f278203a, "load Key Exception:" + e.getMessage(), true);
        return null;
    L11:
        LogsUtil.e(f278203a, "base64 decode IllegalArgumentException", true);
        return null;
    L9:
        LogsUtil.e(f278203a, "base64 decode Exception", true);
        return null;
    }

    public static RSAPublicKey getPublicKey(String r100) {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(r100, 0)));
    L6:
        e = move-exception;
        LogsUtil.e(f278203a, "load Key Exception:" + e.getMessage(), true);
        return null;
    L11:
        LogsUtil.e(f278203a, "base64 decode IllegalArgumentException", true);
        return null;
    L9:
        LogsUtil.e(f278203a, "base64 decode Exception", true);
        return null;
    }
}
