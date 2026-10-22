package com.unicom.online.account.kernel;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes41.dex */
public final class ab extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f461947b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SSLSocketFactory f461948a;

    static {
        f461947b = new String[]{"TLSv1.1", "TLSv1.2"};
    }

    public ab(SSLSocketFactory r100) {
        this.f461948a = r100;
    }

    private static Socket a(Socket r100) {
        if ((r100 instanceof SSLSocket) == false) goto L5;
        ((SSLSocket) r100).setEnabledProtocols(f461947b);
    L5:
        return r100;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r100, int r101) {
        return a(this.f461948a.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r100, int r101, InetAddress r102, int r103) {
        return a(this.f461948a.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r100, int r101) {
        return a(this.f461948a.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) {
        return a(this.f461948a.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket r100, String r101, int r102, boolean r103) {
        return a(this.f461948a.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f461948a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f461948a.getSupportedCipherSuites();
    }
}
