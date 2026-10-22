package com.suite.lark.component.navroute.graph;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public abstract class a implements rnc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<com.suite.lark.component.navroute.api.d, b> f460362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<com.suite.lark.component.navroute.api.d, Function1<C5523a, Unit>> f460363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f460364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super com.suite.lark.component.navroute.api.d, Boolean> f460365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f460366e;

    /* JADX INFO: renamed from: com.suite.lark.component.navroute.graph.a$a, reason: collision with other inner class name */
    public static final class C5523a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<? extends com.suite.lark.component.navroute.api.d> f460367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<? extends com.suite.lark.component.navroute.api.b<?>> f460368b;

        public C5523a() {
            this.f460367a = CollectionsKt.emptyList();
            this.f460368b = CollectionsKt.emptyList();
        }

        public final void a(com.suite.lark.component.navroute.api.d... r100) {
            Intrinsics.checkNotNullParameter(r100, "children");
            this.f460367a = ArraysKt.toList(r100);
        }

        public final void b(com.suite.lark.component.navroute.api.b<?>... r100) {
            Intrinsics.checkNotNullParameter(r100, "destinations");
            this.f460368b = ArraysKt.toList(r100);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.suite.lark.component.navroute.api.b<?>> f460369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.suite.lark.component.navroute.api.d> f460370b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f460369a, r101.f460369a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f460370b, r101.f460370b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f460369a.hashCode() * 31) + this.f460370b.hashCode();
        }

        public final String toString() {
            return "GraphsInfo(destinations=" + this.f460369a + ", children=" + this.f460370b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends com.suite.lark.component.navroute.api.b<?>> r100, List<? extends com.suite.lark.component.navroute.api.d> r101) {
            Intrinsics.checkNotNullParameter(r100, "destinations");
            Intrinsics.checkNotNullParameter(r101, "children");
            this.f460369a = r100;
            this.f460370b = r101;
        }
    }

    public static final class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f460371a = null;

        static {
            f460371a = new c();
        }

        public c() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            r100.run();
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f460372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.suite.lark.component.navroute.api.d f460373b;

        public d(a r100, com.suite.lark.component.navroute.api.d r101) {
            this.f460372a = r100;
            this.f460373b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f460372a.c(this.f460373b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract void b();

    public a() {
        this.f460362a = new ConcurrentHashMap();
        this.f460363b = new ConcurrentHashMap();
    }

    @Override // rnc.d
    public final List<com.suite.lark.component.navroute.api.b<?>> a(com.suite.lark.component.navroute.api.d r100) {
        Intrinsics.checkNotNullParameter(r100, "graph");
        return c(r100).f460369a;
    }

    public final b c(com.suite.lark.component.navroute.api.d r100) {
        ConcurrentHashMap<com.suite.lark.component.navroute.api.d, b> r101 = this.f460362a;
        b r102 = r101.get(r100);
        if (r102 != null) goto L19;
        monitor-enter(r100);
        Function1<C5523a, Unit> r103 = this.f460363b.get(r100);     // Catch: Throwable -> L15
        if (r103 == null) goto L14;
        C5523a r104 = new C5523a();     // Catch: Throwable -> L15
        r103.invoke(r104);     // Catch: Throwable -> L15
        r102 = new b(r104.f460368b, r104.f460367a);     // Catch: Throwable -> L15
        Log.i("NavRouter", "graph " + r100.getClass().getSimpleName() + " init finished");     // Catch: Throwable -> L15
        monitor-exit(r100);
        b r105 = r101.putIfAbsent(r100, r102);
        if (r105 == null) goto L19;
        r102 = r105;
        goto L19
    L14:
        throw new IllegalArgumentException((r100 + " not found").toString());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L19:
        return r102;
    }

    public final void d(com.suite.lark.component.navroute.api.d r100, Function1<? super C5523a, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "graph");
        Intrinsics.checkNotNullParameter(r101, "block");
        this.f460363b.put(r100, r101);
        Function1<? super com.suite.lark.component.navroute.api.d, Boolean> r102 = this.f460365d;
        Executor r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("isSyncGraph");
        r102 = null;
    L6:
        if (r102.invoke(r100).booleanValue() == false) goto L8;
        r103 = c.f460371a;
    L12:
        r103.execute(new d(this, r100));
        return;
    L8:
        Executor r104 = this.f460364c;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("buildGraphExecutor");
        goto L12
    L11:
        r103 = r104;
        goto L12
    }
}
