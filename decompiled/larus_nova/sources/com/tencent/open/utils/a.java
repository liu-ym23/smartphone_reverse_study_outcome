package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.tencent.open.log.SLog;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes35.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private KeyStore f461828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f461829b;

    private void a() throws Exception {
        byte[] r100 = new byte[16];
        SecureRandom r101 = new SecureRandom();
        r101.nextBytes(r100);
        c(Base64.encodeToString(r101.generateSeed(12), 0));
        PublicKey r102 = this.f461828a.getCertificate("KEYSTORE_AES").getPublicKey();
        Cipher r103 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r103.init(1, r102);
        d(Base64.encodeToString(r103.doFinal(r100), 0));
    }

    private byte[] b() {
        return Base64.decode(this.f461829b.getString("PREF_KEY_IV", ""), 0);
    }

    private SecretKeySpec c() throws Exception {
        String r100 = this.f461829b.getString("PREF_KEY_AES", "");
        PrivateKey r101 = (PrivateKey) this.f461828a.getKey("KEYSTORE_AES", null);
        Cipher r102 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r102.init(2, r101);
        return new SecretKeySpec(r102.doFinal(Base64.decode(r100, 0)), SecurityUtil.ENCRYPT_GCM);
    }

    public a(Context r100) {
        this.f461829b = r100.getSharedPreferences("KEYSTORE_SETTING", 0);     // Catch: Exception -> L7
        KeyStore r101 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L7
        this.f461828a = r101;     // Catch: Exception -> L7
        r101.load(null);     // Catch: Exception -> L7
        if (this.f461828a.containsAlias("KEYSTORE_AES") == true) goto L12;
        c("");     // Catch: Exception -> L7
        a(r100);     // Catch: Exception -> L7
        a();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        SLog.d("KEYSTORE", "Exception", e);
    }

    private void a(Context r100) throws Exception {
        StringBuilder r101 = new StringBuilder("Build.VERSION.SDK_INT=");
        int r102 = Build.VERSION.SDK_INT;
        r101.append(r102);
        SLog.d("KEYSTORE", r101.toString());
        if (r102 < 23) goto L5;
        KeyPairGenerator r103 = KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.f25615a, "AndroidKeyStore");
        r103.initialize(new KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests(new String[]{"SHA-256", "SHA-512"}).setEncryptionPaddings(new String[]{com.baidu.bbalbscesium.k.d.c.f30370p}).build());
        r103.generateKeyPair();
        return;
    L5:
        KeyPairGenerator r104 = KeyPairGenerator.getInstance(com.alipay.sdk.m.n.d.f25615a, "AndroidKeyStore");
        Calendar r105 = Calendar.getInstance();
        Calendar r106 = Calendar.getInstance();
        r106.add(1, 30);
        r104.initialize(new KeyPairGeneratorSpec.Builder(r100).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(r105.getTime()).setEndDate(r106.getTime()).build());
        r104.generateKeyPair();
    }

    private void c(String r100) {
        this.f461829b.edit().putString("PREF_KEY_IV", r100).apply();
    }

    private void d(String r100) {
        this.f461829b.edit().putString("PREF_KEY_AES", r100).apply();
    }

    public String b(String r100) {
        byte[] r101 = Base64.decode(r100.getBytes(), 0);     // Catch: Exception -> L4
        Cipher r102 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L4
        r102.init(2, c(), new IvParameterSpec(b()));     // Catch: Exception -> L4
        return new String(r102.doFinal(r101));
    L4:
        e = move-exception;
        SLog.e("KEYSTORE", "Exception", e);
        return "";
    }

    public String a(String r100) {
        Cipher r101 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L4
        r101.init(1, c(), new IvParameterSpec(b()));     // Catch: Exception -> L4
        return Base64.encodeToString(r101.doFinal(r100.getBytes()), 0);
    L4:
        e = move-exception;
        SLog.e("KEYSTORE", "Exception", e);
        return "";
    }
}
