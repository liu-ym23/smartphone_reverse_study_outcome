package com.cmic.ida.sdk;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes22.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f273179a;

    public static void a() {
        n0.a("AES_KEY");
    }

    private static String b() {
        return n0.a("AES_KEY", "");
    }

    private static String c() {
        return n0.a("AES_IV", "");
    }

    private static boolean a(Context r110) {
        if (Build.VERSION.SDK_INT >= 23) goto L17;
        Calendar r100 = Calendar.getInstance();
        Calendar r101 = Calendar.getInstance();
        r101.add(1, 30);
        KeyPairGeneratorSpec r111 = new KeyPairGeneratorSpec.Builder(r110).setAlias("CMCC_SDK_V1").setSubject(new X500Principal("CN=CMCC_SDK_V1")).setSerialNumber(BigInteger.TEN).setStartDate(r100.getTime()).setEndDate(r101.getTime()).build();     // Catch: Exception -> L12
        KeyPairGenerator r102 = KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.f25615a, "AndroidKeyStore");     // Catch: Exception -> L12
        r102.initialize(r111);     // Catch: Exception -> L12
        Thread.sleep(1000);     // Catch: Exception -> L12
        r102.generateKeyPair();     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        u.b("KeystoreUtil", e.getMessage());
        return false;
    L17:
        KeyGenerator r112 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, "AndroidKeyStore");     // Catch: Exception -> L6
        r112.init(new KeyGenParameterSpec.Builder("CMCC_SDK_V1", 3).setDigests(new String[]{"SHA-256", "SHA-512"}).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setRandomizedEncryptionRequired(false).setKeySize(256).build());     // Catch: Exception -> L6
        Thread.sleep(1000);     // Catch: Exception -> L6
        r112.generateKey();     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        u.b("KeystoreUtil", e.getMessage());
        return false;
    }

    public static synchronized byte[] b(Context r110) {
        monitor-enter(q.class);
        KeyStore r100 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Throwable -> L37 Exception -> L39
        r100.load(null);     // Catch: Throwable -> L37 Exception -> L39
        if (a(r110, false) == true) goto L9;
        monitor-exit(q.class);
        return null;
    L9:
        String r111 = b();     // Catch: Throwable -> L37 Exception -> L39
        if (TextUtils.isEmpty(r111) == false) goto L21;
        byte[] r112 = y0.b();     // Catch: Throwable -> L37 Exception -> L39
        f273179a = y0.b();     // Catch: Throwable -> L37 Exception -> L39
        Key r101 = r100.getKey("CMCC_SDK_V1", null);     // Catch: Throwable -> L37 Exception -> L39
        if ((r101 instanceof SecretKey) == false) goto L15;
        u.a("KeystoreUtil", "随机生成aes秘钥");     // Catch: Throwable -> L37 Exception -> L39
        Cipher r102 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Throwable -> L37 Exception -> L39
        r102.init(1, r101, new IvParameterSpec(f273179a));     // Catch: Throwable -> L37 Exception -> L39
    L17:
        String r103 = Base64.encodeToString(r102.doFinal(r112), 0);     // Catch: Throwable -> L37 Exception -> L39
        String r104 = Base64.encodeToString(f273179a, 0);     // Catch: Throwable -> L37 Exception -> L39
        HashMap r105 = new HashMap();     // Catch: Throwable -> L37 Exception -> L39
        r105.put("AES_IV", r104);     // Catch: Throwable -> L37 Exception -> L39
        r105.put("AES_KEY", r103);     // Catch: Throwable -> L37 Exception -> L39
        n0.a(r105);     // Catch: Throwable -> L37 Exception -> L39
    L32:
        u.a("KeystoreUtil", "是否解密出秘钥：" + Base64.encodeToString(r112, 0));     // Catch: Throwable -> L37 Exception -> L39
        monitor-exit(q.class);
        return r112;
    L15:
        if ((r101 instanceof PrivateKey) == false) goto L19;
        PublicKey r106 = r100.getCertificate("CMCC_SDK_V1").getPublicKey();     // Catch: Throwable -> L37 Exception -> L39
        r102 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");     // Catch: Throwable -> L37 Exception -> L39
        u.a("KeystoreUtil", "生成rsa密");     // Catch: Throwable -> L37 Exception -> L39
        r102.init(1, r106);     // Catch: Throwable -> L37 Exception -> L39
        goto L17
    L19:
        monitor-exit(q.class);
        return null;
    L21:
        f273179a = Base64.decode(c(), 0);     // Catch: Throwable -> L37 Exception -> L39
        byte[] r113 = Base64.decode(r111, 0);     // Catch: Throwable -> L37 Exception -> L39
        Key r107 = r100.getKey("CMCC_SDK_V1", null);     // Catch: Throwable -> L37 Exception -> L39
        if (r107 != null) goto L26;
        monitor-exit(q.class);
        return null;
    L26:
        if ((r107 instanceof SecretKey) == false) goto L29;
        Cipher r108 = Cipher.getInstance("AES/CBC/PKCS7Padding");     // Catch: Throwable -> L37 Exception -> L39
        r108.init(2, r107, new IvParameterSpec(f273179a));     // Catch: Throwable -> L37 Exception -> L39
        u.a("KeystoreUtil", "使用aes");     // Catch: Throwable -> L37 Exception -> L39
    L31:
        r112 = r108.doFinal(r113);     // Catch: Throwable -> L37 Exception -> L39
        StringBuilder r109 = new StringBuilder("是否解密出秘钥：");     // Catch: Throwable -> L37 Exception -> L39
        r109.append(!TextUtils.isEmpty(Base64.encodeToString(r112, 0)));     // Catch: Throwable -> L37 Exception -> L39
        u.a("KeystoreUtil", r109.toString());     // Catch: Throwable -> L37 Exception -> L39
        goto L32
    L29:
        if ((r107 instanceof PrivateKey) == false) goto L35;
        r108 = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");     // Catch: Throwable -> L37 Exception -> L39
        r108.init(2, r107);     // Catch: Throwable -> L37 Exception -> L39
        u.a("KeystoreUtil", "使用rsa");     // Catch: Throwable -> L37 Exception -> L39
        goto L31
    L35:
        monitor-exit(q.class);
        return null;
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
        return null;
    L37:
        th = move-exception;
        throw th;
    }

    public static boolean a(Context r100, boolean r101) {
        KeyStore r102 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L6
        r102.load(null);     // Catch: Exception -> L6
        if (r102.getKey("CMCC_SDK_V1", null) == null) goto L8;
        return true;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        return a(r100);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static String b(Context r100, String r101) {
        byte[] r102 = b(r100);
        if (r102 != null) goto L5;
        a();
        return null;
    L5:
        return a.b(r102, r101, f273179a);
    }

    public static String a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L11;
        byte[] r102 = b(r100);
        if (r102 != null) goto L7;
        a();
        return null;
    L7:
        return a.a(r102, r101, f273179a);
    L11:
        return null;
    }
}
