package o1;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends SSLSocketFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f521687b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f521688c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f521689a;

    static {
        f521687b = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"};
        f521688c = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
    }

    public b(SSLSocketFactory r100) {
        this.f521689a = r100;
    }

    public static void a(Socket r100) {
        if ((r100 instanceof SSLSocket) == false) goto L9;
        SSLSocket r101 = (SSLSocket) r100;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        r101.setEnabledProtocols(f521687b);
        return;
    L7:
        r101.setEnabledProtocols(f521688c);
        return;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r100, int r101) {
        Socket r102 = this.f521689a.createSocket(r100, r101);
        a(r102);
        return r102;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String r100, int r101, InetAddress r102, int r103) {
        Socket r104 = this.f521689a.createSocket(r100, r101, r102, r103);
        a(r104);
        return r104;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r100, int r101) {
        Socket r102 = this.f521689a.createSocket(r100, r101);
        a(r102);
        return r102;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress r100, int r101, InetAddress r102, int r103) {
        Socket r104 = this.f521689a.createSocket(r100, r101, r102, r103);
        a(r104);
        return r104;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket r100, String r101, int r102, boolean r103) {
        Socket r104 = this.f521689a.createSocket(r100, r101, r102, r103);
        a(r104);
        return r104;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f521689a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f521689a.getSupportedCipherSuites();
    }
}
