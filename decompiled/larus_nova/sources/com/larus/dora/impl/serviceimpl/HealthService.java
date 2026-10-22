package com.larus.dora.impl.serviceimpl;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.o0;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class HealthService implements IDoraService.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f337974d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<t39.q> f337975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f337976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f337977c;

    public static final class a {
    }

    public static final class b implements zj4.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HealthService f337978a;

        @Override // zj4.d
        public final /* synthetic */ void a(int r100, long r101) {
        }

        @Override // zj4.d
        public final /* synthetic */ void c(int r100, long r101) {
        }

        @Override // zj4.d
        public final /* synthetic */ void d(int r100, long r101) {
        }

        @Override // zj4.d
        public final /* synthetic */ void e(int r100, long r101) {
        }

        @Override // zj4.d
        public final /* synthetic */ void f(int r100, long r101) {
        }

        public b(HealthService r100) {
            this.f337978a = r100;
        }

        @Override // zj4.d
        public final void b(int r100) {
            FLogger.f375446a.i("HealthService", "onHealthServiceLongHeadDownCalibration: status=" + r100);
            Iterator<t39.q> r101 = this.f337978a.f337975a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().b(r100);
            goto L4
        }

        @Override // zj4.d
        public final void g(int r100) {
            boolean r101 = true;
            if (r100 == 1) goto L6;
            r101 = false;
        L6:
            FLogger.f375446a.i("HealthService", "onBehaviorAwareToggleChanged: toggle=" + r100 + ", isEnabled=" + r101);
            Iterator<t39.q> r102 = this.f337978a.f337975a.iterator();
        L8:
            if (r102.hasNext() == false) goto L10;
            r102.next().a(r101);
            goto L8
        }
    }

    static {
    }

    public static zj4.a h() {
        return zj4.a.C8468a.f572461a;
    L4:
        th = move-exception;
        FLogger.f375446a.e("HealthService", "getDoraHealth failed", th);
        return null;
    }

    public final Object i() {
        sk4.e r100 = o0.f332223a;
        return Boxing.boxBoolean(o0.c("behaviorAware"));
    }

    public HealthService() {
        this.f337975a = new CopyOnWriteArraySet();
        this.f337976b = new AtomicBoolean(false);
        this.f337977c = new b(this);
    }

    @Override // com.larus.dora.api.IDoraService.f
    public final void a(t39.q r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f337975a.add(r100);
        if (this.f337976b.get() == true) goto L14;
        zj4.a r101 = h();
        if (r101 == null) goto L14;
        if (this.f337976b.compareAndSet(false, true) == false) goto L14;
        ((CopyOnWriteArraySet) r101.f572454a).add(this.f337977c);     // Catch: Throwable -> L12
        FLogger.f375446a.i("HealthService", "HealthService initialized with health callback bridge");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.f337976b.set(false);
        FLogger.f375446a.e("HealthService", "registerDoraHealthCallback failed", th);
    L14:
        FLogger.f375446a.i("HealthService", "registerHealthCallback success: size=" + this.f337975a.size());
    }

    @Override // com.larus.dora.api.IDoraService.f
    public final Object b(Continuation<? super b49.j> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$takeSedentaryDurationConfig$2(this, null), r100);
    }

    @Override // com.larus.dora.api.IDoraService.f
    public final void c(t39.q r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f337975a.remove(r100);
        FLogger.f375446a.i("HealthService", "unregisterHealthCallback success: size=" + this.f337975a.size());
    }

    @Override // com.larus.dora.api.IDoraService.f
    public final Object d(Continuation<? super Integer> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$syncLongHeadDownCalibration$2(this, 1, null), r100);
    }

    @Override // com.larus.dora.api.IDoraService.f
    public final Object e(Continuation<? super b49.i> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$takeLongHeadDownDurationConfig$2(this, null), r100);
    }

    @Override // com.larus.dora.api.IDoraService.f
    public final Object f(Continuation<? super Boolean> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$isHeadDownDetectionSupported$2(null), r100);
    }

    @Override // com.larus.dora.api.IDoraService.f
    public final Object g(Continuation<? super Integer> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$syncLongHeadDownCalibration$2(this, 2, null), r100);
    }

    public final Object m(Continuation<? super Boolean> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$takeBehaviorAwareToggle$2(this, null), r100);
    }

    public final Object n(Continuation<? super Integer> r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$takeLongHeadDownCalibration$2(this, null), r100);
    }

    public final Object j(boolean r100, ContinuationImpl r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$syncBehaviorAwareToggle$2(r100, this, null), r101);
    }

    public final Object k(int r100, Continuation<? super Boolean> r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$syncLongHeadDownDuration$2(this, r100, null), r101);
    }

    public final Object l(int r100, Continuation<? super Boolean> r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HealthService$syncSedentaryDuration$2(this, r100, null), r101);
    }
}
