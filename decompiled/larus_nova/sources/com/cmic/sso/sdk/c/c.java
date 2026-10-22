package com.cmic.sso.sdk.c;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes22.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f273430a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.cmic.sso.sdk.a f273431b;

    public String toString() {
        return "Tls12SocketFactory";
    }

    static {
        f273430a = new String[]{"TLSv1.2"};
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return a(this.delegate.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    private Socket a(Socket r100) {
        boolean r101 = r100 instanceof SSLSocket;
        this.f273431b.a("socketip", r100.getLocalAddress().getHostAddress());
        return r100;
    }

    public c(SSLSocketFactory r100, com.cmic.sso.sdk.a r101) {
        this.delegate = r100;
        this.f273431b = r101;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101) throws IOException {
        return a(this.delegate.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101) throws IOException {
        return a(this.delegate.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101, InetAddress r102, int r103) throws IOException {
        return a(this.delegate.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) throws IOException {
        return a(this.delegate.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        return a(this.delegate.createSocket(r100, r101, r102, r103));
    }
}
