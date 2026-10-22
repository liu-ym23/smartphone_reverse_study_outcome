package lr5;

import com.bytedance.ee.eenet.util.HttpChannel;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final AtomicReference<c> a = null;
    public static final AtomicReference<i> b = null;
    public static final AtomicReference<h> c = null;
    public static HttpChannel d;
    public static jr5.a e;
    public static final AtomicBoolean f = null;

    static {
        a = new AtomicReference(null);
        b = new AtomicReference(null);
        c = new AtomicReference(null);
        d = HttpChannel.RustChannel;
        e = null;
        f = new AtomicBoolean(false);
    }

    public static void c() {
        if (f.get() == true) goto L15;
        tt5.a.h("eenet_EEHttpClient", "init eeHttpClient: " + d.toString());
        AtomicReference<c> r0 = a;
        c r1 = new c(a(d));
    L6:
        if (r0.compareAndSet(null, r1) == true) goto L10;
        if (r0.get() == null) goto L6;
    L10:
        f.set(true);
        return;
    }

    public static f b() {
        c();
        return a.get();
    }

    public static f a(HttpChannel r3) {
        if (r3 != HttpChannel.RustChannel) goto L14;
        AtomicReference<i> r4 = b;
        if (r4.get() != null) goto L13;
        i r0 = new i(new e().a());
    L8:
        if (r4.compareAndSet(null, r0) == true) goto L13;
        if (r4.get() == null) goto L8;
    L13:
        return b.get();
    L14:
        AtomicReference<h> r5 = c;
        if (r5.get() != null) goto L23;
        h r1 = new h(new e().a());
    L18:
        if (r5.compareAndSet(null, r1) == true) goto L23;
        if (r5.get() == null) goto L18;
    L23:
        return c.get();
    }

    public static void d(HttpChannel r2) {
        c();
        if (d == r2) goto L9;
        tt5.a.h("eenet_EEHttpClient", "setNetworkChannel channel: " + r2.toString());
        d = r2;
        c r3 = a.get();
        f r0 = a(d);
        r3.getClass();
        if ((r0 instanceof g) == false) goto L8;
        r3.a = r0;
        return;
    L8:
        throw new AssertionError("httpclient no instance of IOkHttpAttach");
    }
}
