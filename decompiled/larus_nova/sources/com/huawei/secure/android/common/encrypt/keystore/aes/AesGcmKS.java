package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.bytedance.crypto.utils.CryptoConst;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes23.dex */
public class AesGcmKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277996a = "GCMKS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277997b = "AndroidKeyStore";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277998c = "AES/GCM/NoPadding";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f277999d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f278000e = 12;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f278001f = 256;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Map<String, SecretKey> f278002g;

    static {
        f278002g = new ConcurrentHashMap();
    }

    private static boolean a() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public AesGcmKS() {
    }

    private static SecretKey a(String r100, Boolean r101) throws AesKsParamException {
        b.c(f277996a, "load key");
        KeyStore r102 = KeyStore.getInstance(f277997b);     // Catch: Exception -> L11 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L17 UnrecoverableKeyException -> L20 NoSuchAlgorithmException -> L23 CertificateException -> L26 IOException -> L29 KeyStoreException -> L32
        r102.load(null);     // Catch: Exception -> L11 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L17 UnrecoverableKeyException -> L20 NoSuchAlgorithmException -> L23 CertificateException -> L26 IOException -> L29 KeyStoreException -> L32
        Key r103 = r102.getKey(r100, null);     // Catch: Exception -> L11 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L17 UnrecoverableKeyException -> L20 NoSuchAlgorithmException -> L23 CertificateException -> L26 IOException -> L29 KeyStoreException -> L32
        if ((r103 instanceof SecretKey) == false) goto L7;
        return (SecretKey) r103;
    L7:
        if (r101.booleanValue() == false) goto L37;
        b.c(f277996a, "generate key");     // Catch: Exception -> L11 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L17 UnrecoverableKeyException -> L20 NoSuchAlgorithmException -> L23 CertificateException -> L26 IOException -> L29 KeyStoreException -> L32
        KeyGenerator r104 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, f277997b);     // Catch: Exception -> L11 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L17 UnrecoverableKeyException -> L20 NoSuchAlgorithmException -> L23 CertificateException -> L26 IOException -> L29 KeyStoreException -> L32
        r104.init(new KeyGenParameterSpec.Builder(r100, 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build());     // Catch: Exception -> L11 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L17 UnrecoverableKeyException -> L20 NoSuchAlgorithmException -> L23 CertificateException -> L26 IOException -> L29 KeyStoreException -> L32
        return r104.generateKey();
    L37:
        return null;
    L29:
        e = move-exception;
        b.b(f277996a, "IOException : " + e.getMessage());
        throw new AesKsParamException("IOException : " + e.getMessage());
    L17:
        e = move-exception;
        b.b(f277996a, "InvalidAlgorithmParameterException : " + e.getMessage());
        throw new AesKsParamException("InvalidAlgorithmParameterException : " + e.getMessage());
    L32:
        e = move-exception;
        b.b(f277996a, "KeyStoreException : " + e.getMessage());
        throw new AesKsParamException("KeyStoreException : " + e.getMessage());
    L23:
        e = move-exception;
        b.b(f277996a, "NoSuchAlgorithmException : " + e.getMessage());
        throw new AesKsParamException("NoSuchAlgorithmException : " + e.getMessage());
    L14:
        e = move-exception;
        b.b(f277996a, "NoSuchProviderException : " + e.getMessage());
        throw new AesKsParamException("NoSuchProviderException : " + e.getMessage());
    L20:
        e = move-exception;
        b.b(f277996a, "UnrecoverableKeyException : " + e.getMessage());
        throw new AesKsParamException("UnrecoverableKeyException : " + e.getMessage());
    L26:
        e = move-exception;
        b.b(f277996a, "CertificateException : " + e.getMessage());
        throw new AesKsParamException("CertificateException : " + e.getMessage());
    L11:
        e = move-exception;
        b.b(f277996a, "Exception: " + e.getMessage());
        throw new AesKsParamException("Exception : " + e.getMessage());
    }

    private static byte[] b(SecretKey r100, byte[] r101) throws AesKsParamException {
        byte[] r102 = new byte[0];
        Cipher r103 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L12 InvalidKeyException -> L15 IllegalBlockSizeException -> L18 BadPaddingException -> L21 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L27
        r103.init(1, r100);     // Catch: Exception -> L12 InvalidKeyException -> L15 IllegalBlockSizeException -> L18 BadPaddingException -> L21 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L27
        byte[] r104 = r103.doFinal(r101);     // Catch: Exception -> L12 InvalidKeyException -> L15 IllegalBlockSizeException -> L18 BadPaddingException -> L21 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L27
        byte[] r105 = r103.getIV();     // Catch: Exception -> L12 InvalidKeyException -> L15 IllegalBlockSizeException -> L18 BadPaddingException -> L21 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L27
        if (r105 != null) goto L6;
    L10:
        b.b(f277996a, "IV is invalid.");     // Catch: Exception -> L12 InvalidKeyException -> L15 IllegalBlockSizeException -> L18 BadPaddingException -> L21 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L27
        return r102;
    L6:
        if (r105.length != 12) goto L10;
        byte[] r106 = Arrays.copyOf(r105, r105.length + r104.length);     // Catch: Exception -> L12 InvalidKeyException -> L15 IllegalBlockSizeException -> L18 BadPaddingException -> L21 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L27
        System.arraycopy(r104, 0, r106, r105.length, r104.length);     // Catch: Exception -> L12 InvalidKeyException -> L15 IllegalBlockSizeException -> L18 BadPaddingException -> L21 NoSuchPaddingException -> L24 NoSuchAlgorithmException -> L27
        return r106;
    L15:
        e = move-exception;
        b.b(f277996a, "InvalidKeyException : " + e.getMessage());
        throw new AesKsParamException("InvalidKeyException : " + e.getMessage());
    L27:
        e = move-exception;
        b.b(f277996a, "NoSuchAlgorithmException : " + e.getMessage());
        throw new AesKsParamException("NoSuchAlgorithmException : " + e.getMessage());
    L21:
        e = move-exception;
        b.b(f277996a, "BadPaddingException : " + e.getMessage());
        throw new AesKsParamException("BadPaddingException : " + e.getMessage());
    L18:
        e = move-exception;
        b.b(f277996a, "IllegalBlockSizeException : " + e.getMessage());
        throw new AesKsParamException("IllegalBlockSizeException : " + e.getMessage());
    L24:
        e = move-exception;
        b.b(f277996a, "NoSuchPaddingException : " + e.getMessage());
        throw new AesKsParamException("NoSuchPaddingException : " + e.getMessage());
    L12:
        e = move-exception;
        b.b(f277996a, "Exception: " + e.getMessage());
        throw new AesKsParamException("Exception : " + e.getMessage());
    }

    public static byte[] decrypt(String r100, byte[] r101) {
        byte[] r102 = new byte[0];
        if (TextUtils.isEmpty(r100) == true) goto L22;
        if (r101 == null) goto L22;
        if (a() == true) goto L11;
        b.b(f277996a, "sdk version is too low");
        return r102;
    L11:
        if (r101.length > 12) goto L24;
        b.b(f277996a, "Decrypt source data is invalid.");
        return r102;
    L24:
        SecretKey r103 = b(r100, Boolean.FALSE);     // Catch: AesKsParamException -> L16
    L18:
        if (r103 != null) goto L21;
        return r102;
    L21:
        return decrypt(r103, r101);
    L16:
        e = move-exception;
        b.b(f277996a, "e : " + e.getMessage());
        r103 = null;
    L22:
        b.b(f277996a, "alias or encrypt content is null");
        return r102;
    }

    public static String decryptNew(String r100, String r101) throws AesKsParamException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        b.b(f277996a, "alias or encrypt content is null");
        throw new AesKsParamException("alias or encrypt content is null");
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return new String(decryptNew(r100, HexUtil.hexStr2ByteArray(r101)), "UTF-8");
    L8:
        e = move-exception;
        b.b(f277996a, "decrypt: UnsupportedEncodingException : " + e.getMessage());
        throw new AesKsParamException("decrypt: UnsupportedEncodingException");
    }

    public static byte[] encrypt(String r100, byte[] r101) {
        byte[] r102 = new byte[0];
        if (TextUtils.isEmpty(r100) == true) goto L18;
        if (r101 == null) goto L18;
        if (a() == true) goto L20;
        b.b(f277996a, "sdk version is too low");
        return r102;
    L20:
        SecretKey r103 = b(r100, Boolean.TRUE);     // Catch: AesKsParamException -> L12
    L14:
        if (r103 != null) goto L17;
        return r102;
    L17:
        return encrypt(r103, r101);
    L12:
        e = move-exception;
        b.b(f277996a, "e : " + e.getMessage());
        r103 = null;
    L18:
        b.b(f277996a, "alias or encrypt content is null");
        return r102;
    }

    public static String encryptNew(String r100, String r101) throws AesKsParamException {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        b.b(f277996a, "alias or encrypt content is null");
        throw new AesKsParamException("alias or encrypt content is null");
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return HexUtil.byteArray2HexStr(encryptNew(r100, r101.getBytes("UTF-8")));
    L8:
        e = move-exception;
        b.b(f277996a, "encrypt: UnsupportedEncodingException : " + e.getMessage());
        throw new AesKsParamException("encrypt: UnsupportedEncodingException");
    }

    private static byte[] a(SecretKey r100, byte[] r101) throws AesKsParamException {
        byte[] r102 = Arrays.copyOf(r101, 12);
        Cipher r103 = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Exception -> L5 BadPaddingException -> L8 IllegalBlockSizeException -> L11 InvalidAlgorithmParameterException -> L14 InvalidKeyException -> L17 NoSuchPaddingException -> L20 NoSuchAlgorithmException -> L23
        r103.init(2, r100, new GCMParameterSpec(128, r102));     // Catch: Exception -> L5 BadPaddingException -> L8 IllegalBlockSizeException -> L11 InvalidAlgorithmParameterException -> L14 InvalidKeyException -> L17 NoSuchPaddingException -> L20 NoSuchAlgorithmException -> L23
        return r103.doFinal(r101, 12, r101.length - 12);
    L14:
        e = move-exception;
        b.b(f277996a, "InvalidAlgorithmParameterException : " + e.getMessage());
        throw new AesKsParamException("InvalidAlgorithmParameterException : " + e.getMessage());
    L17:
        e = move-exception;
        b.b(f277996a, "InvalidKeyException : " + e.getMessage());
        throw new AesKsParamException("InvalidKeyException : " + e.getMessage());
    L23:
        e = move-exception;
        b.b(f277996a, "NoSuchAlgorithmException : " + e.getMessage());
        throw new AesKsParamException("NoSuchAlgorithmException : " + e.getMessage());
    L8:
        e = move-exception;
        b.b(f277996a, "BadPaddingException : " + e.getMessage());
        throw new AesKsParamException("BadPaddingException : " + e.getMessage());
    L11:
        e = move-exception;
        b.b(f277996a, "IllegalBlockSizeException : " + e.getMessage());
        throw new AesKsParamException("IllegalBlockSizeException : " + e.getMessage());
    L20:
        e = move-exception;
        b.b(f277996a, "NoSuchPaddingException : " + e.getMessage());
        throw new AesKsParamException("NoSuchPaddingException : " + e.getMessage());
    L5:
        e = move-exception;
        b.b(f277996a, "Exception: " + e.getMessage());
        throw new AesKsParamException("Exception: " + e.getMessage());
    }

    private static SecretKey b(String r100, Boolean r101) throws AesKsParamException {
        if (TextUtils.isEmpty(r100) == true) goto L23;
        if (f278002g.get(r100) != null) goto L21;
        monitor-enter(AesGcmKS.class);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (f278002g.get(r100) != null) goto L15;
        SecretKey r102 = a(r100, r101);     // Catch: Throwable -> L17
        if (r102 == null) goto L14;
        f278002g.put(r100, r102);     // Catch: Throwable -> L17
        goto L15
    L14:
        throw new AesKsParamException("AES GCM is decrypt,but alias is null");     // Catch: Throwable -> L17
    L15:
        monitor-exit(AesGcmKS.class);     // Catch: Throwable -> L17
    L21:
        return f278002g.get(r100);
    L23:
        throw new AesKsParamException("alias is null");
    }

    public static byte[] decrypt(SecretKey r100, byte[] r101) {
        byte[] r102 = new byte[0];
        if (r100 != null) goto L6;
        b.b(f277996a, "Decrypt secret key is null");
        return r102;
    L6:
        if (r101 != null) goto L10;
        b.b(f277996a, "content is null");
        return r102;
    L10:
        if (a() == true) goto L14;
        b.b(f277996a, "sdk version is too low");
        return r102;
    L14:
        if (r101.length > 12) goto L22;
        b.b(f277996a, "Decrypt source data is invalid.");
        return r102;
    L22:
        return a(r100, r101);
    L19:
        e = move-exception;
        b.b(f277996a, "e : " + e.getMessage());
        return r102;
    }

    public static byte[] decryptNew(SecretKey r100, byte[] r101) throws AesKsParamException {
        if (r100 == null) goto L17;
        if (r101 != null) goto L6;
        b.b(f277996a, "content is null");
        throw new AesKsParamException("content is null");
    L6:
        if (a() == true) goto L8;
        b.b(f277996a, "sdk version is too low");
        throw new AesKsParamException("sdk version is too low.");
    L8:
        if (r101.length > 12) goto L10;
        b.b(f277996a, "Decrypt source data is invalid.");
        throw new AesKsParamException("Decrypt source data is invalid.");
    L10:
        return a(r100, r101);
    L17:
        b.b(f277996a, "Decrypt secret key is null");
        throw new AesKsParamException("Decrypt secret key is null");
    }

    public static String encrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L12:
        b.b(f277996a, "alias or encrypt content is null");
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        return HexUtil.byteArray2HexStr(encrypt(r100, r101.getBytes("UTF-8")));
    L9:
        e = move-exception;
        b.b(f277996a, "encrypt: UnsupportedEncodingException : " + e.getMessage());
        return "";
    }

    public static byte[] encryptNew(SecretKey r100, byte[] r101) throws AesKsParamException {
        if (r101 == null) goto L13;
        if (r100 != null) goto L6;
        b.b(f277996a, "secret key is null");
        throw new AesKsParamException("secret key is null.");
    L6:
        if (a() == true) goto L8;
        b.b(f277996a, "sdk version is too low");
        throw new AesKsParamException("sdk version is too low");
    L8:
        return b(r100, r101);
    L13:
        b.b(f277996a, "content is null");
        throw new AesKsParamException("content is null.");
    }

    public static String decrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L12:
        b.b(f277996a, "alias or encrypt content is null");
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        return new String(decrypt(r100, HexUtil.hexStr2ByteArray(r101)), "UTF-8");
    L9:
        e = move-exception;
        b.b(f277996a, "decrypt: UnsupportedEncodingException : " + e.getMessage());
        return "";
    }

    public static byte[] decryptNew(String r100, byte[] r101) throws AesKsParamException {
        if (TextUtils.isEmpty(r100) == true) goto L15;
        if (r101 == null) goto L15;
        if (a() == true) goto L8;
        b.b(f277996a, "sdk version is too low");
        throw new AesKsParamException("sdk version is too low");
    L8:
        if (r101.length > 12) goto L10;
        b.b(f277996a, "Decrypt source data is invalid.");
        throw new AesKsParamException("Decrypt source data is invalid");
    L10:
        return decryptNew(b(r100, Boolean.FALSE), r101);
    L15:
        b.b(f277996a, "alias or encrypt content is null");
        throw new AesKsParamException("alias or encrypt content is null");
    }

    public static byte[] encrypt(SecretKey r100, byte[] r101) {
        byte[] r102 = new byte[0];
        if (r101 != null) goto L6;
        b.b(f277996a, "content is null");
        return r102;
    L6:
        if (r100 != null) goto L10;
        b.b(f277996a, "secret key is null");
        return r102;
    L10:
        if (a() == true) goto L18;
        b.b(f277996a, "sdk version is too low");
        return r102;
    L18:
        return b(r100, r101);
    L15:
        e = move-exception;
        b.b(f277996a, "e : " + e.getMessage());
        return r102;
    }

    public static byte[] encryptNew(String r100, byte[] r101) throws AesKsParamException {
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (r101 == null) goto L11;
        if (a() == true) goto L8;
        b.b(f277996a, "sdk version is too low");
        throw new AesKsParamException("sdk version is too low");
    L8:
        return encryptNew(b(r100, Boolean.TRUE), r101);
    L11:
        b.b(f277996a, "alias or encrypt content is null");
        throw new AesKsParamException("alias or encrypt content is null");
    }
}
