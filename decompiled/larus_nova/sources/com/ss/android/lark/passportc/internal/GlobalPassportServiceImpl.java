package com.ss.android.lark.passportc.internal;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.trace.StepTrace;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class GlobalPassportServiceImpl implements com.ss.android.lark.passportc.api.j {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f438313m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<com.ss.android.lark.passportc.api.e> f438314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.log.c f438315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f438316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l0c.c f438317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Provider<Set<com.ss.android.lark.passportc.api.p>> f438318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f438319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<f0c.b, Unit> f438320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<g> f438321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<WeakReference<Function1<f0c.b, Unit>>> f438322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Executor f438323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Executor f438324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f438325l;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GlobalPassportServiceImpl f438326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<List<h>, Unit> f438327b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(GlobalPassportServiceImpl r100, Function1<? super List<h>, Unit> r101) {
            this.f438326a = r100;
            this.f438327b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "list");
            return Completable.fromAction(new n(this.f438327b, r101)).subscribeOn((Scheduler) this.f438326a.f438325l.getValue());
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Long) ((Map.Entry) r101).getValue(), (Long) ((Map.Entry) r100).getValue());
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GlobalPassportServiceImpl f438328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.passportc.api.n f438329b;

        public d(GlobalPassportServiceImpl r100, com.ss.android.lark.passportc.api.n r101) {
            this.f438328a = r100;
            this.f438329b = r101;
        }

        public final void a() {
            GlobalPassportServiceImpl r100 = this.f438328a;
            r100.l(new s(f0c.c.f475025a, r100.d(), CollectionsKt.listOf(new h(this.f438329b))));
            GlobalPassportServiceImpl r101 = this.f438328a;
            com.ss.android.lark.passportc.api.n r102 = this.f438329b;
            monitor-enter(r101);
            Iterator<T> r103 = r101.f438321h.iterator();     // Catch: Throwable -> L21
        L6:
            if (r103.hasNext() == false) goto L15;
            Object r104 = r103.next();     // Catch: Throwable -> L21
            g r105 = (g) r104;     // Catch: Throwable -> L21
            if (r105 != null) goto L10;
        L12:
            boolean r106 = false;
        L13:
            if (r106 == false) goto L6;
        L16:
            if (r104 != null) goto L18;
            r101.f438321h.add(new g(new WeakReference(r102)));     // Catch: Throwable -> L21
        L18:
            Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r101);
            return;
        L10:
            if (Intrinsics.areEqual(r105.f438462a.get(), r102) == false) goto L12;
            r106 = true;
            goto L13
        L15:
            r104 = null;
        L21:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final List<f0c.b> a() {
        return this.f438314a.get().a();
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final UserSession b() {
        f0c.b r100 = (f0c.b) ((BehaviorSubject) this.f438319f.getValue()).getValue();
        if (r100 == null) goto L7;
        f0c.g r101 = r100.a();
        if (r101 == null) goto L7;
        return r101.f475034b;
    L7:
        return null;
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final f0c.b d() {
        f0c.b r100 = (f0c.b) ((BehaviorSubject) this.f438319f.getValue()).getValue();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return f0c.c.f475025a;
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final String g() {
        f0c.b r100 = (f0c.b) ((BehaviorSubject) this.f438319f.getValue()).getValue();
        if (r100 == null) goto L9;
        f0c.g r101 = r100.a();
        if (r101 == null) goto L9;
        User r102 = r101.f475033a;
        if (r102 == null) goto L9;
        return r102.userId;
    L9:
        return null;
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final UserSession f() {
        UserSession r100 = b();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ContainerConstsKt.a();
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final void c(com.ss.android.lark.passportc.ffi.a.C5240a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        f0c.b r101 = (f0c.b) ((BehaviorSubject) this.f438319f.getValue()).getValue();
        if (r101 != null) goto L5;
        r101 = f0c.c.f475025a;
    L5:
        monitor-enter(this);
        Iterator<T> r102 = this.f438322i.iterator();     // Catch: Throwable -> L18
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(((WeakReference) r103).get(), r100) == false) goto L8;
    L13:
        if (r103 != null) goto L15;
        this.f438323j.execute(new m(r100, r101));     // Catch: Throwable -> L18
        this.f438322i.add(new WeakReference(r100));     // Catch: Throwable -> L18
    L15:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L12:
        r103 = null;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final void e(com.ss.android.lark.passportc.api.n r100) {
        Intrinsics.checkNotNullParameter(r100, "convention");
        this.f438324k.execute(new d(this, r100));
    }

    @Override // com.ss.android.lark.passportc.api.j
    public final void h(final com.ss.android.lark.passportc.api.n r100) {
        Intrinsics.checkNotNullParameter(r100, "convention");
        monitor-enter(this);
        CollectionsKt.removeAll(this.f438321h, new GlobalPassportServiceImpl$unregisterConvention$1$1(r100));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void l(final s r110) {
        f0c.b r100 = r110.f438481a;
        StringBuilder r101 = new StringBuilder("notifyConventions global start，pre: uid=");
        f0c.g r102 = r100.a();
        if (r102 == null) goto L7;
        User r103 = r102.f475033a;
        if (r103 == null) goto L7;
        String r104 = r103.userId;
    L8:
        r101.append(r104);
        r101.append(" scene=");
        r101.append(r100.f475024b.f475036b);
        r101.append(" state=");
        r101.append(r100.f475024b.f475035a);
        r101.append('}');
        Log.i("n_action_cm_global_convention_registry", r101.toString());
        f0c.b r105 = r110.f438482b;
        StringBuilder r106 = new StringBuilder("notifyConventions global start，cur: uid=");
        f0c.g r107 = r105.a();
        if (r107 == null) goto L13;
        User r108 = r107.f475033a;
        if (r108 == null) goto L13;
        String r109 = r108.userId;
    L14:
        r106.append(r109);
        r106.append(" scene=");
        r106.append(r105.f475024b.f475036b);
        r106.append(" state=");
        r106.append(r105.f475024b.f475035a);
        r106.append('}');
        Log.i("n_action_cm_global_convention_registry", r106.toString());
        long r111 = SystemClock.elapsedRealtimeNanos();
        final ConcurrentHashMap r112 = new ConcurrentHashMap();
        final ConcurrentHashMap r113 = new ConcurrentHashMap();
        final ConcurrentHashMap r114 = new ConcurrentHashMap();
        final Ref.LongRef r115 = new Ref.LongRef();
        Math.max(r110.f438483c.size() / 5, 5);
        if ((r110.f438481a instanceof f0c.f) == false) goto L29;
        f0c.b r116 = r110.f438482b;
        if ((r116 instanceof f0c.e) == false) goto L19;
    L20:
        StepTrace r117 = m0c.d.f511552a.a(m0c.d.f511560i);
        r117.e(GlobalPassportServiceImpl$notifyConventions2$offlineTrace$1.INSTANCE);
        Throwable r118 = i(r110.f438483c, new GlobalPassportServiceImpl$notifyConventions2$userOfflineResult$1(r112, r110, r115));
        if (r118 != null) goto L27;
        Throwable r119 = i(r110.f438483c, new GlobalPassportServiceImpl$notifyConventions2$afterUserOfflineResult$1(r110, r112, r115));
        if (r119 != null) goto L25;
        StepTrace.g(r117);
        goto L29
    L25:
        k(r119, "afterUserOffline");
        throw null;
    L27:
        k(r118, "onUserOffline");
        throw null;
    L19:
        if ((r116 instanceof f0c.a) == true) goto L20;
    L29:
        f0c.g r120 = r110.f438481a.a();
        if (r120 == null) goto L32;
        UserSession r121 = r120.f475034b;
    L33:
        f0c.g r122 = r110.f438482b.a();
        if (r122 == null) goto L36;
        UserSession r123 = r122.f475034b;
    L38:
        if (com.ss.android.lark.passportc.convention.d.a(r121, r123) == false) goto L48;
        StepTrace r124 = m0c.d.f511552a.a(m0c.d.f511561j);
        r124.e(GlobalPassportServiceImpl$notifyConventions2$userChangeTrace$1.INSTANCE);
        Throwable r125 = i(r110.f438483c, new GlobalPassportServiceImpl$notifyConventions2$userChangeResult$1(r113, r110, r115));
        if (r125 != null) goto L46;
        Throwable r126 = i(r110.f438483c, new GlobalPassportServiceImpl$notifyConventions2$afterUserChangedResult$1(r110, r113, r115));
        if (r126 != null) goto L44;
        StepTrace.g(r124);
        goto L48
    L44:
        k(r126, "afterUserChanged");
        throw null;
    L46:
        k(r125, "onUserChanged");
        throw null;
    L48:
        f0c.b r127 = r110.f438481a;
        if ((r127 instanceof f0c.e) == true) goto L53;
        if ((r127 instanceof f0c.a) == true) goto L53;
    L63:
        j("notifyConventions global cost, userOffline", r112);
        j("notifyConventions global cost, userChanged", r113);
        j("notifyConventions global cost, userOnline ", r114);
        long r128 = SystemClock.elapsedRealtimeNanos() - r111;
        StringBuilder r129 = new StringBuilder("notifyConventions global end, total cost: ");
        long r130 = 1000000;
        r129.append(r128 / r130);
        r129.append(", sumCost: ");
        r129.append(r115.element / r130);
        r129.append(", reduce=");
        r129.append((r115.element - r128) / r130);
        r129.append(", count=");
        r129.append(r110.f438483c.size());
        Log.i("n_action_cm_global_convention_registry", r129.toString());
        return;
    L53:
        if ((r110.f438482b instanceof f0c.f) == false) goto L63;
        StepTrace r131 = m0c.d.f511552a.a(m0c.d.f511562k);
        r131.e(GlobalPassportServiceImpl$notifyConventions2$userOnlineTrace$1.INSTANCE);
        Throwable r132 = i(r110.f438483c, new GlobalPassportServiceImpl$notifyConventions2$userOnlineResult$1(r114, r110, r115));
        if (r132 != null) goto L61;
        Throwable r133 = i(r110.f438483c, new GlobalPassportServiceImpl$notifyConventions2$afterUserOnlineResult$1(r110, r114, r115));
        if (r133 != null) goto L59;
        StepTrace.g(r131);
        goto L63
    L59:
        k(r133, "afterUserOnline");
        throw null;
    L61:
        k(r132, "onUserOnline");
        throw null;
    L36:
        r123 = null;
        goto L38
    L32:
        r121 = null;
    L13:
        r109 = null;
    L7:
        r104 = null;
        goto L8
    }

    public static void k(Throwable r100, String r101) {
        Log.e("n_action_cm_global_convention_registry", "notify global " + r101 + " error", new NotifyConventionException(r100.getMessage(), r100), true);
        throw r100;
    }

    public final Throwable i(List<h> r100, Function1<? super List<h>, Unit> r101) {
        if (r100.size() <= 5) goto L10;
        int r102 = Math.max(r100.size() / 5, 5);
        return Observable.fromIterable(r100).buffer(r102).flatMapCompletable(new b(this, r101)).blockingGet();
    L10:
        r101.invoke(r100);     // Catch: Throwable -> L6
        return null;
    L6:
        th = move-exception;
        return th;
    }

    public final void j(String r100, Map<String, Long> r101) {
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        if (r102.isEmpty() == false) goto L5;
        return;
    L5:
        StringBuilder r103 = new StringBuilder(r100 + ", count=" + r102.size() + ':');
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = r102.entrySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L14;
        Map.Entry r106 = (Map.Entry) r105.next();
        if (((Number) r106.getValue()).longValue() <= 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L7;
        r104.put(r106.getKey(), r106.getValue());
        goto L7
    L11:
        r107 = false;
        goto L12
    L14:
        Iterator r108 = CollectionsKt.sortedWith(r104.entrySet(), new c()).iterator();
    L16:
        if (r108.hasNext() == false) goto L20;
        Map.Entry r109 = (Map.Entry) r108.next();
        long r110 = ((Number) r109.getValue()).longValue() / ((long) 1000000);
        r103.append("\n  cost:" + r110 + ", " + ((String) r109.getKey()));
        l0c.c r111 = this.f438317d;
        if (r111 == null) goto L16;
        r111.c("rust_infra_user_notify_" + ((String) r109.getKey()), r110);
        goto L16
    L20:
        Log.i("n_action_cm_global_convention_registry", r103.toString());
    }

    @Inject
    public GlobalPassportServiceImpl(Provider<com.ss.android.lark.passportc.api.e> r100, com.ss.android.lark.log.c r101, t r102, l0c.c r103, Provider<Set<com.ss.android.lark.passportc.api.p>> r104) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "logger");
        Intrinsics.checkNotNullParameter(r102, "executors");
        this.f438314a = r100;
        this.f438315b = r101;
        this.f438316c = r102;
        this.f438317d = r103;
        this.f438318e = r104;
        this.f438319f = LazyKt.lazy(GlobalPassportServiceImpl$lastState$2.INSTANCE);
        Function1<f0c.b, Unit> r105 = new GlobalPassportServiceImpl$stateObserver$1(this);
        this.f438320g = r105;
        this.f438321h = new LinkedHashSet();
        this.f438322i = new LinkedHashSet();
        this.f438323j = r102.g();
        this.f438324k = r102.h();
        this.f438325l = LazyKt.lazy(new GlobalPassportServiceImpl$workSchedulerPool$2(this));
        r100.get().d(r105);
    }
}
