package com.ss.android.lark.log.trace;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class StepTrace {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy<AtomicInteger> f431411h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f431412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f431413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f431414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f431415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f431416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.log.trace.a f431417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f431418g;

    public static final class a {
    }

    static {
        f431411h = LazyKt.lazy(StepTrace$Companion$idGenerator$2.INSTANCE);
    }

    public static /* synthetic */ void b(StepTrace r100) {
        r100.a(StepTrace$asyncBegin$1.INSTANCE);
    }

    public static /* synthetic */ void d(StepTrace r100) {
        r100.c(StepTrace$asyncEnd$1.INSTANCE);
    }

    public static /* synthetic */ void f(StepTrace r100) {
        r100.e(StepTrace$begin$1.INSTANCE);
    }

    public static void g(StepTrace r100) {
        StepTrace$end$1 r101 = StepTrace$end$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "block");
        r100.c(r101);
    }

    public final void a(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f431418g = true;
        c r101 = this.f431415d;
        com.ss.android.lark.log.trace.a r102 = this.f431417f;
        r102.f431419a = System.currentTimeMillis();
        Unit r103 = Unit.INSTANCE;
        r100.invoke(r101, r102);
        if (r101.f431422a == true) goto L6;
        Lazy r104 = LogTraceWrapper.f431409a;
        LogTraceWrapper.a(this.f431412a, this.f431413b, this.f431414c, this.f431417f.f431419a);
        return;
    }

    public final void c(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (this.f431418g == false) goto L12;
        c r101 = this.f431416e;
        com.ss.android.lark.log.trace.a r102 = this.f431417f;
        r102.f431420b = System.currentTimeMillis();
        Unit r103 = Unit.INSTANCE;
        r100.invoke(r101, r102);
        if (r101.f431423b == true) goto L7;
    L10:
        this.f431418g = false;
        return;
    L7:
        if (this.f431415d.f431422a == false) goto L9;
        Lazy r104 = LogTraceWrapper.f431409a;
        LogTraceWrapper.a(this.f431412a, this.f431413b, this.f431414c, this.f431417f.f431419a);
    L9:
        Lazy r105 = LogTraceWrapper.f431409a;
        String r106 = this.f431412a;
        int r107 = this.f431414c;
        long r108 = this.f431417f.f431420b;
        Intrinsics.checkNotNullParameter(r106, "event");
        com.bytedance.apm6.foundation.trace.a.b((String) LogTraceWrapper.f431409a.getValue(), ((Number) LogTraceWrapper.f431410b.getValue()).longValue(), r106, r107, r108, null);
        goto L10
    }

    public final void e(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        a(r100);
    }

    public StepTrace(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f431412a = r100;
        this.f431413b = r101;
        this.f431414c = f431411h.getValue().getAndIncrement();
        this.f431415d = new c(null);
        this.f431416e = new c(null);
        this.f431417f = new com.ss.android.lark.log.trace.a(r100, r101);
    }

    public final void h(Function2<? super c, ? super com.ss.android.lark.log.trace.a, Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r100, "block");
        a(r100);
        r101.invoke();
        Intrinsics.checkNotNullParameter(r100, "block");
        c(r100);
    }
}
