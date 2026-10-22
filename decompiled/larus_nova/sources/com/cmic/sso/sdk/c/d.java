package com.cmic.sso.sdk.c;

import android.net.Network;
import android.net.SSLCertificateSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes22.dex */
public class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f273450b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HostnameVerifier f273451a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f273452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HttpsURLConnection f273453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Network f273454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.cmic.sso.sdk.a f273455f;

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101) throws IOException, UnknownHostException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101, InetAddress r102, int r103) throws IOException, UnknownHostException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    static {
        f273450b = new String[]{"TLSv1.2"};
    }

    public d(HttpsURLConnection r100, Network r101, com.cmic.sso.sdk.a r102) {
        this.f273452c = "d";
        this.f273451a = HttpsURLConnection.getDefaultHostnameVerifier();
        this.f273453d = r100;
        this.f273454e = r101;
        this.f273455f = r102;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        String r104 = this.f273453d.getRequestProperty("Host");
        if (r104 == null) goto L6;
        r101 = r104;
    L6:
        com.cmic.sso.sdk.e.c.b(this.f273452c, "customized createSocket. host: " + r101);
        com.cmic.sso.sdk.e.c.b(this.f273452c, "plainSocket localAddress: " + r100.getLocalAddress().getHostAddress());
        if (r103 == false) goto L9;
        com.cmic.sso.sdk.e.c.b(this.f273452c, "plainSocket close");
        r100.close();
    L9:
        SSLCertificateSocketFactory r105 = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket r106 = (SSLSocket) r105.createSocket();
        Network r107 = this.f273454e;
        if (r107 == null) goto L12;
        r107.bindSocket(r106);
    L12:
        r106.connect(r100.getRemoteSocketAddress());
        this.f273455f.a("socketip", r106.getLocalAddress().getHostAddress());
        r106.setEnabledProtocols(r106.getSupportedProtocols());
        com.cmic.sso.sdk.e.c.b(this.f273452c, "Setting SNI hostname");
        r105.setHostname(r106, r101);
        SSLSession r108 = r106.getSession();
        if (this.f273451a.verify(r101, r108) == false) goto L17;
        com.cmic.sso.sdk.e.c.b(this.f273452c, "Established " + r108.getProtocol() + " connection with " + r108.getPeerHost() + " using " + r108.getCipherSuite());
        return r106;
    L17:
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + r101);
    }
}
