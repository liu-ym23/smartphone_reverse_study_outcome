package okhttp3;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.ttnet.TTNetDns;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpUrl f523801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Dns f523802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SocketFactory f523803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f523804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Protocol> f523805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<f> f523806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f523807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final Proxy f523808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final SSLSocketFactory f523809i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final HostnameVerifier f523810j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final c f523811k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TTNetDns f523812l;

    public final int hashCode() {
        int r100 = (((((((((((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.f523801a.hashCode()) * 31) + this.f523802b.hashCode()) * 31) + this.f523804d.hashCode()) * 31) + this.f523805e.hashCode()) * 31) + this.f523806f.hashCode()) * 31) + this.f523807g.hashCode()) * 31;
        Proxy r101 = this.f523808h;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        SSLSocketFactory r105 = this.f523809i;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        HostnameVerifier r108 = this.f523810j;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        c r111 = this.f523811k;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("Address{");
        r100.append(this.f523801a.host());
        r100.append(":");
        r100.append(this.f523801a.port());
        if (this.f523808h == null) goto L5;
        r100.append(", proxy=");
        r100.append(this.f523808h);
    L6:
        r100.append(com.alipay.sdk.m.u.i.f25855d);
        return r100.toString();
    L5:
        r100.append(", proxySelector=");
        r100.append(this.f523807g);
        goto L6
    }

    public final boolean a(a r100) {
        if (this.f523802b.equals(r100.f523802b) == true) goto L5;
    L23:
        return false;
    L5:
        if (this.f523804d.equals(r100.f523804d) == false) goto L23;
        if (this.f523805e.equals(r100.f523805e) == false) goto L23;
        if (this.f523806f.equals(r100.f523806f) == false) goto L23;
        if (this.f523807g.equals(r100.f523807g) == false) goto L23;
        if (cvc.c.k(this.f523808h, r100.f523808h) == false) goto L23;
        if (cvc.c.k(this.f523809i, r100.f523809i) == false) goto L23;
        if (cvc.c.k(this.f523810j, r100.f523810j) == false) goto L23;
        if (cvc.c.k(this.f523811k, r100.f523811k) == false) goto L23;
        if (this.f523801a.port() != r100.f523801a.port()) goto L23;
        return true;
    }

    public final boolean equals(@Nullable Object r100) {
        if ((r100 instanceof a) == false) goto L9;
        a r101 = (a) r100;
        if (this.f523801a.equals(r101.f523801a) == false) goto L9;
        if (a(r101) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public a(String r100, int r101, Dns r102, SocketFactory r103, @Nullable SSLSocketFactory r104, @Nullable HostnameVerifier r105, @Nullable c r106, b r110, @Nullable Proxy r111, List<Protocol> r112, List<f> r113, ProxySelector r114) {
        HttpUrl.a r107 = new HttpUrl.a();
        if (r104 == null) goto L5;
        String r108 = "https";
    L6:
        r107.g(r108);
        r107.c(r100);
        if (r101 <= 0) goto L37;
        if (r101 > 65535) goto L37;
        r107.f523780e = r101;
        this.f523801a = r107.b();
        if (r102 == null) goto L35;
        this.f523802b = r102;
        if (r103 == null) goto L33;
        this.f523803c = r103;
        if (r110 == null) goto L31;
        this.f523804d = r110;
        if (r112 == null) goto L29;
        this.f523805e = cvc.c.n(r112);
        if (r113 == null) goto L27;
        this.f523806f = cvc.c.n(r113);
        if (r114 == null) goto L25;
        this.f523807g = r114;
        this.f523808h = r111;
        this.f523809i = r104;
        this.f523810j = r105;
        this.f523811k = r106;
        return;
    L25:
        throw new NullPointerException("proxySelector == null");
    L27:
        throw new NullPointerException("connectionSpecs == null");
    L29:
        throw new NullPointerException("protocols == null");
    L31:
        throw new NullPointerException("proxyAuthenticator == null");
    L33:
        throw new NullPointerException("socketFactory == null");
    L35:
        throw new NullPointerException("dns == null");
    L37:
        throw new IllegalArgumentException("unexpected port: " + r101);
    L5:
        r108 = "http";
        goto L6
    }

    public a(String r100, int r101, Dns r102, SocketFactory r103, @Nullable SSLSocketFactory r104, @Nullable HostnameVerifier r105, @Nullable c r106, b r107, @Nullable Proxy r108, List<Protocol> r110, List<f> r111, ProxySelector r112, TTNetDns r113) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112);
        this.f523812l = r113;
    }
}
