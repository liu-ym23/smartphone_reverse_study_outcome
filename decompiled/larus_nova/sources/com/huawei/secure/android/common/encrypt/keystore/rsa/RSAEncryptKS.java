package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* JADX INFO: loaded from: classes23.dex */
public abstract class RSAEncryptKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278003a = "RSAEncryptKS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278004b = "AndroidKeyStore";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278005c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f278006d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f278007e = 2048;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f278008f = 3072;

    private static boolean a() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public RSAEncryptKS() {
    }

    private static PrivateKey a(String r100) {
        if (b(r100) == true) goto L20;
        return null;
    L20:
        KeyStore r101 = KeyStore.getInstance(f278004b);     // Catch: Exception -> L7 IOException -> L9 NoSuchAlgorithmException -> L11 UnrecoverableKeyException -> L13 CertificateException -> L15 KeyStoreException -> L17
        r101.load(null);     // Catch: Exception -> L7 IOException -> L9 NoSuchAlgorithmException -> L11 UnrecoverableKeyException -> L13 CertificateException -> L15 KeyStoreException -> L17
    L22:
        return (PrivateKey) r101.getKey(r100, null);
    L9:
        e = move-exception;
        b.b(f278003a, "IOException: " + e.getMessage());
        return null;
    L17:
        e = move-exception;
        b.b(f278003a, "KeyStoreException: " + e.getMessage());
        return null;
    L11:
        e = move-exception;
        b.b(f278003a, "NoSuchAlgorithmException: " + e.getMessage());
        return null;
    L13:
        e = move-exception;
        b.b(f278003a, "UnrecoverableKeyException: " + e.getMessage());
        return null;
    L15:
        e = move-exception;
        b.b(f278003a, "CertificateException: " + e.getMessage());
        return null;
    L7:
        e = move-exception;
        b.b(f278003a, "Exception: " + e.getMessage());
        return null;
    }

    private static boolean b(String r100) {
        KeyStore r101 = KeyStore.getInstance(f278004b);     // Catch: Exception -> L7 IOException -> L9 NoSuchAlgorithmException -> L11 UnrecoverableKeyException -> L13 CertificateException -> L15 KeyStoreException -> L17
        r101.load(null);     // Catch: Exception -> L7 IOException -> L9 NoSuchAlgorithmException -> L11 UnrecoverableKeyException -> L13 CertificateException -> L15 KeyStoreException -> L17
        if (r101.getKey(r100, null) == null) goto L22;
        return true;
    L22:
        return false;
    L9:
        e = move-exception;
        b.b(f278003a, "IOException: " + e.getMessage());
    L19:
        return false;
    L17:
        e = move-exception;
        b.b(f278003a, "KeyStoreException: " + e.getMessage());
    L11:
        e = move-exception;
        b.b(f278003a, "NoSuchAlgorithmException: " + e.getMessage());
    L13:
        e = move-exception;
        b.b(f278003a, "UnrecoverableKeyException: " + e.getMessage());
    L15:
        e = move-exception;
        b.b(f278003a, "CertificateException: " + e.getMessage());
    L7:
        e = move-exception;
        b.b(f278003a, "Exception: " + e.getMessage());
        goto L19
    }

    private static Certificate c(String r100) {
        KeyStore r101 = KeyStore.getInstance(f278004b);     // Catch: Exception -> L5 IOException -> L7 NoSuchAlgorithmException -> L9 CertificateException -> L11 KeyStoreException -> L13
        r101.load(null);     // Catch: Exception -> L5 IOException -> L7 NoSuchAlgorithmException -> L9 CertificateException -> L11 KeyStoreException -> L13
    L22:
        return r101.getCertificate(r100);
    L7:
        e = move-exception;
        b.b(f278003a, "IOException: " + e.getMessage());
        return null;
    L13:
        e = move-exception;
        b.b(f278003a, "KeyStoreException: " + e.getMessage());
        return null;
    L9:
        e = move-exception;
        b.b(f278003a, "NoSuchAlgorithmException: " + e.getMessage());
        return null;
    L11:
        e = move-exception;
        b.b(f278003a, "CertificateException: " + e.getMessage());
        return null;
    L5:
        e = move-exception;
        b.b(f278003a, "Exception: " + e.getMessage());
        return null;
    }

    private static synchronized KeyPair a(String r100, boolean r101) {
        monitor-enter(RSAEncryptKS.class);
        KeyPair r102 = null;
        if (b(r100) == false) goto L9;
        b.b(f278003a, "Key pair exits");     // Catch: Throwable -> L26
        monitor-exit(RSAEncryptKS.class);
        return null;
    L9:
        b.c(f278003a, "generate key pair.");     // Catch: Throwable -> L26
        KeyPairGenerator r103 = KeyPairGenerator.getInstance(d.f25615a, f278004b);     // Catch: Exception -> L16 InvalidAlgorithmParameterException -> L18 NoSuchProviderException -> L20 NoSuchAlgorithmException -> L22 Throwable -> L26
        if (r101 == true) goto L13;
        r103.initialize(new KeyGenParameterSpec.Builder(r100, 2).setDigests(new String[]{"SHA-256", "SHA-512"}).setEncryptionPaddings(new String[]{"OAEPPadding"}).setKeySize(2048).build());     // Catch: Exception -> L16 InvalidAlgorithmParameterException -> L18 NoSuchProviderException -> L20 NoSuchAlgorithmException -> L22 Throwable -> L26
    L14:
        r102 = r103.generateKeyPair();     // Catch: Exception -> L16 InvalidAlgorithmParameterException -> L18 NoSuchProviderException -> L20 NoSuchAlgorithmException -> L22 Throwable -> L26
    L24:
        monitor-exit(RSAEncryptKS.class);
        return r102;
    L13:
        r103.initialize(new KeyGenParameterSpec.Builder(r100, 2).setDigests(new String[]{"SHA-256", "SHA-512"}).setEncryptionPaddings(new String[]{"OAEPPadding"}).setKeySize(f278008f).build());     // Catch: Exception -> L16 InvalidAlgorithmParameterException -> L18 NoSuchProviderException -> L20 NoSuchAlgorithmException -> L22 Throwable -> L26
    L22:
        e = move-exception;
        b.b(f278003a, "NoSuchAlgorithmException: " + e.getMessage());     // Catch: Throwable -> L26
    L18:
        e = move-exception;
        b.b(f278003a, "InvalidAlgorithmParameterException: " + e.getMessage());     // Catch: Throwable -> L26
    L20:
        e = move-exception;
        b.b(f278003a, "NoSuchProviderException: " + e.getMessage());     // Catch: Throwable -> L26
    L16:
        e = move-exception;
        b.b(f278003a, "Exception: " + e.getMessage());     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    private static PublicKey b(String r100, boolean r101) {
        if (b(r100) == true) goto L5;
        a(r100, r101);
    L5:
        Certificate r102 = c(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getPublicKey();
    }

    public static byte[] decrpyt(String r100, byte[] r101) {
        byte[] r102 = new byte[0];
        if (TextUtils.isEmpty(r100) == true) goto L33;
        if (r101 == null) goto L33;
        if (a() == true) goto L10;
        b.b(f278003a, "sdk version is too low");
        return r102;
    L10:
        PrivateKey r103 = a(r100);
        if (r103 != null) goto L35;
        b.b(f278003a, "Private key is null");
        return r102;
    L35:
        Cipher r104 = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");     // Catch: Exception -> L18 BadPaddingException -> L20 IllegalBlockSizeException -> L22 InvalidAlgorithmParameterException -> L24 InvalidKeyException -> L26 NoSuchPaddingException -> L28 NoSuchAlgorithmException -> L30
        r104.init(2, r103, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));     // Catch: Exception -> L18 BadPaddingException -> L20 IllegalBlockSizeException -> L22 InvalidAlgorithmParameterException -> L24 InvalidKeyException -> L26 NoSuchPaddingException -> L28 NoSuchAlgorithmException -> L30
        return r104.doFinal(r101);
    L24:
        e = move-exception;
        b.b(f278003a, "InvalidAlgorithmParameterException: " + e.getMessage());
    L32:
        return r102;
    L26:
        e = move-exception;
        b.b(f278003a, "InvalidKeyException: " + e.getMessage());
    L30:
        e = move-exception;
        b.b(f278003a, "NoSuchAlgorithmException: " + e.getMessage());
    L20:
        e = move-exception;
        b.b(f278003a, "BadPaddingException: " + e.getMessage());
    L22:
        e = move-exception;
        b.b(f278003a, "IllegalBlockSizeException: " + e.getMessage());
    L28:
        e = move-exception;
        b.b(f278003a, "NoSuchPaddingException: " + e.getMessage());
    L18:
        e = move-exception;
        b.b(f278003a, "Exception: " + e.getMessage());
    L33:
        b.b(f278003a, "alias or encrypted content is null");
        return r102;
    }

    public static String decrpytNew(String r100, String r101) {
        return new String(decrpytNew(r100, Base64.decode(r101, 0)), "UTF-8");
    L6:
        e = move-exception;
        b.b(f278003a, "UnsupportedEncodingException: " + e.getMessage());
        return "";
    L4:
        e = move-exception;
        b.b(f278003a, "Exception: " + e.getMessage());
        return "";
    }

    public static String encrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L12;
        return Base64.encodeToString(encrypt(r100, r101.getBytes("UTF-8")), 0);
    L6:
        e = move-exception;
        b.b(f278003a, "UnsupportedEncodingException: " + e.getMessage());
        return "";
    L12:
        return "";
    }

    public static String encryptNew(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L12;
        return Base64.encodeToString(encryptNew(r100, r101.getBytes("UTF-8")), 0);
    L6:
        e = move-exception;
        b.b(f278003a, "UnsupportedEncodingException: " + e.getMessage());
        return "";
    L12:
        return "";
    }

    public static String decrpyt(String r100, String r101) {
        return new String(decrpyt(r100, Base64.decode(r101, 0)), "UTF-8");
    L6:
        e = move-exception;
        b.b(f278003a, "UnsupportedEncodingException: " + e.getMessage());
        return "";
    L4:
        e = move-exception;
        b.b(f278003a, "Exception: " + e.getMessage());
        return "";
    }

    public static byte[] decrpytNew(String r100, byte[] r101) {
        return decrpyt(r100, r101);
    }

    public static byte[] encrypt(String r100, byte[] r101) {
        return a(r100, r101, false);
    }

    public static byte[] encryptNew(String r100, byte[] r101) {
        return a(r100, r101, true);
    }

    private static byte[] a(String r100, byte[] r101, boolean r102) {
        byte[] r103 = new byte[0];
        if (TextUtils.isEmpty(r100) == true) goto L33;
        if (r101 == null) goto L33;
        if (a() == true) goto L10;
        b.b(f278003a, "sdk version is too low");
        return r103;
    L10:
        PublicKey r104 = b(r100, r102);
        if (r104 != null) goto L35;
        b.b(f278003a, "Public key is null");
        return r103;
    L35:
        Cipher r105 = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");     // Catch: Exception -> L18 BadPaddingException -> L20 IllegalBlockSizeException -> L22 InvalidAlgorithmParameterException -> L24 InvalidKeyException -> L26 NoSuchPaddingException -> L28 NoSuchAlgorithmException -> L30
        r105.init(1, r104, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));     // Catch: Exception -> L18 BadPaddingException -> L20 IllegalBlockSizeException -> L22 InvalidAlgorithmParameterException -> L24 InvalidKeyException -> L26 NoSuchPaddingException -> L28 NoSuchAlgorithmException -> L30
        return r105.doFinal(r101);
    L24:
        e = move-exception;
        b.b(f278003a, "InvalidAlgorithmParameterException: " + e.getMessage());
    L32:
        return r103;
    L26:
        e = move-exception;
        b.b(f278003a, "InvalidKeyException: " + e.getMessage());
    L30:
        e = move-exception;
        b.b(f278003a, "NoSuchAlgorithmException: " + e.getMessage());
    L20:
        e = move-exception;
        b.b(f278003a, "BadPaddingException: " + e.getMessage());
    L22:
        e = move-exception;
        b.b(f278003a, "IllegalBlockSizeException: " + e.getMessage());
    L28:
        e = move-exception;
        b.b(f278003a, "NoSuchPaddingException: " + e.getMessage());
    L18:
        e = move-exception;
        b.b(f278003a, "Exception: " + e.getMessage());
    L33:
        b.b(f278003a, "alias or content is null");
        return r103;
    }
}
