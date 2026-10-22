package n4a;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class d5 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Proxy$Type] */
    public static Proxy a(Context r100) {
        String r101 = "pu";
        URI r102 = new URI("http://restsdk.amap.com");     // Catch: Throwable -> L21
        if (x4.r(r100) != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L25;
    L23:
        return null;
    L25:
        List<Proxy> r104 = ProxySelector.getDefault().select(r102);     // Catch: Throwable -> L18
        if (r104 == null) goto L23;
        if (r104.isEmpty() == true) goto L23;
        Proxy r105 = (Proxy) ListProtector.get(r104, 0);     // Catch: Throwable -> L18
        if (r105 == null) goto L23;
        Proxy.Type r106 = r105.type();     // Catch: Throwable -> L18
        r101 = Proxy.Type.DIRECT;     // Catch: Throwable -> L18
        if (r106 == r101) goto L23;
        return r105;
    L18:
        th = move-exception;
        r.f(th, "pu", "gpsc");     // Catch: Throwable -> L21
        goto L23
    L7:
        r103 = false;
    L21:
        th = move-exception;
        r.f(th, r101, "gp");
        goto L23
    }
}
