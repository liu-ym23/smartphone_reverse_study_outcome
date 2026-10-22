package f27;

import com.bytedance.apm.j;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f475214f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f475215g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f475216h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile g27.c f475217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile g27.c f475218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile g27.c f475219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<AsyncTaskType, Long> f475220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f475221e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f475222a = null;

        static {
            f475222a = new d();
        }
    }

    static {
        f475214f = new Object();
        f475215g = new Object();
        f475216h = new Object();
    }

    public final g27.c c() {
        if (this.f475217a != null) goto L15;
        Object r100 = f475214f;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f475217a != null) goto L9;
        e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return this.f475217a;
    }

    public final g27.c d() {
        if (this.f475219c != null) goto L15;
        Object r100 = f475216h;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f475219c != null) goto L9;
        g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return this.f475219c;
    }

    public final void e() {
        Object r100 = f475214f;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f475217a != null) goto L7;
        g27.a r101 = new g27.a("io-task");     // Catch: Throwable -> L9
        r101.f479733b = new f27.a(this);     // Catch: Throwable -> L9
        this.f475217a = new g27.c(r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public final void f() {
        Object r100 = f475215g;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f475218b != null) goto L7;
        g27.a r101 = new g27.a("light-weight-task");     // Catch: Throwable -> L9
        r101.f479733b = new b(this);     // Catch: Throwable -> L9
        this.f475218b = new g27.c(r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public final void g() {
        Object r100 = f475216h;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f475219c != null) goto L7;
        g27.a r101 = new g27.a("time-sensitive-task");     // Catch: Throwable -> L9
        r101.f479733b = new c(this);     // Catch: Throwable -> L9
        this.f475219c = new g27.c(r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public d() {
        this.f475220d = new ConcurrentHashMap(3);
    }

    public final g27.c b(g r100) {
        AsyncTaskType r101 = r100.getTaskType();
        if (r101 != AsyncTaskType.IO) goto L7;
        return c();
    L7:
        if (r101 != AsyncTaskType.TIME_SENSITIVE) goto L11;
        return d();
    L11:
        if (this.f475218b != null) goto L23;
        Object r102 = f475215g;
        monitor-enter(r102);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (this.f475218b != null) goto L17;
        f();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L19
    L23:
        return this.f475218b;
    }

    public final void h(g r100) {
        b(r100).submit(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(th, "Apm-Async-task-post");
    }

    public final void j(g r100) {
        if (r100 != null) goto L12;
        return;
    L12:
        g27.c r101 = b(r100);     // Catch: Throwable -> L9
        ThreadPoolExecutor r102 = r101.f479741d;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.remove(r100);     // Catch: Throwable -> L9
    L7:
        r101.e(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        a(th, "Apm-Async-task-removeTask");
    }

    public final void k(ExecutorService r100) {
        g27.c r101 = c();
        if (r100 != null) goto L5;
        r101.f479740c = null;
        r101.f479741d = null;
        return;
    L5:
        r101.getClass();
        if ((r100 instanceof ThreadPoolExecutor) == false) goto L8;
        r101.f479741d = (ThreadPoolExecutor) r100;
    L8:
        r101.f479740c = (ExecutorService) Proxy.newProxyInstance(r100.getClass().getClassLoader(), new Class[]{ExecutorService.class}, new g27.b(r101, r100));
    }

    public final void a(Throwable r100, String r101) {
        f r102 = this.f475221e;
        if (r102 != null) goto L5;
        return;
    L5:
        if (((j) r102).f190607a.f190608a == null) goto L9;
        EnsureManager.reportLogEException(5, r100, r101, false);
        return;
    }

    public final void i(g r100, long r101) {
        if (r100 != null) goto L9;
        return;
    L9:
        g27.c r102 = b(r100);     // Catch: Throwable -> L6
        r102.getClass();     // Catch: Throwable -> L6
        r102.h(r102.schedule(r100, r101, TimeUnit.MILLISECONDS), r100.hashCode(), false);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(th, "Apm-Async-task-postDelayed");
    }
}
