package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: loaded from: classes23.dex */
public class SecureSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = null;
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f278096i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile SecureSSLSocketFactory f278097j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f278098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLSocket f278099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f278100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f278101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private X509TrustManager f278102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f278103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f278104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f278105h;

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    static {
        BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
        STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
        f278096i = "SecureSSLSocketFactory";
        f278097j = null;
    }

    public X509Certificate[] getChain() {
        X509TrustManager r100 = this.f278102e;
        if ((r100 instanceof SecureX509TrustManager) == false) goto L7;
        return ((SecureX509TrustManager) r100).getChain();
    L7:
        return new X509Certificate[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] r100 = this.f278101d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new String[0];
    }

    public String[] getBlackCiphers() {
        return this.f278103f;
    }

    public Context getContext() {
        return this.f278100c;
    }

    public String[] getProtocols() {
        return this.f278105h;
    }

    public SSLContext getSslContext() {
        return this.f278098a;
    }

    public SSLSocket getSslSocket() {
        return this.f278099b;
    }

    public String[] getWhiteCiphers() {
        return this.f278104g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f278102e;
    }

    public SecureSSLSocketFactory(X509TrustManager r100) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f278098a = null;
        this.f278099b = null;
        this.f278098a = SSLUtil.setSSLContext();
        setX509TrustManager(r100);
        this.f278098a.init(null, new X509TrustManager[]{r100}, null);
    }

    private void a(Socket r100) {
        boolean r101 = false;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278105h) == true) goto L5;
        e.c(f278096i, "set protocols");
        SSLUtil.setEnabledProtocols((SSLSocket) r100, this.f278105h);
        boolean r102 = true;
    L7:
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278104g) == true) goto L9;
    L10:
        e.c(f278096i, "set white cipher or black cipher");
        SSLSocket r103 = (SSLSocket) r100;
        SSLUtil.setEnabledProtocols(r103);
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278104g) == true) goto L13;
        r101 = SSLUtil.setWhiteListCipherSuites(r103, this.f278104g);
    L14:
        if (r102 == true) goto L16;
        e.c(f278096i, "set default protocols");
        SSLUtil.setEnabledProtocols((SSLSocket) r100);
    L16:
        if (r101 == true) goto L19;
        e.c(f278096i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) r100);
        return;
    L19:
        return;
    L13:
        r101 = SSLUtil.setBlackListCipherSuites(r103, this.f278103f);
        goto L14
    L9:
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278103f) == true) goto L14;
    L5:
        r102 = false;
        goto L7
    }

    public static SecureSSLSocketFactory getInstance(Context r100) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long r101 = System.currentTimeMillis();
        ContextUtil.setContext(r100);
        if (f278097j != null) goto L15;
        monitor-enter(SecureSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f278097j != null) goto L9;
        f278097j = new SecureSSLSocketFactory(r100, null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        if (f278097j.f278100c != null) goto L18;
        if (r100 == null) goto L18;
        f278097j.setContext(r100);
    L18:
        e.a(f278096i, "getInstance: cost : " + (System.currentTimeMillis() - r101) + " ms");
        return f278097j;
    }

    public void setBlackCiphers(String[] r100) {
        this.f278103f = r100;
    }

    public void setContext(Context r100) {
        this.f278100c = r100.getApplicationContext();
    }

    public void setProtocols(String[] r100) {
        this.f278105h = r100;
    }

    public void setSslContext(SSLContext r100) {
        this.f278098a = r100;
    }

    public void setWhiteCiphers(String[] r100) {
        this.f278104g = r100;
    }

    public void setX509TrustManager(X509TrustManager r100) {
        this.f278102e = r100;
    }

    public static void a(X509TrustManager r100) {
        e.c(f278096i, "ssf update socket factory trust manager");
        long r101 = System.currentTimeMillis();
        f278097j = new SecureSSLSocketFactory(r100);     // Catch: KeyManagementException -> L5 NoSuchAlgorithmException -> L6
    L7:
        e.a(f278096i, "update: cost : " + (System.currentTimeMillis() - r101) + " ms");
        return;
    L5:
        e.b(f278096i, "KeyManagementException");
    L6:
        e.b(f278096i, "NoSuchAlgorithmException");
        goto L7
    }

    private SecureSSLSocketFactory(Context r100, SecureRandom r101) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException, NullPointerException {
        this.f278098a = null;
        this.f278099b = null;
        setContext(r100);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager r102 = SecureX509SingleInstance.getInstance(r100);
        this.f278102e = r102;
        this.f278098a.init(null, new X509TrustManager[]{r102}, r101);
    }

    public static void a(X509TrustManager r100, SecureRandom r101) {
        e.c(f278096i, "ssf update socket factory trust manager");
        long r102 = System.currentTimeMillis();
        f278097j = new SecureSSLSocketFactory(r100, r101);     // Catch: KeyManagementException -> L5 NoSuchAlgorithmException -> L6
    L7:
        e.a(f278096i, "update: cost : " + (System.currentTimeMillis() - r102) + " ms");
        return;
    L5:
        e.b(f278096i, "KeyManagementException");
    L6:
        e.b(f278096i, "NoSuchAlgorithmException");
        goto L7
    }

    public static SecureSSLSocketFactory getInstance(Context r100, SecureRandom r101) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long r102 = System.currentTimeMillis();
        ContextUtil.setContext(r100);
        if (f278097j != null) goto L15;
        monitor-enter(SecureSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f278097j != null) goto L9;
        f278097j = new SecureSSLSocketFactory(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        if (f278097j.f278100c != null) goto L18;
        if (r100 == null) goto L18;
        f278097j.setContext(r100);
    L18:
        e.a(f278096i, "getInstance: cost : " + (System.currentTimeMillis() - r102) + " ms");
        return f278097j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101) throws IOException {
        e.c(f278096i, "createSocket: host , port");
        Socket r102 = this.f278098a.getSocketFactory().createSocket(r100, r101);
        if ((r102 instanceof SSLSocket) == false) goto L5;
        a(r102);
        SSLSocket r103 = (SSLSocket) r102;
        this.f278099b = r103;
        this.f278101d = (String[]) r103.getEnabledCipherSuites().clone();
    L5:
        return r102;
    }

    public SecureSSLSocketFactory(InputStream r100, String r101) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f278098a = null;
        this.f278099b = null;
        this.f278098a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r102 = new HiCloudX509TrustManager(r100, r101);
        setX509TrustManager(r102);
        this.f278098a.init(null, new X509TrustManager[]{r102}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101) throws IOException {
        return createSocket(r100.getHostAddress(), r101);
    }

    public SecureSSLSocketFactory(X509TrustManager r100, SecureRandom r101) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f278098a = null;
        this.f278099b = null;
        this.f278098a = SSLUtil.setSSLContext();
        setX509TrustManager(r100);
        this.f278098a.init(null, new X509TrustManager[]{r100}, r101);
    }

    public SecureSSLSocketFactory(InputStream r100, String r101, SecureRandom r102) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f278098a = null;
        this.f278099b = null;
        this.f278098a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r103 = new HiCloudX509TrustManager(r100, r101);
        setX509TrustManager(r103);
        this.f278098a.init(null, new X509TrustManager[]{r103}, r102);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        e.c(f278096i, "createSocket s host port autoClose");
        Socket r104 = this.f278098a.getSocketFactory().createSocket(r100, r101, r102, r103);
        if ((r104 instanceof SSLSocket) == false) goto L5;
        a(r104);
        SSLSocket r105 = (SSLSocket) r104;
        this.f278099b = r105;
        this.f278101d = (String[]) r105.getEnabledCipherSuites().clone();
    L5:
        return r104;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) throws IOException {
        return createSocket(r100.getHostAddress(), r101);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101, InetAddress r102, int r103) throws IOException, UnknownHostException {
        return createSocket(r100, r101);
    }
}
