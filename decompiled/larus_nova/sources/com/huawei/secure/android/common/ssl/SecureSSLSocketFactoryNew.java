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

/* JADX INFO: loaded from: classes23.dex */
public class SecureSSLSocketFactoryNew extends SSLSocketFactory {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f278106i = "SSLFNew";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile SecureSSLSocketFactoryNew f278107j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SSLContext f278108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected SSLSocket f278109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f278110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String[] f278111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected X509TrustManager f278112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String[] f278113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String[] f278114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String[] f278115h;

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public X509Certificate[] getChain() {
        X509TrustManager r100 = this.f278112e;
        if ((r100 instanceof SecureX509TrustManager) == false) goto L7;
        return ((SecureX509TrustManager) r100).getChain();
    L7:
        return new X509Certificate[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] r100 = this.f278111d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new String[0];
    }

    public String[] getBlackCiphers() {
        return this.f278113f;
    }

    public Context getContext() {
        return this.f278110c;
    }

    public String[] getProtocols() {
        return this.f278115h;
    }

    public SSLContext getSslContext() {
        return this.f278108a;
    }

    public SSLSocket getSslSocket() {
        return this.f278109b;
    }

    public String[] getWhiteCiphers() {
        return this.f278114g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f278112e;
    }

    public SecureSSLSocketFactoryNew(X509TrustManager r100) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f278108a = null;
        this.f278109b = null;
        this.f278108a = SSLUtil.setSSLContext();
        setX509TrustManager(r100);
        this.f278108a.init(null, new X509TrustManager[]{r100}, null);
    }

    private void a(Socket r100) {
        boolean r101 = false;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278115h) == true) goto L5;
        e.c(f278106i, "set protocols");
        boolean r102 = SSLUtil.setEnabledProtocols((SSLSocket) r100, this.f278115h);
    L7:
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278114g) == true) goto L9;
    L10:
        e.c(f278106i, "set cipher");
        SSLSocket r103 = (SSLSocket) r100;
        SSLUtil.setEnabledProtocols(r103);
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278114g) == true) goto L13;
        r101 = SSLUtil.setWhiteListCipherSuites(r103, this.f278114g);
    L14:
        if (r102 == true) goto L16;
        e.c(f278106i, "set default protocols");
        SSLUtil.setEnabledProtocols((SSLSocket) r100);
    L16:
        if (r101 == true) goto L19;
        e.c(f278106i, "set default cipher");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) r100);
        return;
    L19:
        return;
    L13:
        r101 = SSLUtil.setBlackListCipherSuites(r103, this.f278113f);
        goto L14
    L9:
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f278113f) == true) goto L14;
    L5:
        r102 = false;
        goto L7
    }

    public static SecureSSLSocketFactoryNew getInstance(Context r100) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long r101 = System.currentTimeMillis();
        ContextUtil.setContext(r100);
        if (f278107j != null) goto L15;
        monitor-enter(SecureSSLSocketFactoryNew.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f278107j != null) goto L9;
        f278107j = new SecureSSLSocketFactoryNew(r100, null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureSSLSocketFactoryNew.class);     // Catch: Throwable -> L11
    L15:
        if (f278107j.f278110c != null) goto L18;
        if (r100 == null) goto L18;
        f278107j.setContext(r100);
    L18:
        e.a(f278106i, "getInstance: cost : " + (System.currentTimeMillis() - r101) + " ms");
        return f278107j;
    }

    public void setBlackCiphers(String[] r100) {
        this.f278113f = r100;
    }

    public void setContext(Context r100) {
        this.f278110c = r100.getApplicationContext();
    }

    public void setProtocols(String[] r100) {
        this.f278115h = r100;
    }

    public void setSslContext(SSLContext r100) {
        this.f278108a = r100;
    }

    public void setWhiteCiphers(String[] r100) {
        this.f278114g = r100;
    }

    public void setX509TrustManager(X509TrustManager r100) {
        this.f278112e = r100;
    }

    private SecureSSLSocketFactoryNew(Context r100, SecureRandom r101) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException, NullPointerException {
        this.f278108a = null;
        this.f278109b = null;
        setContext(r100);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager r102 = SecureX509SingleInstance.getInstance(r100);
        this.f278112e = r102;
        this.f278108a.init(null, new X509TrustManager[]{r102}, r101);
    }

    public static SecureSSLSocketFactoryNew getInstance(Context r100, SecureRandom r101) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long r102 = System.currentTimeMillis();
        ContextUtil.setContext(r100);
        if (f278107j != null) goto L15;
        monitor-enter(SecureSSLSocketFactoryNew.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f278107j != null) goto L9;
        f278107j = new SecureSSLSocketFactoryNew(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureSSLSocketFactoryNew.class);     // Catch: Throwable -> L11
    L15:
        if (f278107j.f278110c != null) goto L18;
        if (r100 == null) goto L18;
        f278107j.setContext(r100);
    L18:
        e.a(f278106i, "getInstance: cost : " + (System.currentTimeMillis() - r102) + " ms");
        return f278107j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101) throws IOException {
        e.c(f278106i, "createSocket: host , port");
        Socket r102 = this.f278108a.getSocketFactory().createSocket(r100, r101);
        if ((r102 instanceof SSLSocket) == false) goto L5;
        a(r102);
        SSLSocket r103 = (SSLSocket) r102;
        this.f278109b = r103;
        this.f278111d = (String[]) r103.getEnabledCipherSuites().clone();
    L5:
        return r102;
    }

    public SecureSSLSocketFactoryNew(InputStream r100, String r101) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f278108a = null;
        this.f278109b = null;
        this.f278108a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r102 = new HiCloudX509TrustManager(r100, r101);
        setX509TrustManager(r102);
        this.f278108a.init(null, new X509TrustManager[]{r102}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101) throws IOException {
        return createSocket(r100.getHostAddress(), r101);
    }

    public SecureSSLSocketFactoryNew(X509TrustManager r100, SecureRandom r101) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f278108a = null;
        this.f278109b = null;
        this.f278108a = SSLUtil.setSSLContext();
        setX509TrustManager(r100);
        this.f278108a.init(null, new X509TrustManager[]{r100}, r101);
    }

    public SecureSSLSocketFactoryNew(InputStream r100, String r101, SecureRandom r102) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f278108a = null;
        this.f278109b = null;
        this.f278108a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r103 = new HiCloudX509TrustManager(r100, r101);
        setX509TrustManager(r103);
        this.f278108a.init(null, new X509TrustManager[]{r103}, r102);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        e.c(f278106i, "createSocket");
        Socket r104 = this.f278108a.getSocketFactory().createSocket(r100, r101, r102, r103);
        if ((r104 instanceof SSLSocket) == false) goto L5;
        a(r104);
        SSLSocket r105 = (SSLSocket) r104;
        this.f278109b = r105;
        this.f278111d = (String[]) r105.getEnabledCipherSuites().clone();
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
