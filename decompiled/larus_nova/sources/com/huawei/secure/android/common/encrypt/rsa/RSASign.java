package com.huawei.secure.android.common.encrypt.rsa;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public abstract class RSASign {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278032a = "SHA256WithRSA";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278033b = "SHA256WithRSA/PSS";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278034c = "RSASign";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f278035d = "UTF-8";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f278036e = "";

    public static boolean isBuildVersionHigherThan23() {
        if (Build.VERSION.SDK_INT <= 23) goto L5;
        return true;
    L5:
        return false;
    }

    public RSASign() {
    }

    public static String newSign(String r100, String r101) {
        if (isBuildVersionHigherThan23() == true) goto L7;
        b.b(f278034c, "sdk version is too low");
        return "";
    L7:
        return a(r100, r101, true);
    }

    public static String sign(String r100, String r101) {
        return a(r100, r101, false);
    }

    public static String newSign(String r100, PrivateKey r101) {
        if (isBuildVersionHigherThan23() == true) goto L7;
        b.b(f278034c, "sdk version is too low");
        return "";
    L7:
        return a(r100, r101, true);
    }

    public static String sign(String r100, PrivateKey r101) {
        return a(r100, r101, false);
    }

    private static String a(String r100, PrivateKey r101, boolean r102) {
        return Base64.encodeToString(sign(r100.getBytes("UTF-8"), r101, r102), 0);
    L4:
        e = move-exception;
        b.b(f278034c, "sign UnsupportedEncodingException: " + e.getMessage());
        return "";
    }

    public static boolean newVerifySign(String r100, String r101, String r102) {
        if (isBuildVersionHigherThan23() == true) goto L7;
        b.b(f278034c, "sdk version is too low");
        return false;
    L7:
        return a(r100, r101, r102, true);
    }

    public static byte[] sign(ByteBuffer r100, PrivateKey r110, boolean r111) {
        byte[] r101 = new byte[0];
        if (r100 == null) goto L29;
        if (r110 == null) goto L29;
    L19:
        b.b(f278034c, "sign: ClassCastException");
        return r101;
    L20:
        e = move-exception;
        b.b(f278034c, "sign InvalidAlgorithmParameterException: " + e.getMessage());
        return r101;
    L24:
        e = move-exception;
        b.b(f278034c, "sign InvalidKeyException: " + e.getMessage());
        return r101;
    L26:
        e = move-exception;
        b.b(f278034c, "sign NoSuchAlgorithmException: " + e.getMessage());
        return r101;
    L22:
        e = move-exception;
        b.b(f278034c, "sign SignatureException: " + e.getMessage());
        return r101;
    L17:
        e = move-exception;
        b.b(f278034c, "sign Exception: " + e.getMessage());
        return r101;
    L7:
        if (RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) r110) == true) goto L10;
        b.b(f278034c, "privateKey length is too short");     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        return r101;
    L10:
        if (r111 == false) goto L14;
        Signature r112 = Signature.getInstance(f278033b);     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        r112.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
    L15:
        r112.initSign(r110);     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        r112.update(r100);     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        byte[] r102 = r112.sign();     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        b.c(f278034c, "result is : " + Arrays.toString(r102));     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        return r102;
    L14:
        r112 = Signature.getInstance(f278032a);     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
    L29:
        b.b(f278034c, "content or privateKey is null.");
        return r101;
    }

    public static boolean verifySign(String r100, String r101, String r102) {
        return a(r100, r101, r102, false);
    }

    private static String a(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L13:
        b.b(f278034c, "sign content or key is null");
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        PrivateKey r103 = EncryptUtil.getPrivateKey(r101);
        if (r102 == false) goto L12;
        return newSign(r100, r103);
    L12:
        return sign(r100, r103);
    }

    public static boolean newVerifySign(String r100, String r101, PublicKey r102) {
        if (isBuildVersionHigherThan23() == true) goto L7;
        b.b(f278034c, "sdk version is too low");
        return false;
    L7:
        return a(r100, r101, r102, true);
    }

    public static byte[] sign(byte[] r100, PrivateKey r101, boolean r110) {
        byte[] r102 = new byte[0];
        if (r100 == null) goto L29;
        if (r101 == null) goto L29;
    L19:
        b.b(f278034c, "sign: ClassCastException");
        return r102;
    L20:
        e = move-exception;
        b.b(f278034c, "sign InvalidAlgorithmParameterException: " + e.getMessage());
        return r102;
    L24:
        e = move-exception;
        b.b(f278034c, "sign InvalidKeyException: " + e.getMessage());
        return r102;
    L26:
        e = move-exception;
        b.b(f278034c, "sign NoSuchAlgorithmException: " + e.getMessage());
        return r102;
    L22:
        e = move-exception;
        b.b(f278034c, "sign SignatureException: " + e.getMessage());
        return r102;
    L17:
        e = move-exception;
        b.b(f278034c, "sign Exception: " + e.getMessage());
        return r102;
    L7:
        if (RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) r101) == true) goto L10;
        b.b(f278034c, "privateKey length is too short");     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        return r102;
    L10:
        if (r110 == false) goto L14;
        Signature r111 = Signature.getInstance(f278033b);     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        r111.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
    L15:
        r111.initSign(r101);     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        r111.update(r100);     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
        return r111.sign();
    L14:
        r111 = Signature.getInstance(f278032a);     // Catch: Exception -> L17 ClassCastException -> L19 InvalidAlgorithmParameterException -> L20 SignatureException -> L22 InvalidKeyException -> L24 NoSuchAlgorithmException -> L26
    L29:
        b.b(f278034c, "content or privateKey is null.");
        return r102;
    }

    public static boolean verifySign(String r100, String r101, PublicKey r102) {
        return a(r100, r101, r102, false);
    }

    private static boolean a(String r100, String r101, PublicKey r102, boolean r103) {
        return verifySign(r100.getBytes("UTF-8"), Base64.decode(r101, 0), r102, r103);
    L7:
        e = move-exception;
        b.b(f278034c, "verifySign UnsupportedEncodingException: " + e.getMessage());
    L9:
        return false;
    L5:
        e = move-exception;
        b.b(f278034c, "base64 decode Exception : " + e.getMessage());
        goto L9
    }

    public static boolean verifySign(ByteBuffer r100, byte[] r101, PublicKey r110, boolean r111) {
        if (r100 == null) goto L24;
        if (r110 == null) goto L24;
        if (r101 == null) goto L24;
    L20:
        b.b(f278034c, "verifySign: ClassCastException");
    L23:
        return false;
    L21:
        e = move-exception;
        b.b(f278034c, "check sign exception: " + e.getMessage());
    L18:
        e = move-exception;
        b.b(f278034c, "exception : " + e.getMessage());
        goto L23
    L8:
        if (RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) r110) == true) goto L11;
        b.b(f278034c, "publicKey length is too short");     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
        return false;
    L11:
        if (r111 == false) goto L15;
        Signature r112 = Signature.getInstance(f278033b);     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
        r112.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
    L16:
        r112.initVerify(r110);     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
        r112.update(r100);     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
        return r112.verify(r101);
    L15:
        r112 = Signature.getInstance(f278032a);     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
    L24:
        b.b(f278034c, "content or publicKey is null.");
        return false;
    }

    private static boolean a(String r100, String r101, String r102, boolean r103) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L15:
        b.b(f278034c, "content or public key or sign value is null");
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        RSAPublicKey r104 = EncryptUtil.getPublicKey(r102);
        if (r103 == false) goto L14;
        return newVerifySign(r100, r101, r104);
    L14:
        return verifySign(r100, r101, r104);
    }

    public static boolean verifySign(byte[] r100, byte[] r101, PublicKey r110, boolean r111) {
        if (r100 == null) goto L24;
        if (r110 == null) goto L24;
        if (r101 == null) goto L24;
    L20:
        b.b(f278034c, "verifySign: ClassCastException");
    L23:
        return false;
    L21:
        e = move-exception;
        b.b(f278034c, "check sign exception: " + e.getMessage());
    L18:
        e = move-exception;
        b.b(f278034c, "exception : " + e.getMessage());
        goto L23
    L8:
        if (RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) r110) == true) goto L11;
        b.b(f278034c, "publicKey length is too short");     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
        return false;
    L11:
        if (r111 == false) goto L15;
        Signature r112 = Signature.getInstance(f278033b);     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
        r112.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
    L16:
        r112.initVerify(r110);     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
        r112.update(r100);     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
        return r112.verify(r101);
    L15:
        r112 = Signature.getInstance(f278032a);     // Catch: Exception -> L18 ClassCastException -> L20 GeneralSecurityException -> L21
    L24:
        b.b(f278034c, "content or publicKey is null.");
        return false;
    }
}
