package com.huawei.secure.android.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
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

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile SecureSSLSocketFactory f277920c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLContext f277921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f277922b;

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    static {
        BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
        STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
        f277920c = null;
    }

    private void a(Socket r100) {
        SSLSocket r101 = (SSLSocket) r100;
        SSLUtil.setEnabledProtocols(r101);
        SSLUtil.setEnableSafeCipherSuites(r101);
    }

    public static SecureSSLSocketFactory getInstance(Context r100) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException {
        if (f277920c != null) goto L15;
        monitor-enter(SecureSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f277920c != null) goto L9;
        f277920c = new SecureSSLSocketFactory(r100, null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        return f277920c;
    }

    private SecureSSLSocketFactory(Context r100, SecureRandom r101) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalAccessException {
        this.f277921a = null;
        this.f277922b = r100;
        this.f277921a = SSLUtil.setSSLContext();
        SecureX509TrustManager r102 = new SecureX509TrustManager(this.f277922b);
        this.f277921a.init(null, new X509TrustManager[]{r102}, r101);
    }

    public static SecureSSLSocketFactory getInstance(Context r100, SecureRandom r101) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException {
        if (f277920c != null) goto L15;
        monitor-enter(SecureSSLSocketFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f277920c != null) goto L9;
        f277920c = new SecureSSLSocketFactory(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureSSLSocketFactory.class);     // Catch: Throwable -> L11
    L15:
        return f277920c;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101) throws IOException, UnknownHostException {
        Socket r102 = this.f277921a.getSocketFactory().createSocket(r100, r101);
        if ((r102 instanceof SSLSocket) == false) goto L5;
        a(r102);
    L5:
        return r102;
    }

    public SecureSSLSocketFactory(InputStream r100, String r101) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException {
        this.f277921a = null;
        this.f277921a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r102 = new HiCloudX509TrustManager(r100, r101);
        this.f277921a.init(null, new X509TrustManager[]{r102}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101) throws IOException {
        return createSocket(r100.getHostAddress(), r101);
    }

    public SecureSSLSocketFactory(InputStream r100, String r101, SecureRandom r102) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException {
        this.f277921a = null;
        this.f277921a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager r103 = new HiCloudX509TrustManager(r100, r101);
        this.f277921a.init(null, new X509TrustManager[]{r103}, r102);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        Socket r104 = this.f277921a.getSocketFactory().createSocket(r100, r101, r102, r103);
        if ((r104 instanceof SSLSocket) == false) goto L5;
        a(r104);
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
