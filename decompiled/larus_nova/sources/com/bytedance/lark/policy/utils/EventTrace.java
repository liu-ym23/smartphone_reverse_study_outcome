package com.bytedance.lark.policy.utils;

import com.bytedance.lark.policy.model.ErrorCode;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class EventTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f253882a = 0;

    static {
    }

    public EventTrace() {
    }

    public static void a(final qe6.a r100) {
        Intrinsics.checkNotNullParameter(r100, ChameleonOpenTracker.ParamKey.COST);
        ke6.d.f503032a.getClass();
        ne6.e r101 = ke6.d.d();
        if (r101 == null) goto L6;
        r101.a(new EventTrace$monitorCombineTimeCost$1(r100));
        return;
    }

    public static void f(final int r100) {
        ke6.d.f503032a.getClass();
        ne6.e r101 = ke6.d.d();
        if (r101 == null) goto L6;
        r101.a(new EventTrace$monitorServerIntercept$1(r100));
        return;
    }

    public static void g(final qe6.b r100) {
        Intrinsics.checkNotNullParameter(r100, ChameleonOpenTracker.ParamKey.COST);
        ke6.d.f503032a.getClass();
        ne6.e r101 = ke6.d.d();
        if (r101 == null) goto L6;
        r101.a(new EventTrace$monitorSingleValidateCost$1(r100));
        return;
    }

    public static void h(final Map r100, final Map r101) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        Intrinsics.checkNotNullParameter(r101, "mapResult");
        ke6.d.f503032a.getClass();
        ne6.e r102 = ke6.d.d();
        if (r102 == null) goto L6;
        r102.a(new EventTrace$traceBusinessResult$1(r101, r100));
        return;
    }

    public static void b(final int r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "expression");
        ke6.d.f503032a.getClass();
        ne6.e r103 = ke6.d.d();
        if (r103 == null) goto L6;
        r103.a(new EventTrace$monitorExprEngineError$1(r100, r101, r102));
        return;
    }

    public static void d(final int r100, final String r101, final String r102, final String r103) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        ke6.d.f503032a.getClass();
        ne6.e r104 = ke6.d.d();
        if (r104 == null) goto L6;
        r104.a(new EventTrace$monitorInternalError$1(r100, r101, r103, r102));
        return;
    }

    public static void e(ErrorCode r100, String r101, String r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, "errorCode");
        Intrinsics.checkNotNullParameter(r101, "reason");
        d(r100.getCode(), r101, r102, null);
    }

    public static void c(final boolean r100, final String r101, final String r110, final String r111, final int r112) {
        Intrinsics.checkNotNullParameter(r101, "pointKey");
        Intrinsics.checkNotNullParameter(r110, "policyType");
        Intrinsics.checkNotNullParameter(r111, "fastPassType");
        ke6.d.f503032a.getClass();
        ne6.e r102 = ke6.d.d();
        if (r102 == null) goto L6;
        r102.a(new EventTrace$monitorFastPassResult$1(r100, r101, r110, r111, r112));
        return;
    }
}
