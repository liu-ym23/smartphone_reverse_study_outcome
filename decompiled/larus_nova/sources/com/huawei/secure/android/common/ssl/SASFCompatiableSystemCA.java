package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes23.dex */
public class SASFCompatiableSystemCA extends SSLSocketFactory {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f278056i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile SASFCompatiableSystemCA f278057j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f278058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLSocket f278059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f278060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f278061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private X509TrustManager f278062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f278063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f278064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f278065h;

    static {
        f278056i = "SASFCompatiableSystemCA";
        f278057j = null;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.c(f278056i, "createSocket: ");
        Socket r100 = this.f278058a.getSocketFactory().createSocket();
        if ((r100 instanceof SSLSocket) == false) goto L5;
        a(r100);
        SSLSocket r101 = (SSLSocket) r100;
        this.f278059b = r101;
        this.f278061d = (String[]) r101.getEnabledCipherSuites().clone();
    L5:
        return r100;
    }

    public X509Certificate[] getChain() {
        X509TrustManager r100 = this.f278062e;
        if ((r100 instanceof SecureX509TrustManager) == false) goto L7;
        return ((SecureX509TrustManager) r100).getChain();
    L7:
        return new X509Certificate[0];
    }

    public String[] getSupportedCipherSuites() {
        String[] r100 = this.f278061d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new String[0];
    }

    public String[] getBlackCiphers() {
        return this.f278063f;
    }

    public Context getContext() {
        return this.f278060c;
    }

    public String[] getProtocols() {
        return this.f278065h;
    }

    public SSLContext getSslContext() {
        return this.f278058a;
    }

    public SSLSocket getSslSocket() {
        return this.f278059b;
    }

    public String[] getWhiteCiphers() {
        return this.f278064g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f278062e;
    }

    private SASFCompatiableSystemCA(KeyStore r100) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(r100);
        this.f278059b = null;
    }

    private void a(Socket r100) {
        boolean r101 = false;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278065h) == true) goto L5;
        e.c(f278056i, "set protocols");
        boolean r102 = SSLUtil.setEnabledProtocols((SSLSocket) r100, this.f278065h);
    L7:
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278064g) == true) goto L9;
    L10:
        e.c(f278056i, "set white cipher or black cipher");
        SSLSocket r103 = (SSLSocket) r100;
        SSLUtil.setEnabledProtocols(r103);
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278064g) == true) goto L13;
        r101 = SSLUtil.setWhiteListCipherSuites(r103, this.f278064g);
    L14:
        if (r102 == true) goto L16;
        e.c(f278056i, "set default protocols");
        SSLUtil.setEnabledProtocols((SSLSocket) r100);
    L16:
        if (r101 == true) goto L19;
        e.c(f278056i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) r100);
        return;
    L19:
        return;
    L13:
        r101 = SSLUtil.setBlackListCipherSuites(r103, this.f278063f);
        goto L14
    L9:
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278063f) == true) goto L14;
    L5:
        r102 = false;
        goto L7
    }

    public void setBlackCiphers(String[] r100) {
        this.f278063f = r100;
    }

    public void setContext(Context r100) {
        this.f278060c = r100.getApplicationContext();
    }

    public void setProtocols(String[] r100) {
        this.f278065h = r100;
    }

    public void setSslContext(SSLContext r100) {
        this.f278058a = r100;
    }

    public void setSslSocket(SSLSocket r100) {
        this.f278059b = r100;
    }

    public void setWhiteCiphers(String[] r100) {
        this.f278064g = r100;
    }

    public void setX509TrustManager(X509TrustManager r100) {
        this.f278062e = r100;
    }

    public static void a(X509TrustManager r100) {
        e.c(f278056i, "sasfc update socket factory trust manager");
        long r101 = System.currentTimeMillis();
        f278057j = new SASFCompatiableSystemCA(null, r100);     // Catch: KeyStoreException -> L5 UnrecoverableKeyException -> L6 KeyManagementException -> L7 NoSuchAlgorithmException -> L8
    L9:
        e.a(f278056i, "sasf system ca update: cost : " + (System.currentTimeMillis() - r101) + " ms");
        return;
    L7:
        e.b(f278056i, "KeyManagementException");
    L5:
        e.b(f278056i, "KeyStoreException");
    L8:
        e.b(f278056i, "NoSuchAlgorithmException");
    L6:
        e.b(f278056i, "UnrecoverableKeyException");
        goto L9
    }

    public SASFCompatiableSystemCA(KeyStore r100, X509TrustManager r101) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(r100);
        this.f278059b = null;
        this.f278058a = SSLUtil.setSSLContext();
        setX509TrustManager(r101);
        this.f278058a.init(null, new X509TrustManager[]{r101}, null);
    }

    public static void a(X509TrustManager r100, SecureRandom r101) {
        e.c(f278056i, "sasfc update socket factory trust manager");
        long r102 = System.currentTimeMillis();
        f278057j = new SASFCompatiableSystemCA(null, r100, r101);     // Catch: KeyStoreException -> L5 UnrecoverableKeyException -> L6 KeyManagementException -> L7 NoSuchAlgorithmException -> L8
    L9:
        e.a(f278056i, "sasf system ca update: cost : " + (System.currentTimeMillis() - r102) + " ms");
        return;
    L7:
        e.b(f278056i, "KeyManagementException");
    L5:
        e.b(f278056i, "KeyStoreException");
    L8:
        e.b(f278056i, "NoSuchAlgorithmException");
    L6:
        e.b(f278056i, "UnrecoverableKeyException");
        goto L9
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore r100, Context r101) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(r101);
        if (f278057j != null) goto L15;
        monitor-enter(SecureApacheSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f278057j != null) goto L9;
        f278057j = new SASFCompatiableSystemCA(r100, r101, null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureApacheSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        return f278057j;
    }

    private SASFCompatiableSystemCA(KeyStore r100, Context r101, SecureRandom r102) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException, NullPointerException {
        super(r100);
        this.f278059b = null;
        setContext(r101);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager r103 = SSFSecureX509SingleInstance.getInstance(r101);
        this.f278062e = r103;
        this.f278058a.init(null, new X509TrustManager[]{r103}, r102);
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore r100, Context r101, SecureRandom r102) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(r101);
        if (f278057j != null) goto L15;
        monitor-enter(SecureApacheSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f278057j != null) goto L9;
        f278057j = new SASFCompatiableSystemCA(r100, r101, r102);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureApacheSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        return f278057j;
    }

    public SASFCompatiableSystemCA(KeyStore r100, X509TrustManager r101, SecureRandom r102) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(r100);
        this.f278059b = null;
        this.f278058a = SSLUtil.setSSLContext();
        setX509TrustManager(r101);
        this.f278058a.init(null, new X509TrustManager[]{r101}, r102);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        e.c(f278056i, "createSocket: socket host port autoClose");
        Socket r104 = this.f278058a.getSocketFactory().createSocket(r100, r101, r102, r103);
        if ((r104 instanceof SSLSocket) == false) goto L5;
        a(r104);
        SSLSocket r105 = (SSLSocket) r104;
        this.f278059b = r105;
        this.f278061d = (String[]) r105.getEnabledCipherSuites().clone();
    L5:
        return r104;
    }
}
