package st3;

import com.bytedance.apm.util.b;
import com.bytedance.monitor.collector.c;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f543559b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f543560a;

    public static ts3.a a() {
        ts3.a r100 = new ts3.a();
        int r101 = b.b();     // Catch: Exception -> L16
        if (r101 > 0) goto L6;
        return r100;
    L6:
        long r102 = System.currentTimeMillis();     // Catch: Exception -> L16
        long r103 = c.e().a();     // Catch: Exception -> L16
        long r104 = c.e().d(r101);     // Catch: Exception -> L16
        Thread.sleep(360);     // Catch: InterruptedException -> L15 Exception -> L16
    L9:
        long r105 = c.e().a();     // Catch: Exception -> L16
        long r110 = c.e().d(r101) - r104;     // Catch: Exception -> L16
        if (r110 <= 0) goto L12;
        double r106 = (r105 - r103) / r110;     // Catch: Exception -> L16
    L13:
        double r107 = (((r105 - r103) * 1000.0d) / (System.currentTimeMillis() - r102)) / b.f();     // Catch: Exception -> L16
        r100.f547363a = r106;     // Catch: Exception -> L16
        r100.f547364b = r107;     // Catch: Exception -> L16
        goto L14
    L12:
        r106 = -1.0d;
    L14:
        return r100;
    }

    public static a b() {
        if (f543559b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f543559b != null) goto L9;
        f543559b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f543559b;
    }

    public a() {
        this.f543560a = new CopyOnWriteArraySet();
    }

    public final void c(String r100) {
        this.f543560a.add(r100);
        ou3.a.a().f526725a.add(r100);
    }

    public final void d(String r100) {
        this.f543560a.remove(r100);
        ou3.a.a().f526725a.remove(r100);
    }
}
