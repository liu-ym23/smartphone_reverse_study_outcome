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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Interceptor {
    public static final AtomicBoolean d = null;
    public final ProxySelector a;
    public Proxy b;
    public final LarkProxyApi c;

    static {
        d = new AtomicBoolean(false);
    }

    public final Response intercept(Interceptor.Chain r6) throws IOException {
        if (this.b != null) goto L8;
        List<Proxy> r0 = this.a.select(URI.create("http://localhost"));
        if (r0.size() <= 0) goto L8;
        this.b = (Proxy) ListProtector.get(r0, 0);
    L8:
        if (this.b == Proxy.NO_PROXY) goto L10;
    L12:
        Proxy r1 = this.b;
        if (r1 == null) goto L23;
        SocketAddress r2 = r1.address();
        if ((r2 instanceof InetSocketAddress) == false) goto L20;
        InetSocketAddress r3 = (InetSocketAddress) r2;
        if (d.getAndSet(true) == true) goto L23;
        String r4 = r3.getHostName();
        String r5 = String.valueOf(r3.getPort());
        tt5.a.h("eenet_HttpProxyInterceptor", "set proxy host: " + r4 + "->port: " + r5);
        this.c.a(r4, r5, LarkProxyApi.ProxyType.HTTP);
        goto L23
    L20:
        if (d.getAndSet(false) == false) goto L23;
        this.c.b();
        tt5.a.h("eenet_HttpProxyInterceptor", "clear proxy address not instance of InetSocketAddress");
    L23:
        return r6.proceed(r6.request());
    L10:
        if (d.getAndSet(false) == false) goto L12;
        tt5.a.h("eenet_HttpProxyInterceptor", "clear proxy");
        this.c.b();
        goto L23
    }

    public c(Proxy r1, ProxySelector r2, LarkProxyApi r3) {
        this.b = r1;
        this.a = r2;
        this.c = r3;
    }
}
