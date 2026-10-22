package okhttp3.internal.connection;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.i;
import okhttp3.ttnet.TTConfigManager;
import okhttp3.ttnet.TTNetDns;
import okhttp3.ttnet.TTNetDnsResult;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.a f523897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f523898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Call f523899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f523900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f523901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f523902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<Proxy> f523903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f523904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<InetSocketAddress> f523905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Route> f523906j;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Route> f523907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f523908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f523909c;

        public final boolean a() {
            if (this.f523909c == false) goto L8;
            if (this.f523908b != this.f523907a.size()) goto L8;
            this.f523908b = 0;
            this.f523909c = false;
        L8:
            if (this.f523908b >= this.f523907a.size()) goto L11;
            return true;
        L11:
            return false;
        }

        public a(List<Route> r100) {
            this.f523908b = 0;
            this.f523909c = false;
            this.f523907a = r100;
            ArrayList r101 = (ArrayList) r100;
            if (r101.size() >= TTConfigManager.inst().getTriplicateIpNumbers()) goto L6;
            ArrayList r102 = new ArrayList(r100);
            r101.addAll(r102);
            r101.addAll(r102);
            this.f523909c = true;
        L6:
            if (r101.size() <= 1) goto L9;
            this.f523909c = true;
            return;
        }
    }

    public final boolean b() {
        if (this.f523904h >= this.f523903g.size()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return true;
    L8:
        if (((ArrayList) this.f523906j).isEmpty() == false) goto L13;
        return false;
    L13:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public final a c() throws IOException {
        if (b() == false) goto L80;
        ArrayList r100 = new ArrayList();
    L5:
        int r101 = 0;
        if (this.f523904h >= this.f523903g.size()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L75;
        if (this.f523904h >= this.f523903g.size()) goto L13;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L73;
        List<Proxy> r104 = this.f523903g;
        int r105 = this.f523904h;
        this.f523904h = r105 + 1;
        Proxy r106 = (Proxy) ListProtector.get(r104, r105);
        this.f523905i = new ArrayList();
        if (r106.type() != Proxy.Type.DIRECT) goto L19;
    L30:
        String r107 = this.f523897a.f523801a.host();
        int r108 = this.f523897a.f523801a.port();
    L31:
        if (r108 < 1) goto L71;
        if (r108 > 65535) goto L71;
        if (r106.type() != Proxy.Type.SOCKS) goto L37;
        this.f523905i.add(InetSocketAddress.createUnresolved(r107, r108));
    L52:
        int r109 = this.f523905i.size();
    L53:
        if (r101 >= r109) goto L66;
        Route r110 = new Route(this.f523897a, r106, (InetSocketAddress) ListProtector.get(this.f523905i, r101), this.f523902f);
        e r111 = this.f523898b;
        monitor-enter(r111);
        boolean r112 = r111.f523896a.contains(r110);     // Catch: Throwable -> L62
        monitor-exit(r111);
        if (r112 == false) goto L60;
        ((ArrayList) this.f523906j).add(r110);
    L61:
        r101 = r101 + 1;
        goto L53
    L60:
        r100.add(r110);
    L62:
        th = move-exception;
        throw th;
    L66:
        if (r100.isEmpty() == true) goto L5;
    L37:
        this.f523900d.dnsStart(this.f523899c, r107);
        List<InetAddress> r113 = new ArrayList();
        okhttp3.a r114 = this.f523897a;
        TTNetDns r115 = r114.f523812l;
        String r116 = null;
        if (r115 == null) goto L47;
        TTNetDnsResult r117 = r115.lookup(r107, this.f523901e);
        if (r117 == null) goto L42;
        r113 = r117.getInetAddressList();
        r116 = r117.getDnsInfoJson();
    L42:
        this.f523900d.dnsEnd(this.f523899c, r107, r113, r116);
        this.f523902f = r116;
        if (r113.isEmpty() == true) goto L46;
    L49:
        this.f523900d.dnsEnd(this.f523899c, r107, r113);
        int r118 = r113.size();
        int r119 = 0;
    L50:
        if (r119 >= r118) goto L52;
        this.f523905i.add(new InetSocketAddress((InetAddress) ListProtector.get(r113, r119), r108));
        r119 = r119 + 1;
        goto L50
    L46:
        throw new UnknownHostException(this.f523897a.f523812l + " returned no addresses for " + r107);
    L47:
        r113 = r114.f523802b.lookup(r107);
        this.f523900d.dnsEnd(this.f523899c, r107, r113, null);
        if (r113.isEmpty() == false) goto L49;
        throw new UnknownHostException(this.f523897a.f523802b + " returned no addresses for " + r107);
    L71:
        throw new SocketException("No route to " + r107 + ":" + r108 + "; port is out of range");
    L19:
        if (r106.type() == Proxy.Type.SOCKS) goto L30;
        SocketAddress r120 = r106.address();
        if ((r120 instanceof InetSocketAddress) == false) goto L29;
        InetSocketAddress r121 = (InetSocketAddress) r120;
        InetAddress r122 = r121.getAddress();
        if (r122 != null) goto L26;
        r107 = r121.getHostName();
    L27:
        r108 = r121.getPort();
        goto L31
    L26:
        r107 = r122.getHostAddress();
        goto L27
    L29:
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + r120.getClass());
    L73:
        throw new SocketException("No route to " + this.f523897a.f523801a.host() + "; exhausted proxy configurations: " + this.f523903g);
    L13:
        r103 = false;
    L75:
        if (r100.isEmpty() == false) goto L78;
        r100.addAll(this.f523906j);
        ((ArrayList) this.f523906j).clear();
    L78:
        return new a(r100);
    L8:
        r102 = false;
        goto L9
    L80:
        throw new NoSuchElementException();
    }

    public final void a(Route r100, IOException r101) {
        if (r100.proxy().type() == Proxy.Type.DIRECT) goto L7;
        okhttp3.a r102 = this.f523897a;
        ProxySelector r103 = r102.f523807g;
        if (r103 == null) goto L7;
        r103.connectFailed(r102.f523801a.uri(), r100.proxy().address(), r101);
    L7:
        e r104 = this.f523898b;
        monitor-enter(r104);
        r104.f523896a.add(r100);     // Catch: Throwable -> L12
        monitor-exit(r104);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void d(HttpUrl r100, Proxy r101) {
        if (r101 == null) goto L5;
        this.f523903g = Collections.singletonList(r101);
    L12:
        this.f523904h = 0;
        return;
    L5:
        List<Proxy> r102 = this.f523897a.f523807g.select(r100.uri());
        if (r102 != null) goto L8;
    L10:
        List<Proxy> r103 = cvc.c.o(new Proxy[]{Proxy.NO_PROXY});
    L11:
        this.f523903g = r103;
        goto L12
    L8:
        if (r102.isEmpty() == true) goto L10;
        r103 = cvc.c.n(r102);
        goto L11
    }

    public f(okhttp3.a r100, e r101, Call r102, i r103) {
        this.f523901e = 0;
        this.f523902f = null;
        this.f523903g = Collections.emptyList();
        this.f523905i = Collections.emptyList();
        this.f523906j = new ArrayList();
        this.f523897a = r100;
        this.f523898b = r101;
        this.f523899c = r102;
        this.f523900d = r103;
        d(r100.f523801a, r100.f523808h);
    }
}
