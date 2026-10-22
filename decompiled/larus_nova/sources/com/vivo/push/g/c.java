package com.vivo.push.g;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.vivo.push.util.t;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PrivateKey f462332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PublicKey f462333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private KeyStore f462334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private X500Principal f462335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f462336e;

    private void b() {
        KeyStore r100 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L4
        this.f462334c = r100;     // Catch: Exception -> L4
        r100.load(null);     // Catch: Exception -> L4
        this.f462335d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        t.a("RsaSecurity", "initKeyStore error" + e.getMessage());
    }

    @Override // com.vivo.push.g.a
    public final PublicKey a() {
        PublicKey r100 = this.f462333b;     // Catch: Exception -> L9
        if (r100 == null) goto L5;
        return r100;
    L5:
        KeyStore.Entry r101 = d(this.f462336e);     // Catch: Exception -> L9
        if ((r101 instanceof KeyStore.PrivateKeyEntry) == false) goto L15;
        PublicKey r102 = ((KeyStore.PrivateKeyEntry) r101).getCertificate().getPublicKey();     // Catch: Exception -> L9
        this.f462333b = r102;     // Catch: Exception -> L9
        return r102;
    L15:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        t.a("RsaSecurity", "getPublicKeySign error" + e.getMessage());
        return null;
    }

    public c(Context r100) {
        this.f462332a = null;
        this.f462333b = null;
        this.f462336e = r100;
        a(r100);
    }

    private void b(Context r100) {
        if (r100 != null) goto L6;
        t.d("RsaSecurity", " generateRSAKeyPairSign context == null ");     // Catch: Exception -> L8
        return;
    L6:
        Calendar r101 = Calendar.getInstance();     // Catch: Exception -> L8
        Calendar r102 = Calendar.getInstance();     // Catch: Exception -> L8
        r102.add(1, 999);     // Catch: Exception -> L8
        KeyPairGeneratorSpec r103 = new KeyPairGeneratorSpec.Builder(r100.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.f462335d).setSerialNumber(BigInteger.valueOf(1337)).setStartDate(r101.getTime()).setEndDate(r102.getTime()).build();     // Catch: Exception -> L8
        KeyPairGenerator r104 = KeyPairGenerator.getInstance(d.f25615a, "AndroidKeyStore");     // Catch: Exception -> L8
        r104.initialize(r103);     // Catch: Exception -> L8
        r104.generateKeyPair();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        t.a("RsaSecurity", "generateRSAKeyPairSign error" + e.getMessage());
    }

    private PrivateKey c(Context r100) {
        PrivateKey r101 = this.f462332a;     // Catch: Exception -> L13
        if (r101 == null) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L9;
        t.d("RsaSecurity", " getPrivateKeySigin context == null ");     // Catch: Exception -> L13
        return null;
    L9:
        KeyStore.Entry r102 = d(r100);     // Catch: Exception -> L13
        if ((r102 instanceof KeyStore.PrivateKeyEntry) == false) goto L15;
        PrivateKey r103 = ((KeyStore.PrivateKeyEntry) r102).getPrivateKey();     // Catch: Exception -> L13
        this.f462332a = r103;     // Catch: Exception -> L13
        return r103;
    L15:
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
        t.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
        goto L15
    }

    private KeyStore.Entry d(Context r100) throws UnrecoverableEntryException, NoSuchAlgorithmException, KeyStoreException {
        if (r100 != null) goto L7;
        t.d("RsaSecurity", " getPrivateKeySigin context == null ");     // Catch: Exception -> L11
        return null;
    L7:
        if (b("PushRsaKeyAlias") == true) goto L15;
        b(r100);     // Catch: Exception -> L11
    L15:
        return this.f462334c.getEntry("PushRsaKeyAlias", null);
    L11:
        e = move-exception;
        b(r100);
        KeyStore.Entry r101 = this.f462334c.getEntry("PushRsaKeyAlias", null);
        e.printStackTrace();
        t.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
        return r101;
    }

    @Override // com.vivo.push.g.a
    public final String a(String r100) {
    L9:
        e = move-exception;
        e.printStackTrace();
        t.a("RsaSecurity", "signClientSDK error" + e.getMessage());
        return null;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (c(this.f462336e) == null) goto L16;
        byte[] r101 = r100.getBytes("UTF-8");     // Catch: Exception -> L9
        PrivateKey r102 = c(this.f462336e);     // Catch: Exception -> L9
        Signature r103 = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);     // Catch: Exception -> L9
        r103.initSign(r102);     // Catch: Exception -> L9
        r103.update(r101);     // Catch: Exception -> L9
        String r104 = Base64.encodeToString(r103.sign(), 2);     // Catch: Exception -> L9
        t.d("RsaSecurity", r100.hashCode() + " = " + r104);     // Catch: Exception -> L9
        return r104;
    L16:
        return null;
    }

    private synchronized void a(Context r100) {
        monitor-enter(this);
        b();     // Catch: Throwable -> L8 Exception -> L10
        if (b("PushRsaKeyAlias") == true) goto L6;
        b(r100);     // Catch: Throwable -> L8 Exception -> L10
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        t.a("RsaSecurity", "init error" + e.getMessage());     // Catch: Throwable -> L8
    }

    private boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return false;
    L13:
    L10:
        e = move-exception;
        e.printStackTrace();
        t.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
        return false;
    L6:
        if (this.f462334c != null) goto L8;
        b();     // Catch: Exception -> L10
    L8:
        return this.f462334c.containsAlias(r100);
    }

    @Override // com.vivo.push.g.a
    public final boolean a(byte[] r100, PublicKey r101, byte[] r102) {
        Signature r103 = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);     // Catch: Exception -> L4
        r103.initVerify(r101);     // Catch: Exception -> L4
        r103.update(r100);     // Catch: Exception -> L4
        return r103.verify(r102);
    L4:
        e = move-exception;
        e.printStackTrace();
        t.a("RsaSecurity", "verifyClientSDK error" + e.getMessage());
        return false;
    }
}
