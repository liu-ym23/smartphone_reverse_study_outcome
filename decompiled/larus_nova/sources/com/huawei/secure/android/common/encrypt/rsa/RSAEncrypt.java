package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes23.dex */
public abstract class RSAEncrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278026a = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278027b = "RSAEncrypt";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278028c = "UTF-8";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f278029d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f278030e = 2048;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f278031f = "RSA";

    public RSAEncrypt() {
    }

    public static Map<String, Key> generateRSAKeyPair(int r100) throws NoSuchAlgorithmException {
        HashMap r101 = new HashMap(2);
        if (r100 >= 2048) goto L6;
        b.b(f278027b, "generateRSAKeyPair: key length is too short");
        return r101;
    L6:
        SecureRandom r102 = EncryptUtil.genSecureRandom();
        KeyPairGenerator r103 = KeyPairGenerator.getInstance("RSA");
        r103.initialize(r100, r102);
        KeyPair r104 = r103.generateKeyPair();
        PublicKey r105 = r104.getPublic();
        PrivateKey r106 = r104.getPrivate();
        r101.put("publicKey", r105);
        r101.put("privateKey", r106);
        return r101;
    }

    public static boolean isPrivateKeyLengthRight(RSAPrivateKey r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getModulus().bitLength() < 2048) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isPublicKeyLengthRight(RSAPublicKey r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getModulus().bitLength() < 2048) goto L9;
        return true;
    L9:
        return false;
    }

    public static String decrypt(String r100, PrivateKey r101) {
        if (TextUtils.isEmpty(r100) == true) goto L18;
        if (r101 == null) goto L18;
    L15:
        e = move-exception;
        b.b(f278027b, "RSA decrypt exception : " + e.getMessage());
    L17:
        return "";
    L14:
        b.b(f278027b, "decrypt: ClassCastException");
    L12:
        e = move-exception;
        b.b(f278027b, "exception : " + e.getMessage());
        goto L17
    L7:
        if (isPrivateKeyLengthRight((RSAPrivateKey) r101) == true) goto L11;
        b.b(f278027b, "privateKey length is too short");     // Catch: Exception -> L12 ClassCastException -> L14 UnsupportedEncodingException -> L15
        return "";
    L11:
        return new String(decrypt(Base64.decode(r100, 0), r101), "UTF-8");
    L18:
        b.b(f278027b, "content or privateKey is null.");
        return "";
    }

    public static String encrypt(String r100, PublicKey r101) {
        if (TextUtils.isEmpty(r100) == true) goto L17;
        if (r101 == null) goto L17;
    L15:
        b.b(f278027b, "encrypt: UnsupportedEncodingException");
    L16:
        return "";
    L14:
        b.b(f278027b, "encrypt: ClassCastException");
    L12:
        e = move-exception;
        b.b(f278027b, "exception : " + e.getMessage());
        goto L16
    L7:
        if (isPublicKeyLengthRight((RSAPublicKey) r101) == true) goto L11;
        b.b(f278027b, "PublicKey length is too short");     // Catch: Exception -> L12 ClassCastException -> L14 UnsupportedEncodingException -> L15
        return "";
    L11:
        return Base64.encodeToString(encrypt(r100.getBytes("UTF-8"), r101), 0);
    L17:
        b.b(f278027b, "content or PublicKey is null");
        return "";
    }

    public static byte[] decrypt(byte[] r100, PrivateKey r101) {
        byte[] r102 = new byte[0];
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
    L14:
        b.b(f278027b, "decrypt: ClassCastException");
        return r102;
    L12:
        e = move-exception;
        b.b(f278027b, "RSA decrypt exception : " + e.getMessage());
        return r102;
    L7:
        if (isPrivateKeyLengthRight((RSAPrivateKey) r101) == true) goto L10;
        b.b(f278027b, "privateKey length is too short");     // Catch: GeneralSecurityException -> L12 ClassCastException -> L14
        return r102;
    L10:
        Cipher r103 = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");     // Catch: GeneralSecurityException -> L12 ClassCastException -> L14
        r103.init(2, r101);     // Catch: GeneralSecurityException -> L12 ClassCastException -> L14
        return r103.doFinal(r100);
    L16:
        b.b(f278027b, "content or privateKey is null.");
        return r102;
    }

    public static byte[] encrypt(byte[] r100, PublicKey r101) {
        byte[] r102 = new byte[0];
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
    L12:
        b.b(f278027b, "RSA encrypt encrypt: ClassCastException");
    L15:
        return r102;
    L13:
        e = move-exception;
        b.b(f278027b, "RSA encrypt exception : " + e.getMessage());
        goto L15
    L7:
        if (isPublicKeyLengthRight((RSAPublicKey) r101) == true) goto L10;
        b.b(f278027b, "publicKey length is too short");     // Catch: ClassCastException -> L12 GeneralSecurityException -> L13
        return r102;
    L10:
        Cipher r103 = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");     // Catch: ClassCastException -> L12 GeneralSecurityException -> L13
        r103.init(1, r101);     // Catch: ClassCastException -> L12 GeneralSecurityException -> L13
        return r103.doFinal(r100);
    L16:
        b.b(f278027b, "content or PublicKey is null");
        return r102;
    }

    public static String decrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        b.b(f278027b, "content or private key is null");
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return decrypt(r100, EncryptUtil.getPrivateKey(r101));
    }

    public static String encrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        b.b(f278027b, "content or public key is null");
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return encrypt(r100, EncryptUtil.getPublicKey(r101));
    }
}
