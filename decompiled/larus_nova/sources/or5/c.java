package or5;

import com.bytedance.lark.sdk.api.LarkProxyApi;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Interceptor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f524941d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProxySelector f524942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Proxy f524943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarkProxyApi f524944c;

    static {
        f524941d = new AtomicBoolean(false);
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r100) throws IOException {
        if (this.f524943b != null) goto L8;
        List<Proxy> r101 = this.f524942a.select(URI.create("http://localhost"));
        if (r101.size() <= 0) goto L8;
        this.f524943b = (Proxy) ListProtector.get(r101, 0);
    L8:
        if (this.f524943b == Proxy.NO_PROXY) goto L10;
    L12:
        Proxy r102 = this.f524943b;
        if (r102 == null) goto L23;
        SocketAddress r103 = r102.address();
        if ((r103 instanceof InetSocketAddress) == false) goto L20;
        InetSocketAddress r104 = (InetSocketAddress) r103;
        if (f524941d.getAndSet(true) == true) goto L23;
        String r105 = r104.getHostName();
        String r106 = String.valueOf(r104.getPort());
        tt5.a.h("eenet_HttpProxyInterceptor", "set proxy host: " + r105 + "->port: " + r106);
        this.f524944c.a(r105, r106, LarkProxyApi.ProxyType.HTTP);
        goto L23
    L20:
        if (f524941d.getAndSet(false) == false) goto L23;
        this.f524944c.b();
        tt5.a.h("eenet_HttpProxyInterceptor", "clear proxy address not instance of InetSocketAddress");
    L23:
        return r100.proceed(r100.request());
    L10:
        if (f524941d.getAndSet(false) == false) goto L12;
        tt5.a.h("eenet_HttpProxyInterceptor", "clear proxy");
        this.f524944c.b();
        goto L23
    }

    public c(Proxy r100, ProxySelector r101, LarkProxyApi r102) {
        this.f524943b = r100;
        this.f524942a = r101;
        this.f524944c = r102;
    }
}
