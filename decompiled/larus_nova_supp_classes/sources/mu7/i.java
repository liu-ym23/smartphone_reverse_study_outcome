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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i implements ju7.c {
    public static final /* synthetic */ int h = 0;
    public volatile String a;
    public volatile String b;
    public volatile String c;
    public final b d;
    public final Set<String> e;
    public final Map<String, j> f;
    public final Map<String, Object> g;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "Scene(" + this.a + ',' + this.b + ',' + this.c + ')';
    }

    public static String e(String r1) {
        return r1 + "_NULL";
    }

    @Override // ju7.c
    public final void a(Map<String, ? extends Object> r2) {
        this.d.b();
        f(r2, new f());
    }

    public i(String r2, String r3) {
        this.a = "LAUNCH";
        this.b = r2;
        this.c = r3;
        this.d = new b();
        this.e = new LinkedHashSet();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
    }

    @Override // ju7.c
    public final void b(String r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "step");
        Intrinsics.checkNotNullParameter(r8, "step");
        g(r8, true, null, null, r9);
    }

    @Override // ju7.c
    public final void c(final String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "step");
        Intrinsics.checkNotNullParameter(r4, "step");
        String r0 = e(r4);
        if (((ConcurrentHashMap) this.f).containsKey(r0) == false) goto L8;
        Lazy r6 = ku7.c.a;
        String r7 = "Step[" + r0 + "] already exist";
        Intrinsics.checkNotNullParameter(r7, "msg");
        ku7.a r8 = ku7.a.a;
        ju7.b r9 = ku7.a.c;
        if (r9 != null) goto L7;
        r9 = (ju7.b) ku7.c.a.getValue();
    L7:
        r9.w(r7);
        return;
    L8:
        j r1 = new j(r4);
        monitor-enter(r1);
        r1.c = false;     // Catch: Throwable -> L15
        r1.d.b();     // Catch: Throwable -> L15
        monitor-exit(r1);
        ((ConcurrentHashMap) this.f).put(r0, r1);
        f(r5, new e(r4));
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void f(final Map r2, final Function1 r3) {
        ku7.a r0 = ku7.a.a;
        if (ku7.a.d == true) goto L5;
        return;
    L5:
        Executor r1 = ku7.h.a;
        Runnable r4 = new h(this, r2, r3);
        Intrinsics.checkNotNullParameter(r4, "runnable");
        ku7.h.b.execute(r4);
    }

    @Override // ju7.c
    public final void d(String r8, int r9, String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r8, "step");
        Intrinsics.checkNotNullParameter(r8, "step");
        g(r8, false, Integer.valueOf(r9), r10, r11);
    }

    @Override // ju7.c
    public synchronized void update(String r2, String r3, String r4, Collection<String> r5) {
        monitor-enter(this);
        if (r2 != null) goto L17;
    L5:
        if (r3 == null) goto L7;
        this.b = r3;     // Catch: Throwable -> L14
    L7:
        if (r4 == null) goto L9;
        this.c = r4;     // Catch: Throwable -> L14
    L9:
        if (r5 != null) goto L11;
        this.e.clear();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        this.e.clear();     // Catch: Throwable -> L14
        this.e.addAll(r5);     // Catch: Throwable -> L14
        goto L12
    L17:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");     // Catch: Throwable -> L14
        this.a = r2;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void g(final String r9, final boolean r10, final Integer r11, final String r12, Map r13) {
        final j r2 = (j) ((ConcurrentHashMap) this.f).get(e(r9));
        if (r2 != null) goto L5;
        return;
    L5:
        monitor-enter(r2);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (r2.c == false) goto L14;
        Lazy r14 = ku7.c.a;     // Catch: Throwable -> L22
        String r15 = r2 + " already finished";     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r15, "msg");     // Catch: Throwable -> L22
        ku7.a r16 = ku7.a.a;     // Catch: Throwable -> L22
        ju7.b r17 = ku7.a.c;     // Catch: Throwable -> L22
        if (r17 != null) goto L11;
        r17 = (ju7.b) ku7.c.a.getValue();     // Catch: Throwable -> L22
    L11:
        r17.w(r15);     // Catch: Throwable -> L22
        monitor-exit(r2);
        return;
    L14:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r2);
        r2.a();
        if (r10 == false) goto L19;
        String r1 = "success";
    L20:
        final String r5 = r1;
        f(r13, new g(r2, r9, r10, r5, r11, r12));
        return;
    L19:
        r1 = "failure";
        goto L20
    }
}
