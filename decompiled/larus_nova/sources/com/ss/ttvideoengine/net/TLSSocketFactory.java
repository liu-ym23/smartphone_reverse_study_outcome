package com.ss.ttvideoengine.net;

import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes34.dex */
public class TLSSocketFactory extends SSLSocketFactory {
    private static final String[] TLS_ALL = null;
    private static final String[] TLS_POP_13 = null;
    final SSLSocketFactory base;

    static {
        TLS_ALL = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"};
        TLS_POP_13 = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.base.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.base.getSupportedCipherSuites();
    }

    public TLSSocketFactory(SSLSocketFactory r100) {
        this.base = r100;
    }

    private Socket patch(Socket r100) {
        if ((r100 instanceof SSLSocket) == true) goto L5;
    L8:
        return r100;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L7;
        ((SSLSocket) r100).setEnabledProtocols(TLS_ALL);
        goto L8
    L7:
        ((SSLSocket) r100).setEnabledProtocols(TLS_POP_13);
        goto L8
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101) throws IOException, UnknownHostException {
        return patch(this.base.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101) throws IOException {
        return patch(this.base.createSocket(r100, r101));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String r100, int r101, InetAddress r102, int r103) throws IOException, UnknownHostException {
        return patch(this.base.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) throws IOException {
        return patch(this.base.createSocket(r100, r101, r102, r103));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket r100, String r101, int r102, boolean r103) throws IOException {
        return patch(this.base.createSocket(r100, r101, r102, r103));
    }
}
