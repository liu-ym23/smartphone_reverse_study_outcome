package com.tencent.open.a;

import com.tencent.open.log.SLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes29.dex */
public class h extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f461698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TrustManager[] f461699b;

    private TrustManager[] b() {
        TrustManagerFactory r100 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: GeneralSecurityException -> L11
        r100.init(null);     // Catch: GeneralSecurityException -> L11
        TrustManager[] r101 = r100.getTrustManagers();     // Catch: GeneralSecurityException -> L11
        if (r101.length == 1) goto L6;
    L9:
        SLog.e("openSDK_LOG.Tls2SupportedSocketFactory", "Unexpected default trust managers: " + Arrays.toString(r101));     // Catch: GeneralSecurityException -> L11
        return null;
    L6:
        if ((r101[0] instanceof X509TrustManager) == false) goto L9;
        return r101;
    L11:
        SLog.e("openSDK_LOG.Tls2SupportedSocketFactory", "The system has no TLS. Just give up.");
        return null;
    }

    public TrustManager a() {
        TrustManager[] r100 = this.f461699b;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length > 0) goto L7;
        return null;
    L7:
        return r100[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f461698a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f461698a.getSupportedCipherSuites();
    }

    public h() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        SSLContext r100 = SSLContext.getInstance("TLS");
        TrustManager[] r101 = b();
        this.f461699b = r101;
        r100.init(null, r101, null);
        this.f461698a = r100.getSocketFactory();
    }

    private Socket a(Socket r100) {
        if ((r100 instanceof SSLSocket) == false) goto L5;
        SSLSocket r101 = (SSLSocket) r100;
        r101.setEnabledProtocols(r101.getSupportedProtocols());
    L5:
        return r100;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101) throws IOException, UnknownHostException {
        return a(this.f461698a.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101) throws IOException {
        return a(this.f461698a.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101, InetAddress r102, int r103) throws IOException, UnknownHostException {
        return a(this.f461698a.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) throws IOException {
        return a(this.f461698a.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        return a(this.f461698a.createSocket(r100, r101, r102, r103));
    }
}
