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
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes23.dex */
public class AesCbcKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277989a = "CBCKS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f277990b = "AndroidKeyStore";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f277991c = "AES/CBC/PKCS7Padding";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f277992d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f277993e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f277994f = 256;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Map<String, SecretKey> f277995g;

    static {
        f277995g = new ConcurrentHashMap();
    }

    private static boolean a() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    public AesCbcKS() {
    }

    private static SecretKey a(String r100, Boolean r101) {
        b.c(f277989a, "load key");
        SecretKey r102 = null;
        KeyStore r103 = KeyStore.getInstance(f277990b);     // Catch: Exception -> L12 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L16 UnrecoverableKeyException -> L18 NoSuchAlgorithmException -> L20 CertificateException -> L22 IOException -> L24 KeyStoreException -> L26
        r103.load(null);     // Catch: Exception -> L12 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L16 UnrecoverableKeyException -> L18 NoSuchAlgorithmException -> L20 CertificateException -> L22 IOException -> L24 KeyStoreException -> L26
        Key r104 = r103.getKey(r100, null);     // Catch: Exception -> L12 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L16 UnrecoverableKeyException -> L18 NoSuchAlgorithmException -> L20 CertificateException -> L22 IOException -> L24 KeyStoreException -> L26
        if (r104 == null) goto L9;
        if ((r104 instanceof SecretKey) == false) goto L9;
        r102 = (SecretKey) r104;     // Catch: Exception -> L12 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L16 UnrecoverableKeyException -> L18 NoSuchAlgorithmException -> L20 CertificateException -> L22 IOException -> L24 KeyStoreException -> L26
    L29:
    L28:
        return r102;
    L9:
        if (r101.booleanValue() == false) goto L29;
        b.c(f277989a, "generate key");     // Catch: Exception -> L12 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L16 UnrecoverableKeyException -> L18 NoSuchAlgorithmException -> L20 CertificateException -> L22 IOException -> L24 KeyStoreException -> L26
        KeyGenerator r105 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, f277990b);     // Catch: Exception -> L12 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L16 UnrecoverableKeyException -> L18 NoSuchAlgorithmException -> L20 CertificateException -> L22 IOException -> L24 KeyStoreException -> L26
        r105.init(new KeyGenParameterSpec.Builder(r100, 3).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setKeySize(256).build());     // Catch: Exception -> L12 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L16 UnrecoverableKeyException -> L18 NoSuchAlgorithmException -> L20 CertificateException -> L22 IOException -> L24 KeyStoreException -> L26
        r102 = r105.generateKey();     // Catch: Exception -> L12 NoSuchProviderException -> L14 InvalidAlgorithmParameterException -> L16 UnrecoverableKeyException -> L18 NoSuchAlgorithmException -> L20 CertificateException -> L22 IOException -> L24 KeyStoreException -> L26
    L24:
        e = move-exception;
        b.b(f277989a, "IOException: " + e.getMessage());
    L16:
        e = move-exception;
        b.b(f277989a, "InvalidAlgorithmParameterException: " + e.getMessage());
    L26:
        e = move-exception;
        b.b(f277989a, "KeyStoreException: " + e.getMessage());
    L20:
        e = move-exception;
        b.b(f277989a, "NoSuchAlgorithmException: " + e.getMessage());
    L14:
        e = move-exception;
        b.b(f277989a, "NoSuchProviderException: " + e.getMessage());
    L18:
        e = move-exception;
        b.b(f277989a, "UnrecoverableKeyException: " + e.getMessage());
    L22:
        e = move-exception;
        b.b(f277989a, "CertificateException: " + e.getMessage());
    L12:
        e = move-exception;
        b.b(f277989a, "Exception: " + e.getMessage());
        goto L28
    }

    private static SecretKey b(String r100, Boolean r101) throws AesKsParamException {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        if (f277995g.get(r100) != null) goto L23;
        monitor-enter(AesCbcKS.class);
    L19:
        th = move-exception;
        throw th;
    L11:
        if (f277995g.get(r100) != null) goto L17;
        SecretKey r102 = a(r100, r101);     // Catch: Throwable -> L19
        if (r102 == null) goto L16;
        f277995g.put(r100, r102);     // Catch: Throwable -> L19
        goto L17
    L16:
        throw new AesKsParamException("AES CBC current is decrypt,but alias is null");     // Catch: Throwable -> L19
    L17:
        monitor-exit(AesCbcKS.class);     // Catch: Throwable -> L19
    L23:
        return f277995g.get(r100);
    }

    public static byte[] decrypt(String r100, byte[] r101) throws AesKsParamException {
        byte[] r102 = new byte[0];
        if (TextUtils.isEmpty(r100) == true) goto L36;
        if (r101 == null) goto L36;
        if (a() == true) goto L11;
        b.b(f277989a, "sdk version is too low");
        return r102;
    L11:
        if (r101.length > 16) goto L14;
        b.b(f277989a, "Decrypt source data is invalid.");
        return r102;
    L14:
        SecretKey r103 = b(r100, Boolean.FALSE);
        if (r103 != null) goto L18;
        b.b(f277989a, "decrypt secret key is null");
        return r102;
    L18:
        byte[] r104 = Arrays.copyOf(r101, 16);
        Cipher r105 = Cipher.getInstance(f277991c);     // Catch: Exception -> L21 BadPaddingException -> L23 IllegalBlockSizeException -> L25 InvalidAlgorithmParameterException -> L27 InvalidKeyException -> L29 NoSuchPaddingException -> L31 NoSuchAlgorithmException -> L33
        r105.init(2, r103, new IvParameterSpec(r104));     // Catch: Exception -> L21 BadPaddingException -> L23 IllegalBlockSizeException -> L25 InvalidAlgorithmParameterException -> L27 InvalidKeyException -> L29 NoSuchPaddingException -> L31 NoSuchAlgorithmException -> L33
        return r105.doFinal(r101, 16, r101.length - 16);
    L27:
        e = move-exception;
        b.b(f277989a, "InvalidAlgorithmParameterException: " + e.getMessage());
    L35:
        return r102;
    L29:
        e = move-exception;
        b.b(f277989a, "InvalidKeyException: " + e.getMessage());
    L33:
        e = move-exception;
        b.b(f277989a, "NoSuchAlgorithmException: " + e.getMessage());
    L23:
        e = move-exception;
        b.b(f277989a, "BadPaddingException: " + e.getMessage());
    L25:
        e = move-exception;
        b.b(f277989a, "IllegalBlockSizeException: " + e.getMessage());
    L31:
        e = move-exception;
        b.b(f277989a, "NoSuchPaddingException: " + e.getMessage());
    L21:
        e = move-exception;
        b.b(f277989a, "Exception: " + e.getMessage());
    L36:
        b.b(f277989a, "alias or encrypt content is null");
        return r102;
    }

    public static byte[] encrypt(String r100, byte[] r101) {
        byte[] r102 = new byte[0];
        if (TextUtils.isEmpty(r100) == true) goto L35;
        if (r101 == null) goto L35;
        if (a() == true) goto L37;
        b.b(f277989a, "sdk version is too low");
        return r102;
    L37:
        Cipher r103 = Cipher.getInstance(f277991c);     // Catch: Exception -> L22 InvalidKeyException -> L24 IllegalBlockSizeException -> L26 BadPaddingException -> L28 NoSuchPaddingException -> L30 NoSuchAlgorithmException -> L32
        SecretKey r104 = b(r100, Boolean.TRUE);     // Catch: Exception -> L22 InvalidKeyException -> L24 IllegalBlockSizeException -> L26 BadPaddingException -> L28 NoSuchPaddingException -> L30 NoSuchAlgorithmException -> L32
        if (r104 != null) goto L14;
        b.b(f277989a, "encrypt secret key is null");     // Catch: Exception -> L22 InvalidKeyException -> L24 IllegalBlockSizeException -> L26 BadPaddingException -> L28 NoSuchPaddingException -> L30 NoSuchAlgorithmException -> L32
        return r102;
    L14:
        r103.init(1, r104);     // Catch: Exception -> L22 InvalidKeyException -> L24 IllegalBlockSizeException -> L26 BadPaddingException -> L28 NoSuchPaddingException -> L30 NoSuchAlgorithmException -> L32
        byte[] r105 = r103.doFinal(r101);     // Catch: Exception -> L22 InvalidKeyException -> L24 IllegalBlockSizeException -> L26 BadPaddingException -> L28 NoSuchPaddingException -> L30 NoSuchAlgorithmException -> L32
        byte[] r106 = r103.getIV();     // Catch: Exception -> L22 InvalidKeyException -> L24 IllegalBlockSizeException -> L26 BadPaddingException -> L28 NoSuchPaddingException -> L30 NoSuchAlgorithmException -> L32
        if (r106 != null) goto L17;
    L20:
        b.b(f277989a, "IV is invalid.");     // Catch: Exception -> L22 InvalidKeyException -> L24 IllegalBlockSizeException -> L26 BadPaddingException -> L28 NoSuchPaddingException -> L30 NoSuchAlgorithmException -> L32
        return r102;
    L17:
        if (r106.length != 16) goto L20;
        byte[] r107 = Arrays.copyOf(r106, r106.length + r105.length);     // Catch: Exception -> L22 InvalidKeyException -> L24 IllegalBlockSizeException -> L26 BadPaddingException -> L28 NoSuchPaddingException -> L30 NoSuchAlgorithmException -> L32
        System.arraycopy(r105, 0, r107, r106.length, r105.length);     // Catch: Exception -> L22 InvalidKeyException -> L24 IllegalBlockSizeException -> L26 BadPaddingException -> L28 NoSuchPaddingException -> L30 NoSuchAlgorithmException -> L32
        return r107;
    L24:
        e = move-exception;
        b.b(f277989a, "InvalidKeyException: " + e.getMessage());
        return r102;
    L32:
        e = move-exception;
        b.b(f277989a, "NoSuchAlgorithmException: " + e.getMessage());
        return r102;
    L28:
        e = move-exception;
        b.b(f277989a, "BadPaddingException: " + e.getMessage());
        return r102;
    L26:
        e = move-exception;
        b.b(f277989a, "IllegalBlockSizeException: " + e.getMessage());
        return r102;
    L30:
        e = move-exception;
        b.b(f277989a, "NoSuchPaddingException: " + e.getMessage());
        return r102;
    L22:
        e = move-exception;
        b.b(f277989a, "Exception: " + e.getMessage());
        return r102;
    L35:
        b.b(f277989a, "alias or encrypt content is null");
        return r102;
    }

    public static String decrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L15:
        b.b(f277989a, "alias or encrypt content is null");
        return "";
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        return new String(decrypt(r100, HexUtil.hexStr2ByteArray(r101)), "UTF-8");
    L10:
        e = move-exception;
        b.b(f277989a, "encrypt: AesKsParamException : " + e.getMessage());
    L14:
        return "";
    L12:
        e = move-exception;
        b.b(f277989a, "encrypt: UnsupportedEncodingException : " + e.getMessage());
        goto L14
    }

    public static String encrypt(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L10;
        b.b(f277989a, "encrypt 1 content is null");
        return "";
    L10:
        return HexUtil.byteArray2HexStr(encrypt(r100, r101.getBytes("UTF-8")));
    L8:
        b.b(f277989a, "encrypt: UnsupportedEncodingException");
        return "";
    }
}
