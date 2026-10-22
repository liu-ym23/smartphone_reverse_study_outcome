package com.huawei.secure.android.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
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

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile SecureApacheSSLSocketFactory f277917c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f277918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f277919b;

    static {
        BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
        STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
        f277917c = null;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        Socket r100 = this.f277918a.getSocketFactory().createSocket();
        a(r100);
        return r100;
    }

    private SecureApacheSSLSocketFactory(KeyStore r100) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(r100);
    }

    private void a(Socket r100) {
        SSLSocket r101 = (SSLSocket) r100;
        SSLUtil.setEnabledProtocols(r101);
        SSLUtil.setEnableSafeCipherSuites(r101);
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore r100, Context r101) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        if (f277917c != null) goto L15;
        monitor-enter(SecureApacheSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f277917c != null) goto L9;
        f277917c = new SecureApacheSSLSocketFactory(r100, r101, null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureApacheSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        return f277917c;
    }

    private SecureApacheSSLSocketFactory(KeyStore r100, Context r101, SecureRandom r102) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        super(r100);
        this.f277919b = r101;
        this.f277918a = SSLUtil.setSSLContext();
        SecureX509TrustManager r103 = new SecureX509TrustManager(this.f277919b);
        this.f277918a.init(null, new X509TrustManager[]{r103}, r102);
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore r100, Context r101, SecureRandom r102) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        if (f277917c != null) goto L15;
        monitor-enter(SecureApacheSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f277917c != null) goto L9;
        f277917c = new SecureApacheSSLSocketFactory(r100, r101, r102);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureApacheSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        return f277917c;
    }

    public SecureApacheSSLSocketFactory(KeyStore r100, InputStream r101, String r102) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        super(r100);
        this.f277918a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r103 = new HiCloudX509TrustManager(r101, r102);
        this.f277918a.init(null, new X509TrustManager[]{r103}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore r100, InputStream r101, String r102, SecureRandom r103) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        super(r100);
        this.f277918a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r104 = new HiCloudX509TrustManager(r101, r102);
        this.f277918a.init(null, new X509TrustManager[]{r104}, r103);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        Socket r104 = this.f277918a.getSocketFactory().createSocket(r100, r101, r102, r103);
        a(r104);
        return r104;
    }
}
