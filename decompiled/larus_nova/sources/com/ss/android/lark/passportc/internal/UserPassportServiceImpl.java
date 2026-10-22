package com.ss.android.lark.passportc.internal;

import android.os.SystemClock;
import com.bytedance.ee.bear.middleground.unbundle.BenefitManagerImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.trace.StepTrace;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class UserPassportServiceImpl implements com.ss.android.lark.passportc.api.m, ComponentLifecycleAware {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f438407l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f438408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.log.c f438409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f438410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l0c.c f438411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BehaviorSubject<f0c.h> f438412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<f0c.h, Unit> f438413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<d0> f438414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<WeakReference<Function1<f0c.h, Unit>>> f438415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f438416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Executor f438417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Scheduler f438418k;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<f0c.h, Unit> f438419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0c.h f438420b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super f0c.h, Unit> r100, f0c.h r101) {
            this.f438419a = r100;
            this.f438420b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f438419a.invoke(this.f438420b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
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

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserPassportServiceImpl f438421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h0 f438422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap<String, Long> f438423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f438424d;

        public d(UserPassportServiceImpl r100, h0 r101, ConcurrentHashMap<String, Long> r102, Ref.LongRef r103) {
            this.f438421a = r100;
            this.f438422b = r101;
            this.f438423c = r102;
            this.f438424d = r103;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            final List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "list");
            final h0 r102 = this.f438422b;
            final ConcurrentHashMap<String, Long> r103 = this.f438423c;
            final Ref.LongRef r104 = this.f438424d;
            return Completable.fromAction(new UserPassportServiceImpl$notifyConventions2$afterUserOfflineResult$1$1(r101, r102, r103, r104)).subscribeOn(this.f438421a.f438418k);
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserPassportServiceImpl f438425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h0 f438426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap<String, Long> f438427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f438428d;

        public e(UserPassportServiceImpl r100, h0 r101, ConcurrentHashMap<String, Long> r102, Ref.LongRef r103) {
            this.f438425a = r100;
            this.f438426b = r101;
            this.f438427c = r102;
            this.f438428d = r103;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            final List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "list");
            final h0 r102 = this.f438426b;
            final ConcurrentHashMap<String, Long> r103 = this.f438427c;
            final Ref.LongRef r104 = this.f438428d;
            return Completable.fromAction(new UserPassportServiceImpl$notifyConventions2$afterUserOnlineResult$1$1(r101, r102, r103, r104)).subscribeOn(this.f438425a.f438418k);
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserPassportServiceImpl f438429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap<String, Long> f438430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h0 f438431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f438432d;

        public f(UserPassportServiceImpl r100, ConcurrentHashMap<String, Long> r101, h0 r102, Ref.LongRef r103) {
            this.f438429a = r100;
            this.f438430b = r101;
            this.f438431c = r102;
            this.f438432d = r103;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            final List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "list");
            final ConcurrentHashMap<String, Long> r102 = this.f438430b;
            final h0 r103 = this.f438431c;
            final Ref.LongRef r104 = this.f438432d;
            return Completable.fromAction(new UserPassportServiceImpl$notifyConventions2$userOfflineResult$1$1(r101, r102, r103, r104)).subscribeOn(this.f438429a.f438418k);
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserPassportServiceImpl f438433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ConcurrentHashMap<String, Long> f438434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h0 f438435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f438436d;

        public g(UserPassportServiceImpl r100, ConcurrentHashMap<String, Long> r101, h0 r102, Ref.LongRef r103) {
            this.f438433a = r100;
            this.f438434b = r101;
            this.f438435c = r102;
            this.f438436d = r103;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            final List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "list");
            final ConcurrentHashMap<String, Long> r102 = this.f438434b;
            final h0 r103 = this.f438435c;
            final Ref.LongRef r104 = this.f438436d;
            return Completable.fromAction(new UserPassportServiceImpl$notifyConventions2$userOnlineResult$1$1(r101, r102, r103, r104)).subscribeOn(this.f438433a.f438418k);
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserPassportServiceImpl f438437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.passportc.api.o f438438b;

        public h(UserPassportServiceImpl r100, com.ss.android.lark.passportc.api.o r101) {
            this.f438437a = r100;
            this.f438438b = r101;
        }

        public final void a() {
            this.f438437a.g(new h0(f0c.i.f475038a, this.f438437a.getState(), CollectionsKt.listOf(new e0(this.f438438b))));
            UserPassportServiceImpl r100 = this.f438437a;
            com.ss.android.lark.passportc.api.o r101 = this.f438438b;
            monitor-enter(r100);
            Iterator<T> r102 = r100.f438414g.iterator();     // Catch: Throwable -> L21
        L6:
            if (r102.hasNext() == false) goto L15;
            Object r103 = r102.next();     // Catch: Throwable -> L21
            d0 r104 = (d0) r103;     // Catch: Throwable -> L21
            if (r104 != null) goto L10;
        L12:
            boolean r105 = false;
        L13:
            if (r105 == false) goto L6;
        L16:
            if (r103 != null) goto L18;
            r100.f438414g.add(new d0(new WeakReference(r101)));     // Catch: Throwable -> L21
            m0c.b.a(r100.f438409b, "n_action_cm_user_convention_registry", "register convention:" + r101.getClass().getName() + "，size=" + r100.f438414g.size() + ", user= " + r100.getUser().userId + ' ');     // Catch: Throwable -> L21
        L18:
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r100);
            return;
        L10:
            if (Intrinsics.areEqual(r104.f438459a.get(), r101) == false) goto L12;
            r105 = true;
            goto L13
        L15:
            r103 = null;
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

    @Override // dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware
    public final void onComponentCreate() {
    }

    @Override // dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware
    public final void onComponentDestroy() {
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final UserSession getSession() {
        return this.f438408a.getSession();
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final f0c.h getState() {
        f0c.h r100 = this.f438412e.getValue();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return f0c.i.f475038a;
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final User getUser() {
        return this.f438408a.getUser();
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final void a(Function1<? super f0c.h, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        f0c.h r101 = this.f438412e.getValue();
        if (r101 != null) goto L5;
        r101 = f0c.i.f475038a;
    L5:
        monitor-enter(this);
        Iterator<T> r102 = this.f438415h.iterator();     // Catch: Throwable -> L18
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(((WeakReference) r103).get(), r100) == false) goto L8;
    L13:
        if (r103 != null) goto L15;
        this.f438416i.execute(new b(r100, r101));     // Catch: Throwable -> L18
        this.f438415h.add(new WeakReference(r100));     // Catch: Throwable -> L18
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

    @Override // com.ss.android.lark.passportc.api.m
    public final void b(final BenefitManagerImpl.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        monitor-enter(this);
        CollectionsKt.removeAll(this.f438415h, new UserPassportServiceImpl$removeUserStateObserver$1$1(r100));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final void c(final com.ss.android.lark.passportc.api.o r100) {
        Intrinsics.checkNotNullParameter(r100, "convention");
        monitor-enter(this);
        m0c.b.a(this.f438409b, "n_action_cm_user_convention_registry", "unregister convention:" + r100.getClass().getName() + ", user= " + getUser().userId + ' ');     // Catch: Throwable -> L7
        CollectionsKt.removeAll(this.f438414g, new UserPassportServiceImpl$unregisterConvention$1$1(r100));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.passportc.api.m
    public final void d(com.ss.android.lark.passportc.api.o r100) {
        Intrinsics.checkNotNullParameter(r100, "convention");
        this.f438417j.execute(new h(this, r100));
    }

    public final void g(h0 r110) {
        Log.i("UserPassportServiceImpl", "notifyConventions user start，uid:" + getUser().userId + " scene:" + r110.f438468a.f475036b + " pre:" + r110.f438468a.f475035a + " cur:" + r110.f438469b.f475035a + ' ');
        long r100 = SystemClock.elapsedRealtimeNanos();
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        ConcurrentHashMap r102 = new ConcurrentHashMap();
        Ref.LongRef r103 = new Ref.LongRef();
        int r104 = Math.max(r110.f438470c.size() / 5, 5);
        UserState r105 = r110.f438468a.f475035a;
        UserState r106 = UserState.OFFLINE;
        if (r105 != r106) goto L16;
        if (r110.f438469b.f475035a != UserState.ONLINE) goto L16;
        StepTrace r107 = m0c.d.f511552a.a(m0c.d.f511564m);
        r107.e(UserPassportServiceImpl$notifyConventions2$userOnlineTrace$1.INSTANCE);
        Throwable r108 = Observable.fromIterable(r110.f438470c).buffer(r104).flatMapCompletable(new g(this, r101, r110, r103)).blockingGet();
        if (r108 != null) goto L13;
        Throwable r109 = Observable.fromIterable(r110.f438470c).buffer(r104).flatMapCompletable(new e(this, r110, r101, r103)).blockingGet();
        if (r109 != null) goto L11;
        StepTrace.g(r107);
    L28:
        e("notifyConventions user cost, online ", r101);
        e("notifyConventions user cost, offline", r102);
        long r111 = SystemClock.elapsedRealtimeNanos() - r100;
        StringBuilder r112 = new StringBuilder("notifyConventions user end, total cost: ");
        long r113 = 10000000;
        r112.append(r111 / r113);
        r112.append(", sumCost: ");
        r112.append(r103.element / r113);
        r112.append(", reduce=");
        r112.append((r103.element - r111) / r113);
        r112.append(" count=");
        r112.append(r110.f438470c.size());
        Log.i("UserPassportServiceImpl", r112.toString());
        return;
    L11:
        f(r109, "afterUserOnline");
        throw null;
    L13:
        f(r108, "onUserOnline");
        throw null;
    L16:
        if (r105 != UserState.ONLINE) goto L28;
        if (r110.f438469b.f475035a != r106) goto L28;
        StepTrace r114 = m0c.d.f511552a.a(m0c.d.f511563l);
        r114.e(UserPassportServiceImpl$notifyConventions2$userOfflineTrace$1.INSTANCE);
        Throwable r115 = Observable.fromIterable(r110.f438470c).buffer(r104).flatMapCompletable(new f(this, r102, r110, r103)).blockingGet();
        if (r115 != null) goto L26;
        Throwable r116 = Observable.fromIterable(r110.f438470c).buffer(r104).flatMapCompletable(new d(this, r110, r102, r103)).blockingGet();
        if (r116 != null) goto L24;
        StepTrace.g(r114);
        goto L28
    L24:
        f(r116, "afterUserOffline");
        throw null;
    L26:
        f(r115, "onUserOffline");
        throw null;
    }

    public static void f(Throwable r100, String r101) {
        Log.e("UserPassportServiceImpl", "notify user " + r101 + " error", new NotifyConventionException(r100.getMessage(), r100), true);
        throw r100;
    }

    public final void e(String r100, Map<String, Long> r101) {
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
        l0c.c r111 = this.f438411d;
        if (r111 == null) goto L16;
        r111.c("rust_infra_user_notify_" + ((String) r109.getKey()), r110);
        goto L16
    L20:
        Log.i("UserPassportServiceImpl", r103.toString());
    }

    @Inject
    public UserPassportServiceImpl(f0 r100, com.ss.android.lark.log.c r101, t r102, l0c.c r103) {
        Intrinsics.checkNotNullParameter(r100, "userDelegate");
        Intrinsics.checkNotNullParameter(r101, "logger");
        Intrinsics.checkNotNullParameter(r102, "passportExecutors");
        this.f438408a = r100;
        this.f438409b = r101;
        this.f438410c = r102;
        this.f438411d = r103;
        this.f438412e = BehaviorSubject.createDefault(f0c.i.f475038a);
        Function1<f0c.h, Unit> r104 = new UserPassportServiceImpl$stateObserver$1(this);
        this.f438413f = r104;
        this.f438414g = new LinkedHashSet();
        this.f438415h = new LinkedHashSet();
        this.f438416i = r102.g();
        this.f438417j = r102.h();
        this.f438418k = r102.e();
        r100.a(r104);
    }
}
