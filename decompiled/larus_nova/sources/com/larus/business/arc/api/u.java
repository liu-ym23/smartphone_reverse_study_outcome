package com.larus.business.arc.api;

import com.flow.kmp.common.platform.PlatformLoggerLevel;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ouc.d0;

/* JADX INFO: loaded from: classes26.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f319924a = null;

    static {
        f319924a = new u();
    }

    public u() {
    }

    public static void d(String r100) {
        wt7.c r101 = wt7.a.f561230a;     // Catch: Throwable -> L4
        wt7.b.a(PlatformLoggerLevel.WARN, "ArcObservability", r100);     // Catch: Throwable -> L4
        return;
    }

    public final Object b(c r100, Continuation r101) {
        if ((r101 instanceof ArcRuntime$dispatchWithoutObservation$1) == false) goto L7;
        ArcRuntime$dispatchWithoutObservation$1 r102 = (ArcRuntime$dispatchWithoutObservation$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        String r107 = null;
        if (r106 == 0) goto L20;
        if (r106 != 1) goto L19;
        r100 = (c) r102.L$1;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14 CancellationException -> L16
    L36:
        m r109 = (m) r104;     // Catch: Throwable -> L14 CancellationException -> L16
    L38:
        if ((r109 instanceof m.b) == false) goto L41;
        ((m.b) r109).getClass();
        return v.d(null, r100);
    L41:
        if (Intrinsics.areEqual(r109, m.a.f319904a) == false) goto L45;
        return v.d(v.c(r108, "ARC_RUNTIME_EMPTY_RESULT", "Arc runtime service returned an empty result."), r100);
    L45:
        throw new NoWhenBranchMatchedException();
    L14:
        th = th;
        r107 = r108;
    L47:
        StringBuilder r110 = new StringBuilder("Arc runtime dispatch failed: ");
        String r111 = th.getMessage();
        if (r111 != null) goto L50;
        r111 = th.toString();
    L50:
        r110.append(r111);
        return v.d(v.c(r107, "ARC_RUNTIME_DISPATCH_FAILED", r110.toString()), r100);
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r104);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L23
        pd6.b r113 = pd6.c.f528682a;     // Catch: Throwable -> L23
        Object r114 = Result.m9449constructorimpl((b0) pd6.c.a(Reflection.getOrCreateKotlinClass(b0.class)));     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r114) == false) goto L28;
        r114 = null;
    L28:
        b0 r115 = (b0) r114;
        if (r115 == null) goto L31;
        r102.L$0 = null;     // Catch: CancellationException -> L16 Throwable -> L46
        r102.L$1 = r100;     // Catch: CancellationException -> L16 Throwable -> L46
        r102.label = 1;     // Catch: CancellationException -> L16 Throwable -> L46
        r104 = r115.q0();     // Catch: CancellationException -> L16 Throwable -> L46
        if (r104 != r105) goto L35;
        return r105;
    L35:
        r108 = null;
    L46:
        th = th;
        goto L47
    L31:
        return v.d(v.c(null, "ARC_RUNTIME_SERVICE_UNAVAILABLE", "Arc runtime service is unavailable."), r100);
    L23:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        e = move-exception;
        throw e;
    L7:
        r102 = new ArcRuntime$dispatchWithoutObservation$1(this, r101);
        goto L8
    }

    public static String c(t r100, c r101, ArcCallLifecycle r102) {
        r102.getClass();     // Catch: Throwable -> L4
        r102.a(ArcStage.FINALIZE);     // Catch: Throwable -> L4
    L37:
        d0 r103 = v.e(r100, r101);     // Catch: Throwable -> L7
    L11:
        if (r103 != null) goto L45;
        String r104 = "{\"ok\":false,\"version\":1,\"command\":\"unknown\",\"code\":\"ARC_RUNTIME_SERIALIZATION_FAILED\",\"error\":\"Arc runtime could not serialize the result.\"}";
    L39:
        r102.getClass();     // Catch: Throwable -> L35
        ArcStage r105 = ArcStage.FINALIZE;     // Catch: Throwable -> L35
        Object r106 = r102.f319839b;     // Catch: Throwable -> L35
        monitor-enter(r106);     // Catch: Throwable -> L35
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L27:
        if (r102.l() == true) goto L30;
        r102.j(r105);     // Catch: Throwable -> L32
    L30:
        monitor-exit(r106);     // Catch: Throwable -> L35
    L36:
        return r104;
    L35:
        r102.k();
        goto L36
    L45:
        wt7.c r107 = wt7.a.f561230a;     // Catch: Throwable -> L20
        juc.d<d0> r108 = d0.Companion.serializer();     // Catch: Throwable -> L20
        r107.getClass();     // Catch: Throwable -> L20
        r104 = wt7.c.b(r103, r108);     // Catch: Throwable -> L20
        if (r104 != null) goto L39;
        r102.m(ArcFrameworkFailure.FINALIZE_SERIALIZATION_FAILED);     // Catch: Throwable -> L17
    L18:
        r104 = "{\"ok\":false,\"version\":1,\"command\":\"unknown\",\"code\":\"ARC_RUNTIME_SERIALIZATION_FAILED\",\"error\":\"Arc runtime could not serialize the result.\"}";
        goto L39
    L17:
        r102.k();     // Catch: Throwable -> L20
    L22:
        r102.k();
    L23:
        r104 = "{\"ok\":false,\"version\":1,\"command\":\"unknown\",\"code\":\"ARC_RUNTIME_SERIALIZATION_FAILED\",\"error\":\"Arc runtime could not serialize the result.\"}";
    L20:
        r102.m(ArcFrameworkFailure.FINALIZE_SERIALIZATION_FAILED);     // Catch: Throwable -> L22
    L7:
        r102.m(ArcFrameworkFailure.FINALIZE_INTERNAL_ERROR);     // Catch: Throwable -> L9
    L10:
        r103 = null;
    L9:
        r102.k();
    L4:
        r102.k();
        goto L37
    }

    public final Object a(c r100, ArcCallLifecycle r101, Continuation r102) {
        if ((r102 instanceof ArcRuntime$dispatchObserved$1) == false) goto L7;
        ArcRuntime$dispatchObserved$1 r103 = (ArcRuntime$dispatchObserved$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        String r108 = null;
        if (r107 == 0) goto L20;
        if (r107 != 1) goto L19;
        r101 = (ArcCallLifecycle) r103.L$2;
        r100 = (c) r103.L$1;
        String r109 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14 CancellationException -> L16
    L39:
        m r110 = (m) r105;     // Catch: Throwable -> L14 CancellationException -> L16
    L41:
        if ((r110 instanceof m.b) == false) goto L44;
        ((m.b) r110).getClass();
        return c(null, r100, r101);
    L44:
        if (Intrinsics.areEqual(r110, m.a.f319904a) == false) goto L51;
        r101.f();     // Catch: Throwable -> L47
    L49:
        return c(v.c(r109, "ARC_RUNTIME_EMPTY_RESULT", "Arc runtime service returned an empty result."), r100, r101);
    L47:
        r101.k();
        goto L49
    L51:
        throw new NoWhenBranchMatchedException();
    L14:
        th = th;
        r108 = r109;
    L62:
        r101.e();     // Catch: Throwable -> L55
    L56:
        StringBuilder r111 = new StringBuilder("Arc runtime dispatch failed: ");
        String r112 = th.getMessage();
        if (r112 != null) goto L59;
        r112 = th.toString();
    L59:
        r111.append(r112);
        return c(v.c(r108, "ARC_RUNTIME_DISPATCH_FAILED", r111.toString()), r100, r101);
    L55:
        r101.k();
        goto L56
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r105);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L23
        pd6.b r114 = pd6.c.f528682a;     // Catch: Throwable -> L23
        Object r115 = Result.m9449constructorimpl((b0) pd6.c.a(Reflection.getOrCreateKotlinClass(b0.class)));     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r115) == false) goto L28;
        r115 = null;
    L28:
        b0 r116 = (b0) r115;
        if (r116 != null) goto L71;
        r101.g(ArcFrameworkFailure.PREPARE_RUNTIME_UNAVAILABLE);     // Catch: Throwable -> L32
    L34:
        return c(v.c(null, "ARC_RUNTIME_SERVICE_UNAVAILABLE", "Arc runtime service is unavailable."), r100, r101);
    L32:
        r101.k();
        goto L34
    L71:
        r103.L$0 = null;     // Catch: CancellationException -> L16 Throwable -> L52
        r103.L$1 = r100;     // Catch: CancellationException -> L16 Throwable -> L52
        r103.L$2 = r101;     // Catch: CancellationException -> L16 Throwable -> L52
        r103.label = 1;     // Catch: CancellationException -> L16 Throwable -> L52
        r105 = r116.q0();     // Catch: CancellationException -> L16 Throwable -> L52
        if (r105 != r106) goto L38;
        return r106;
    L38:
        r109 = null;
    L52:
        th = th;
    L23:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        e = move-exception;
        throw e;
    L7:
        r103 = new ArcRuntime$dispatchObserved$1(this, r102);
        goto L8
    }
}
