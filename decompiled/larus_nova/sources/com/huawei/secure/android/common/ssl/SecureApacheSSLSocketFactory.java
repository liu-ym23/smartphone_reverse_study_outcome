package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: loaded from: classes23.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = null;
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f278086i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile SecureApacheSSLSocketFactory f278087j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f278088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLSocket f278089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f278090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f278091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private X509TrustManager f278092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f278093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f278094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f278095h;

    static {
        BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
        STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
        f278086i = "SecureApacheSSLSocketFactory";
        f278087j = null;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.c(f278086i, "createSocket: ");
        Socket r100 = this.f278088a.getSocketFactory().createSocket();
        if ((r100 instanceof SSLSocket) == false) goto L5;
        a(r100);
        SSLSocket r101 = (SSLSocket) r100;
        this.f278089b = r101;
        this.f278091d = (String[]) r101.getEnabledCipherSuites().clone();
    L5:
        return r100;
    }

    public X509Certificate[] getChain() {
        X509TrustManager r100 = this.f278092e;
        if ((r100 instanceof SecureX509TrustManager) == false) goto L7;
        return ((SecureX509TrustManager) r100).getChain();
    L7:
        return new X509Certificate[0];
    }

    public String[] getSupportedCipherSuites() {
        String[] r100 = this.f278091d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new String[0];
    }

    public String[] getBlackCiphers() {
        return this.f278093f;
    }

    public Context getContext() {
        return this.f278090c;
    }

    public String[] getProtocols() {
        return this.f278095h;
    }

    public SSLContext getSslContext() {
        return this.f278088a;
    }

    public SSLSocket getSslSocket() {
        return this.f278089b;
    }

    public String[] getWhiteCiphers() {
        return this.f278094g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f278092e;
    }

    private SecureApacheSSLSocketFactory(KeyStore r100) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(r100);
        this.f278089b = null;
    }

    private void a(Socket r100) {
        boolean r101 = false;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278095h) == true) goto L5;
        e.c(f278086i, "set protocols");
        boolean r102 = SSLUtil.setEnabledProtocols((SSLSocket) r100, this.f278095h);
    L7:
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278094g) == true) goto L9;
    L10:
        e.c(f278086i, "set white cipher or black cipher");
        SSLSocket r103 = (SSLSocket) r100;
        SSLUtil.setEnabledProtocols(r103);
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278094g) == true) goto L13;
        r101 = SSLUtil.setWhiteListCipherSuites(r103, this.f278094g);
    L14:
        if (r102 == true) goto L16;
        e.c(f278086i, "set default protocols");
        SSLUtil.setEnabledProtocols((SSLSocket) r100);
    L16:
        if (r101 == true) goto L19;
        e.c(f278086i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) r100);
        return;
    L19:
        return;
    L13:
        r101 = SSLUtil.setBlackListCipherSuites(r103, this.f278093f);
        goto L14
    L9:
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278093f) == true) goto L14;
    L5:
        r102 = false;
        goto L7
    }

    public void setBlackCiphers(String[] r100) {
        this.f278093f = r100;
    }

    public void setContext(Context r100) {
        this.f278090c = r100.getApplicationContext();
    }

    public void setProtocols(String[] r100) {
        this.f278095h = r100;
    }

    public void setSslContext(SSLContext r100) {
        this.f278088a = r100;
    }

    public void setSslSocket(SSLSocket r100) {
        this.f278089b = r100;
    }

    public void setWhiteCiphers(String[] r100) {
        this.f278094g = r100;
    }

    public void setX509TrustManager(X509TrustManager r100) {
        this.f278092e = r100;
    }

    public static void a(X509TrustManager r100) {
        e.c(f278086i, "sasf update socket factory trust manager");
        f278087j = new SecureApacheSSLSocketFactory(null, r100);     // Catch: IOException -> L5 CertificateException -> L6 KeyStoreException -> L7 UnrecoverableKeyException -> L8 KeyManagementException -> L9 NoSuchAlgorithmException -> L10
    L19:
        return;
    L5:
        e.b(f278086i, "IOException");
        return;
    L9:
        e.b(f278086i, "KeyManagementException");
        return;
    L7:
        e.b(f278086i, "KeyStoreException");
        return;
    L10:
        e.b(f278086i, "NoSuchAlgorithmException");
        return;
    L8:
        e.b(f278086i, "UnrecoverableKeyException");
        return;
    L6:
        e.b(f278086i, "CertificateException");
    }

    public SecureApacheSSLSocketFactory(KeyStore r100, X509TrustManager r101) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(r100);
        this.f278089b = null;
        this.f278088a = SSLUtil.setSSLContext();
        setX509TrustManager(r101);
        this.f278088a.init(null, new X509TrustManager[]{r101}, null);
    }

    public static void a(X509TrustManager r100, SecureRandom r101) {
        e.c(f278086i, "sasf update socket factory trust manager");
        f278087j = new SecureApacheSSLSocketFactory(null, r100, r101);     // Catch: IOException -> L5 CertificateException -> L6 KeyStoreException -> L7 UnrecoverableKeyException -> L8 KeyManagementException -> L9 NoSuchAlgorithmException -> L10
    L19:
        return;
    L5:
        e.b(f278086i, "IOException");
        return;
    L9:
        e.b(f278086i, "KeyManagementException");
        return;
    L7:
        e.b(f278086i, "KeyStoreException");
        return;
    L10:
        e.b(f278086i, "NoSuchAlgorithmException");
        return;
    L8:
        e.b(f278086i, "UnrecoverableKeyException");
        return;
    L6:
        e.b(f278086i, "CertificateException");
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore r100, Context r101) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(r101);
        if (f278087j != null) goto L15;
        monitor-enter(SecureApacheSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f278087j != null) goto L9;
        f278087j = new SecureApacheSSLSocketFactory(r100, r101, null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureApacheSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        return f278087j;
    }

    private SecureApacheSSLSocketFactory(KeyStore r100, Context r101, SecureRandom r102) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException, NullPointerException {
        super(r100);
        this.f278089b = null;
        setContext(r101);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager r103 = SecureX509SingleInstance.getInstance(r101);
        this.f278092e = r103;
        this.f278088a.init(null, new X509TrustManager[]{r103}, r102);
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore r100, Context r101, SecureRandom r102) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(r101);
        if (f278087j != null) goto L15;
        monitor-enter(SecureApacheSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f278087j != null) goto L9;
        f278087j = new SecureApacheSSLSocketFactory(r100, r101, r102);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureApacheSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        return f278087j;
    }

    public SecureApacheSSLSocketFactory(KeyStore r100, InputStream r101, String r102) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(r100);
        this.f278089b = null;
        this.f278088a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r103 = new HiCloudX509TrustManager(r101, r102);
        setX509TrustManager(r103);
        this.f278088a.init(null, new X509TrustManager[]{r103}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore r100, X509TrustManager r101, SecureRandom r102) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(r100);
        this.f278089b = null;
        this.f278088a = SSLUtil.setSSLContext();
        setX509TrustManager(r101);
        this.f278088a.init(null, new X509TrustManager[]{r101}, r102);
    }

    public SecureApacheSSLSocketFactory(KeyStore r100, InputStream r101, String r102, SecureRandom r103) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(r100);
        this.f278089b = null;
        this.f278088a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r104 = new HiCloudX509TrustManager(r101, r102);
        setX509TrustManager(r104);
        this.f278088a.init(null, new X509TrustManager[]{r104}, r103);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        e.c(f278086i, "createSocket: socket host port autoClose");
        Socket r104 = this.f278088a.getSocketFactory().createSocket(r100, r101, r102, r103);
        if ((r104 instanceof SSLSocket) == false) goto L5;
        a(r104);
        SSLSocket r105 = (SSLSocket) r104;
        this.f278089b = r105;
        this.f278091d = (String[]) r105.getEnabledCipherSuites().clone();
    L5:
        return r104;
    }
}
