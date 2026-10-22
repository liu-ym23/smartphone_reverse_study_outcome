package n27;

import com.bytedance.mira.log.MiraLogger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f516745a;

    public final synchronized void d() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public final synchronized void e() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public final synchronized void f() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public static c c() {
        if (f516745a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f516745a != null) goto L9;
        f516745a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f516745a;
    }

    public c() {
        new ConcurrentHashMap();
        new ConcurrentLinkedQueue();
    }

    public final synchronized void a(l27.b r110) {
        monitor-enter(this);
        d.a().getClass();     // Catch: Throwable -> L7
        d.f516747c.a(10000, r110.f507128a, r110.f507129b, -1, -1, null, System.currentTimeMillis(), r110.f507143p, r110.f507130c, r110.f507131d);     // Catch: Throwable -> L7
        MiraLogger.e("PCDN", "doReporter: 10000 " + r110.f507128a);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(l27.b r110, long r111) {
        monitor-enter(this);
        d.a().getClass();     // Catch: Throwable -> L7
        d.f516747c.b(r110.f507128a, r110.f507129b, r111, System.currentTimeMillis(), r110.f507143p, r110.f507130c, r110.f507131d);     // Catch: Throwable -> L7
        MiraLogger.e("PCDN", "doReporter: 11102 " + r110.f507128a + " " + r111);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(l27.b r110, int r111, RuntimeException r112) {
        monitor-enter(this);
        d.a().getClass();     // Catch: Throwable -> L7
        d.f516747c.a(r111, r110.f507128a, r110.f507129b, -1, 0, r112, System.currentTimeMillis(), r110.f507143p, r110.f507130c, r110.f507131d);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
