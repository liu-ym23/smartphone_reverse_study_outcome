package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

/* JADX INFO: loaded from: classes23.dex */
public class EncryptUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278043a = "EncryptUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278044b = "RSA";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f278045c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f278046d = true;

    private static SecureRandom a() {
        b.a(f278043a, "generateSecureRandomNew ");
    L7:
        b.b(f278043a, "getSecureRandomBytes: NoSuchAlgorithmException");
    L8:
        SecureRandom r100 = null;
    L10:
        if (r100 == null) goto L23;
    L14:
        AESEngine r101 = new AESEngine();     // Catch: Throwable -> L12 NoSuchAlgorithmException -> L19
        byte[] r102 = new byte[32];     // Catch: Throwable -> L12 NoSuchAlgorithmException -> L19
        r100.nextBytes(r102);     // Catch: Throwable -> L12 NoSuchAlgorithmException -> L19
        return new SP800SecureRandomBuilder(r100, true).setEntropyBitsRequired(384).buildCTR(r101, 256, r102, false);
    L19:
        b.b(f278043a, "NoSuchAlgorithmException");
    L20:
        return r100;
    L12:
        th = move-exception;
        if (f278046d == false) goto L20;
        b.b(f278043a, "exception : " + th.getMessage() + " , you should implementation bcprov-jdk15on library");
        f278046d = false;
        goto L20
    L23:
        r100 = SecureRandom.getInstance("SHA1PRNG");     // Catch: Throwable -> L12 NoSuchAlgorithmException -> L19
        goto L14
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L8;
        r100 = SecureRandom.getInstanceStrong();     // Catch: NoSuchAlgorithmException -> L7
        goto L10
    }

    public static SecureRandom genSecureRandom() {
        if (f278045c == true) goto L12;
    L9:
        b.b(f278043a, "genSecureRandom: NoSuchAlgorithmException");
        return null;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        SecureRandom r100 = SecureRandom.getInstanceStrong();     // Catch: NoSuchAlgorithmException -> L9
    L13:
        return r100;
    L7:
        r100 = SecureRandom.getInstance("SHA1PRNG");     // Catch: NoSuchAlgorithmException -> L9
        goto L13
    L12:
        return a();
    }

    public EncryptUtil() {
    }

    public static boolean isBouncycastleFlag() {
        return f278045c;
    }

    private static byte[] a(int r100) {
        SecureRandom r101 = a();
        if (r101 == null) goto L5;
        byte[] r102 = new byte[r100];     // Catch: NullPointerException -> L8
        r101.nextBytes(r102);     // Catch: NullPointerException -> L8
        return r102;
    L8:
        e = move-exception;
        b.b(f278043a, "secureRandom nextBytes error is : " + e.getMessage());
        return new byte[0];
    L5:
        return new byte[0];
    }

    public static byte[] generateSecureRandom(int r100) {
        if (f278045c == true) goto L21;
        byte[] r101 = new byte[r100];
    L9:
        b.b(f278043a, "getSecureRandomBytes: NoSuchAlgorithmException");
    L10:
        SecureRandom r102 = null;
    L11:
        if (r102 == null) goto L24;
    L13:
        r102.nextBytes(r101);     // Catch: Exception -> L15 NoSuchAlgorithmException -> L17
        return r101;
    L17:
        b.b(f278043a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
    L19:
        return new byte[0];
    L15:
        e = move-exception;
        b.b(f278043a, "getSecureRandomBytes getInstance: exception : " + e.getMessage());
        goto L19
    L24:
        r102 = SecureRandom.getInstance("SHA1PRNG");     // Catch: Exception -> L15 NoSuchAlgorithmException -> L17
        goto L13
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r102 = SecureRandom.getInstanceStrong();     // Catch: NoSuchAlgorithmException -> L9
        goto L11
    L21:
        return a(r100);
    }

    public static String generateSecureRandomStr(int r100) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(r100));
    }

    public static PrivateKey getPrivateKey(String r100) {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(r100, 0)));
    L6:
        e = move-exception;
        b.b(f278043a, "load Key Exception:" + e.getMessage());
        return null;
    L12:
        b.b(f278043a, "base64 decode IllegalArgumentException");
        return null;
    L9:
        e = move-exception;
        b.b(f278043a, "base64 decode Exception" + e.getMessage());
        return null;
    }

    public static RSAPublicKey getPublicKey(String r100) {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(r100, 0)));
    L6:
        e = move-exception;
        b.b(f278043a, "load Key Exception:" + e.getMessage());
        return null;
    L12:
        b.b(f278043a, "base64 decode IllegalArgumentException");
        return null;
    L9:
        e = move-exception;
        b.b(f278043a, "base64 decode Exception" + e.getMessage());
        return null;
    }

    public static void setBouncycastleFlag(boolean r100) {
        b.c(f278043a, "setBouncycastleFlag: " + r100);
        f278045c = r100;
    }
}
