package mu7;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class i implements ju7.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f515803h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f515804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f515805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f515806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f515807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f515808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, j> f515809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f515810g;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "Scene(" + this.f515804a + ',' + this.f515805b + ',' + this.f515806c + ')';
    }

    public static String e(String r100) {
        return r100 + "_NULL";
    }

    @Override // ju7.c
    public final void a(Map<String, ? extends Object> r100) {
        this.f515807d.b();
        f(r100, new f());
    }

    public i(String r100, String r101) {
        this.f515804a = "LAUNCH";
        this.f515805b = r100;
        this.f515806c = r101;
        this.f515807d = new b();
        this.f515808e = new LinkedHashSet();
        this.f515809f = new ConcurrentHashMap();
        this.f515810g = new ConcurrentHashMap();
    }

    @Override // ju7.c
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r100, "step");
        g(r100, true, null, null, r101);
    }

    @Override // ju7.c
    public final void c(final String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r100, "step");
        String r102 = e(r100);
        if (((ConcurrentHashMap) this.f515809f).containsKey(r102) == false) goto L8;
        Lazy r103 = ku7.c.f506221a;
        String r104 = "Step[" + r102 + "] already exist";
        Intrinsics.checkNotNullParameter(r104, "msg");
        ku7.a r105 = ku7.a.f506216a;
        ju7.b r106 = ku7.a.f506218c;
        if (r106 != null) goto L7;
        r106 = (ju7.b) ku7.c.f506221a.getValue();
    L7:
        r106.w(r104);
        return;
    L8:
        j r107 = new j(r100);
        monitor-enter(r107);
        r107.f515813c = false;     // Catch: Throwable -> L15
        r107.f515814d.b();     // Catch: Throwable -> L15
        monitor-exit(r107);
        ((ConcurrentHashMap) this.f515809f).put(r102, r107);
        f(r101, new e(r100));
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void f(final Map r100, final Function1 r101) {
        ku7.a r102 = ku7.a.f506216a;
        if (ku7.a.f506219d == true) goto L5;
        return;
    L5:
        Executor r103 = ku7.h.f506224a;
        Runnable r104 = new h(this, r100, r101);
        Intrinsics.checkNotNullParameter(r104, "runnable");
        ku7.h.f506225b.execute(r104);
    }

    @Override // ju7.c
    public final void d(String r100, int r101, String r110, Map<String, ? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r100, "step");
        g(r100, false, Integer.valueOf(r101), r110, r111);
    }

    @Override // ju7.c
    public synchronized void update(String r100, String r101, String r102, Collection<String> r103) {
        monitor-enter(this);
        if (r100 != null) goto L17;
    L5:
        if (r101 == null) goto L7;
        this.f515805b = r101;     // Catch: Throwable -> L14
    L7:
        if (r102 == null) goto L9;
        this.f515806c = r102;     // Catch: Throwable -> L14
    L9:
        if (r103 != null) goto L11;
        this.f515808e.clear();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        this.f515808e.clear();     // Catch: Throwable -> L14
        this.f515808e.addAll(r103);     // Catch: Throwable -> L14
        goto L12
    L17:
        Intrinsics.checkNotNullParameter(r100, "<set-?>");     // Catch: Throwable -> L14
        this.f515804a = r100;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void g(final String r100, final boolean r110, final Integer r111, final String r112, Map r113) {
        final j r101 = (j) ((ConcurrentHashMap) this.f515809f).get(e(r100));
        if (r101 != null) goto L5;
        return;
    L5:
        monitor-enter(r101);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (r101.f515813c == false) goto L14;
        Lazy r102 = ku7.c.f506221a;     // Catch: Throwable -> L22
        String r103 = r101 + " already finished";     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r103, "msg");     // Catch: Throwable -> L22
        ku7.a r114 = ku7.a.f506216a;     // Catch: Throwable -> L22
        ju7.b r115 = ku7.a.f506218c;     // Catch: Throwable -> L22
        if (r115 != null) goto L11;
        r115 = (ju7.b) ku7.c.f506221a.getValue();     // Catch: Throwable -> L22
    L11:
        r115.w(r103);     // Catch: Throwable -> L22
        monitor-exit(r101);
        return;
    L14:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r101);
        r101.a();
        if (r110 == false) goto L19;
        String r105 = "success";
    L20:
        final String r106 = r105;
        f(r113, new g(r101, r100, r110, r106, r111, r112));
        return;
    L19:
        r105 = "failure";
        goto L20
    }
}
