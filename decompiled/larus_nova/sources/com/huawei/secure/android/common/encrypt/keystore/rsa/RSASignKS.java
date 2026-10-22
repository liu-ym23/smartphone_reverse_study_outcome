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
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes23.dex */
public abstract class RSASignKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278009a = "RSASignKS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278010b = "AndroidKeyStore";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278011c = "SHA256withRSA/PSS";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f278012d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f278013e = 2048;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f278014f = 3072;

    public static boolean isBuildVersionHigherThan22() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public RSASignKS() {
    }

    private static boolean a(String r100) {
        KeyStore r101 = KeyStore.getInstance(f278010b);     // Catch: IOException -> L7 NoSuchAlgorithmException -> L9 UnrecoverableKeyException -> L11 CertificateException -> L13 KeyStoreException -> L15
        r101.load(null);     // Catch: IOException -> L7 NoSuchAlgorithmException -> L9 UnrecoverableKeyException -> L11 CertificateException -> L13 KeyStoreException -> L15
        if (r101.getKey(r100, null) == null) goto L20;
        return true;
    L20:
        return false;
    L7:
        e = move-exception;
        b.b(f278009a, "IOException: " + e.getMessage());
    L17:
        return false;
    L15:
        e = move-exception;
        b.b(f278009a, "KeyStoreException: " + e.getMessage());
    L9:
        e = move-exception;
        b.b(f278009a, "NoSuchAlgorithmException: " + e.getMessage());
    L11:
        e = move-exception;
        b.b(f278009a, "UnrecoverableKeyException: " + e.getMessage());
    L13:
        e = move-exception;
        b.b(f278009a, "CertificateException: " + e.getMessage());
        goto L17
    }

    private static synchronized KeyPair a(String r100, boolean r101) {
        monitor-enter(RSASignKS.class);
        KeyPair r102 = null;
        if (a(r100) == false) goto L27;
        b.b(f278009a, "Key pair exits");     // Catch: Throwable -> L23
        monitor-exit(RSASignKS.class);
        return null;
    L27:
        KeyPairGenerator r103 = KeyPairGenerator.getInstance(d.f25615a, f278010b);     // Catch: InvalidAlgorithmParameterException -> L15 NoSuchProviderException -> L17 NoSuchAlgorithmException -> L19 Throwable -> L23
        if (r101 == true) goto L12;
        r103.initialize(new KeyGenParameterSpec.Builder(r100, 12).setDigests(new String[]{"SHA-256", "SHA-512"}).setSignaturePaddings(new String[]{"PSS"}).setKeySize(2048).build());     // Catch: InvalidAlgorithmParameterException -> L15 NoSuchProviderException -> L17 NoSuchAlgorithmException -> L19 Throwable -> L23
    L13:
        r102 = r103.generateKeyPair();     // Catch: InvalidAlgorithmParameterException -> L15 NoSuchProviderException -> L17 NoSuchAlgorithmException -> L19 Throwable -> L23
    L21:
        monitor-exit(RSASignKS.class);
        return r102;
    L12:
        r103.initialize(new KeyGenParameterSpec.Builder(r100, 12).setDigests(new String[]{"SHA-256", "SHA-512"}).setSignaturePaddings(new String[]{"PSS"}).setKeySize(f278014f).build());     // Catch: InvalidAlgorithmParameterException -> L15 NoSuchProviderException -> L17 NoSuchAlgorithmException -> L19 Throwable -> L23
    L17:
        e = move-exception;
        b.b(f278009a, "NoSuchProviderException: " + e.getMessage());     // Catch: Throwable -> L23
    L19:
        e = move-exception;
        b.b(f278009a, "NoSuchAlgorithmException: " + e.getMessage());     // Catch: Throwable -> L23
    L15:
        e = move-exception;
        b.b(f278009a, "InvalidAlgorithmParameterException: " + e.getMessage());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private static KeyStore.Entry b(String r100, boolean r101) {
        if (a(r100) == true) goto L19;
        a(r100, r101);
    L19:
        KeyStore r102 = KeyStore.getInstance(f278010b);     // Catch: UnrecoverableEntryException -> L8 IOException -> L10 NoSuchAlgorithmException -> L12 CertificateException -> L14 KeyStoreException -> L16
        r102.load(null);     // Catch: UnrecoverableEntryException -> L8 IOException -> L10 NoSuchAlgorithmException -> L12 CertificateException -> L14 KeyStoreException -> L16
    L25:
        return r102.getEntry(r100, null);
    L10:
        e = move-exception;
        b.b(f278009a, "IOException: " + e.getMessage());
        return null;
    L16:
        e = move-exception;
        b.b(f278009a, "KeyStoreException: " + e.getMessage());
        return null;
    L12:
        e = move-exception;
        b.b(f278009a, "NoSuchAlgorithmException: " + e.getMessage());
        return null;
    L8:
        e = move-exception;
        b.b(f278009a, "UnrecoverableEntryException: " + e.getMessage());
        return null;
    L14:
        e = move-exception;
        b.b(f278009a, "CertificateException: " + e.getMessage());
        return null;
    }

    public static String sign(String r100, String r101) {
        return Base64.encodeToString(sign(r100, r101.getBytes("UTF-8")), 0);
    L4:
        e = move-exception;
        e.getMessage();
        return "";
    }

    public static String signNew(String r100, String r101) {
        return Base64.encodeToString(signNew(r100, r101.getBytes("UTF-8")), 0);
    L4:
        e = move-exception;
        e.getMessage();
        return "";
    }

    public static byte[] sign(String r100, byte[] r101) {
        return a(r100, r101, false);
    }

    public static byte[] signNew(String r100, byte[] r101) {
        return a(r100, r101, true);
    }

    private static byte[] a(String r100, byte[] r101, boolean r102) {
        byte[] r103 = new byte[0];
        if (TextUtils.isEmpty(r100) == true) goto L25;
        if (r101 == null) goto L25;
        if (isBuildVersionHigherThan22() == true) goto L10;
        b.b(f278009a, "sdk version is too low");
        return r103;
    L10:
        KeyStore.Entry r104 = b(r100, r102);
        if ((r104 instanceof KeyStore.PrivateKeyEntry) == true) goto L27;
        b.b(f278009a, "Not an instance of a PrivateKeyEntry");
        return r103;
    L27:
        Signature r105 = Signature.getInstance(f278011c);     // Catch: Exception -> L16 InvalidKeyException -> L18 SignatureException -> L20 NoSuchAlgorithmException -> L22
        r105.initSign(((KeyStore.PrivateKeyEntry) r104).getPrivateKey());     // Catch: Exception -> L16 InvalidKeyException -> L18 SignatureException -> L20 NoSuchAlgorithmException -> L22
        r105.update(r101);     // Catch: Exception -> L16 InvalidKeyException -> L18 SignatureException -> L20 NoSuchAlgorithmException -> L22
        return r105.sign();
    L18:
        e = move-exception;
        b.b(f278009a, "InvalidKeyException: " + e.getMessage());
    L24:
        return r103;
    L22:
        e = move-exception;
        b.b(f278009a, "NoSuchAlgorithmException: " + e.getMessage());
    L20:
        e = move-exception;
        b.b(f278009a, "SignatureException: " + e.getMessage());
    L16:
        e = move-exception;
        b.b(f278009a, "Exception: " + e.getMessage());
    L25:
        b.b(f278009a, "alias or content is null");
        return r103;
    }

    public static boolean verifySign(String r100, String r101, String r102) {
        return verifySign(r100, r101.getBytes("UTF-8"), Base64.decode(r102, 0));
    L7:
        e = move-exception;
        e.getMessage();
    L9:
        return false;
    L5:
        e = move-exception;
        b.b(f278009a, "base64 decode Exception" + e.getMessage());
        goto L9
    }

    public static boolean verifySignNew(String r100, String r101, String r102) {
        return verifySignNew(r100, r101.getBytes("UTF-8"), Base64.decode(r102, 0));
    L7:
        e = move-exception;
        e.getMessage();
    L9:
        return false;
    L5:
        e = move-exception;
        b.b(f278009a, "base64 decode Exception" + e.getMessage());
        goto L9
    }

    public static boolean verifySign(String r100, byte[] r101, byte[] r102) {
        return a(r100, r101, r102, false);
    }

    public static boolean verifySignNew(String r100, byte[] r101, byte[] r102) {
        return a(r100, r101, r102, true);
    }

    private static boolean a(String r100, byte[] r101, byte[] r102, boolean r103) {
        if (TextUtils.isEmpty(r100) == true) goto L26;
        if (r101 == null) goto L26;
        if (r102 == null) goto L26;
        if (isBuildVersionHigherThan22() == true) goto L11;
        b.b(f278009a, "sdk version is too low");
        return false;
    L11:
        KeyStore.Entry r104 = b(r100, r103);
        if ((r104 instanceof KeyStore.PrivateKeyEntry) == true) goto L28;
        b.b(f278009a, "Not an instance of a PrivateKeyEntry");
        return false;
    L28:
        Signature r105 = Signature.getInstance(f278011c);     // Catch: Exception -> L17 InvalidKeyException -> L19 SignatureException -> L21 NoSuchAlgorithmException -> L23
        r105.initVerify(((KeyStore.PrivateKeyEntry) r104).getCertificate());     // Catch: Exception -> L17 InvalidKeyException -> L19 SignatureException -> L21 NoSuchAlgorithmException -> L23
        r105.update(r101);     // Catch: Exception -> L17 InvalidKeyException -> L19 SignatureException -> L21 NoSuchAlgorithmException -> L23
    L33:
        return r105.verify(r102);
    L19:
        e = move-exception;
        b.b(f278009a, "InvalidKeyException: " + e.getMessage());
        return false;
    L23:
        e = move-exception;
        b.b(f278009a, "NoSuchAlgorithmException: " + e.getMessage());
        return false;
    L21:
        e = move-exception;
        b.b(f278009a, "SignatureException: " + e.getMessage());
        return false;
    L17:
        e = move-exception;
        b.b(f278009a, "Exception: " + e.getMessage());
        return false;
    L26:
        b.b(f278009a, "alias or content or sign value is null");
        return false;
    }
}
