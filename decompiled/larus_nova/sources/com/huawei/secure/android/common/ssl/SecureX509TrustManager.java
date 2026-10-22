package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes23.dex */
public class SecureX509TrustManager implements X509TrustManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278118c = "SX509TM";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f278119d = "hmsrootcas.bks";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f278120e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f278121f = "X509";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f278122g = "bks";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f278123h = "AndroidCAStore";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<X509TrustManager> f278124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private X509Certificate[] f278125b;

    private void a() {
        e.c(f278118c, "loadSystemCA");
        long r100 = System.currentTimeMillis();
        KeyStore r101 = KeyStore.getInstance(f278123h);     // Catch: NoSuchAlgorithmException -> L10 IOException -> L12 CertificateException -> L14 KeyStoreException -> L16 NegativeArraySizeException -> L18 Throwable -> L20
        r101.load(null, null);     // Catch: NoSuchAlgorithmException -> L10 IOException -> L12 CertificateException -> L14 KeyStoreException -> L16 NegativeArraySizeException -> L18 Throwable -> L20
        TrustManagerFactory r102 = TrustManagerFactory.getInstance(f278121f);     // Catch: NoSuchAlgorithmException -> L10 IOException -> L12 CertificateException -> L14 KeyStoreException -> L16 NegativeArraySizeException -> L18 Throwable -> L20
        r102.init(r101);     // Catch: NoSuchAlgorithmException -> L10 IOException -> L12 CertificateException -> L14 KeyStoreException -> L16 NegativeArraySizeException -> L18 Throwable -> L20
        TrustManager[] r103 = r102.getTrustManagers();     // Catch: NoSuchAlgorithmException -> L10 IOException -> L12 CertificateException -> L14 KeyStoreException -> L16 NegativeArraySizeException -> L18 Throwable -> L20
        int r104 = 0;
    L5:
        if (r104 >= r103.length) goto L22;
        TrustManager r105 = r103[r104];     // Catch: NoSuchAlgorithmException -> L10 IOException -> L12 CertificateException -> L14 KeyStoreException -> L16 NegativeArraySizeException -> L18 Throwable -> L20
        if ((r105 instanceof X509TrustManager) == false) goto L9;
        this.f278124a.add((X509TrustManager) r105);     // Catch: NoSuchAlgorithmException -> L10 IOException -> L12 CertificateException -> L14 KeyStoreException -> L16 NegativeArraySizeException -> L18 Throwable -> L20
    L9:
        r104 = r104 + 1;
    L22:
        e.a(f278118c, "loadSystemCA: cost : " + (System.currentTimeMillis() - r100) + " ms");
        return;
    L20:
        e = move-exception;
        e.b(f278118c, "loadSystemCA: exception : " + e.getMessage());
        goto L22
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        ArrayList r100 = new ArrayList();     // Catch: Exception -> L8
        Iterator<X509TrustManager> r101 = this.f278124a.iterator();     // Catch: Exception -> L8
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.addAll(Arrays.asList(r101.next().getAcceptedIssuers()));     // Catch: Exception -> L8
        goto L4
    L6:
        return (X509Certificate[]) r100.toArray(new X509Certificate[r100.size()]);
    L8:
        e = move-exception;
        e.b(f278118c, "getAcceptedIssuers exception : " + e.getMessage());
        return new X509Certificate[0];
    }

    public X509Certificate[] getChain() {
        return this.f278125b;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.f278124a;
    }

    public SecureX509TrustManager(Context r100) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(r100, false);
    }

    private void a(Context r100) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        e.c(f278118c, "loadBksCA");
        long r101 = System.currentTimeMillis();
        InputStream r102 = BksUtil.getFilesBksIS(r100);
        if (r102 != null) goto L22;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L19;
        if (r102 == null) goto L19;
    L20:
        e.a(f278118c, "loadBksCA: cost : " + (System.currentTimeMillis() - r101) + " ms");
        return;
    L19:
        e.c(f278118c, " get bks from assets ");
        a(r100.getAssets().open("hmsrootcas.bks"));
        goto L20
    L22:
        e.c(f278118c, "get bks not from assets");     // Catch: IOException -> L6 Throwable -> L8 KeyStoreException -> L10 NoSuchAlgorithmException -> L12 OutOfMemoryError -> L14
        a(r102);     // Catch: IOException -> L6 Throwable -> L8 KeyStoreException -> L10 NoSuchAlgorithmException -> L12 OutOfMemoryError -> L14
    L8:
        e = move-exception;
        e.b(f278118c, "loadBksCA: exception : " + e.getMessage());
        r103 = false;
        goto L17
    }

    public void setChain(X509Certificate[] r100) {
        this.f278125b = r100;
    }

    public void setX509TrustManagers(List<X509TrustManager> r100) {
        this.f278124a = r100;
    }

    public SecureX509TrustManager(String r100) throws IllegalArgumentException, FileNotFoundException {
        this(r100, false);
    }

    private void a(InputStream r100) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        TrustManagerFactory r101 = TrustManagerFactory.getInstance(f278121f);     // Catch: Throwable -> L11
        KeyStore r102 = KeyStore.getInstance("bks");     // Catch: Throwable -> L11
        r102.load(r100, "".toCharArray());     // Catch: Throwable -> L11
        r101.init(r102);     // Catch: Throwable -> L11
        TrustManager[] r103 = r101.getTrustManagers();     // Catch: Throwable -> L11
        int r104 = 0;
    L4:
        if (r104 >= r103.length) goto L9;
        TrustManager r105 = r103[r104];     // Catch: Throwable -> L11
        if ((r105 instanceof X509TrustManager) == false) goto L8;
        this.f278124a.add((X509TrustManager) r105);     // Catch: Throwable -> L11
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        d.a(r100);
        return;
    L11:
        th = move-exception;
        d.a(r100);
        throw th;
    }

    public SecureX509TrustManager(Context r100, boolean r101) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f278124a = new ArrayList();
        if (r100 == null) goto L13;
        ContextUtil.setContext(r100);
        a(r100);
        if (r101 == false) goto L8;
        a();
    L8:
        if (this.f278124a.isEmpty() == true) goto L11;
        return;
    L11:
        throw new CertificateException("X509TrustManager is empty");
    L13:
        throw new IllegalArgumentException("context is null");
    }

    private void a(InputStream r100, String r101) {
        if (r100 == null) goto L34;
        if (r101 == null) goto L34;
        long r102 = System.currentTimeMillis();
        TrustManagerFactory r103 = TrustManagerFactory.getInstance(f278121f);     // Catch: Throwable -> L14 NoSuchAlgorithmException -> L16 IOException -> L18 Throwable -> L20 KeyStoreException -> L22 NegativeArraySizeException -> L24 OutOfMemoryError -> L26
        KeyStore r104 = KeyStore.getInstance("bks");     // Catch: Throwable -> L14 NoSuchAlgorithmException -> L16 IOException -> L18 Throwable -> L20 KeyStoreException -> L22 NegativeArraySizeException -> L24 OutOfMemoryError -> L26
        r104.load(r100, r101.toCharArray());     // Catch: Throwable -> L14 NoSuchAlgorithmException -> L16 IOException -> L18 Throwable -> L20 KeyStoreException -> L22 NegativeArraySizeException -> L24 OutOfMemoryError -> L26
        r103.init(r104);     // Catch: Throwable -> L14 NoSuchAlgorithmException -> L16 IOException -> L18 Throwable -> L20 KeyStoreException -> L22 NegativeArraySizeException -> L24 OutOfMemoryError -> L26
        TrustManager[] r105 = r103.getTrustManagers();     // Catch: Throwable -> L14 NoSuchAlgorithmException -> L16 IOException -> L18 Throwable -> L20 KeyStoreException -> L22 NegativeArraySizeException -> L24 OutOfMemoryError -> L26
        int r106 = 0;
    L8:
        if (r106 >= r105.length) goto L13;
        TrustManager r107 = r105[r106];     // Catch: Throwable -> L14 NoSuchAlgorithmException -> L16 IOException -> L18 Throwable -> L20 KeyStoreException -> L22 NegativeArraySizeException -> L24 OutOfMemoryError -> L26
        if ((r107 instanceof X509TrustManager) == false) goto L12;
        this.f278124a.add((X509TrustManager) r107);     // Catch: Throwable -> L14 NoSuchAlgorithmException -> L16 IOException -> L18 Throwable -> L20 KeyStoreException -> L22 NegativeArraySizeException -> L24 OutOfMemoryError -> L26
    L12:
        r106 = r106 + 1;
        goto L8
    L13:
        d.a(r100);
    L29:
        e.a(f278118c, "loadInputStream: cost : " + (System.currentTimeMillis() - r102) + " ms");
        return;
    L14:
        th = move-exception;
        d.a(r100);
        throw th;
    L20:
        e = move-exception;
        e.b(f278118c, "loadInputStream: exception : " + e.getMessage());     // Catch: Throwable -> L14
        d.a(r100);
    L34:
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] r100, String r101) throws CertificateException {
        e.c(f278118c, "checkClientTrusted: ");
        Iterator<X509TrustManager> r102 = this.f278124a.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        r102.next().checkServerTrusted(r100, r101);     // Catch: CertificateException -> L8
        return;
    L8:
        e = move-exception;
        e.b(f278118c, "checkServerTrusted CertificateException" + e.getMessage());
        goto L4
    L11:
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] r110, String r111) throws CertificateException {
        setChain(r110);
        e.c(f278118c, "checkServerTrusted begin,size=" + r110.length + ",authType=" + r111);
        long r100 = System.currentTimeMillis();
        int r101 = this.f278124a.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L17;
        e.c(f278118c, "check server i=" + r102);     // Catch: CertificateException -> L9
        X509TrustManager r103 = (X509TrustManager) ListProtector.get(this.f278124a, r102);     // Catch: CertificateException -> L9
        X509Certificate[] r104 = r103.getAcceptedIssuers();     // Catch: CertificateException -> L9
        if (r104 == null) goto L7;
        e.c(f278118c, "client root ca size=" + r104.length);     // Catch: CertificateException -> L9
    L7:
        r103.checkServerTrusted(r110, r111);     // Catch: CertificateException -> L9
        e.c(f278118c, "checkServerTrusted end, " + r110[r110.length - 1].getIssuerDN());     // Catch: CertificateException -> L9
        return;
    L9:
        e = move-exception;
        e.b(f278118c, "checkServerTrusted error :" + e.getMessage() + " , time : " + r102);
        if (r102 == (r101 - 1)) goto L13;
        r102 = r102 + 1;
        goto L3
    L13:
        if (r110.length <= 0) goto L15;
        e.b(f278118c, "root ca issuer : " + r110[r110.length - 1].getIssuerDN());
    L15:
        throw e;
    L17:
        e.a(f278118c, "checkServerTrusted: cost : " + (System.currentTimeMillis() - r100) + " ms");
    }

    public SecureX509TrustManager(String r100, boolean r101) throws IllegalArgumentException, FileNotFoundException {
        this.f278124a = new ArrayList();
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L11
        a(r102, "");     // Catch: Throwable -> L9
        d.a(r102);
        if (r101 == false) goto L19;
        a();
        return;
    L19:
        return;
    L9:
        th = th;
    L13:
        d.a(r102);
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public SecureX509TrustManager(InputStream r100, String r101) throws IllegalArgumentException {
        this.f278124a = new ArrayList();
        a(r100, r101);
    }

    public SecureX509TrustManager(InputStream r100, String r101, boolean r102) throws IllegalArgumentException {
        this.f278124a = new ArrayList();
        a(r100, r101);
        if (r102 == false) goto L6;
        a();
        return;
    }
}
