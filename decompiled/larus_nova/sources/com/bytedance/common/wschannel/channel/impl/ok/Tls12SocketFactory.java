package com.bytedance.common.wschannel.channel.impl.ok;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes15.dex */
public class Tls12SocketFactory extends SSLSocketFactory {
    private static final String[] TLS_V12_ONLY = null;
    final SSLSocketFactory mDelegate;

    static {
        TLS_V12_ONLY = new String[]{"TLSv1.2"};
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.mDelegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.mDelegate.getSupportedCipherSuites();
    }

    public Tls12SocketFactory(SSLSocketFactory r100) {
        this.mDelegate = r100;
    }

    private Socket patch(Socket r100) {
        if ((r100 instanceof SSLSocket) == false) goto L5;
        ((SSLSocket) r100).setEnabledProtocols(TLS_V12_ONLY);
    L5:
        return r100;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101) throws IOException {
        return patch(this.mDelegate.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101) throws IOException {
        return patch(this.mDelegate.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101, InetAddress r102, int r103) throws IOException {
        return patch(this.mDelegate.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) throws IOException {
        return patch(this.mDelegate.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        return patch(this.mDelegate.createSocket(r100, r101, r102, r103));
    }
}
