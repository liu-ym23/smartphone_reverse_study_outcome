package com.bytedance.applet.aibridge.baidunavi;

import android.os.SystemClock;
import com.larus.trace.RealTimeNavStartFailReason;
import com.larus.trace.RealTimeNavStartResult;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements tl9.d {
    public final /* synthetic */ StartBaiduNavigationMethod a;
    public final /* synthetic */ float b;
    public final /* synthetic */ AbsStartBaiduNavigationIDL.b c;
    public final /* synthetic */ f3.h<AbsStartBaiduNavigationIDL.c> d;

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "errorMsg");
        Long r1 = this.a.b;
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(SystemClock.elapsedRealtime() - r1.longValue());
    L6:
        String r3 = ev3.a.a;
        ev3.a.f = r2;
        ev3.a.a("errorMsg", r8);
        ev3.a.d(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.ROUTE_ERROR, null, 4);
        FLogger.a.e("js_bd_navi_start", "onPlanFailed messageLength=" + r8.length());
        f3.h.a.a(this.d, r8, null, null, 14);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void b(ul9.f r12) {
        Intrinsics.checkNotNullParameter(r12, "plan");
        Long r0 = this.a.b;
        ul9.e r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(SystemClock.elapsedRealtime() - r0.longValue());
    L6:
        String r3 = ev3.a.a;
        ev3.a.f = r2;
        String r5 = r12.b();
        List r4 = r12.a();
        if (r4 == null) goto L11;
        ul9.e r6 = (ul9.e) CollectionsKt.firstOrNull(r4);
        if (r6 == null) goto L11;
        String r7 = r6.e();
    L13:
        if (r5 == null) goto L22;
        if (r7 == null) goto L22;
        FLogger.a.i("js_bd_navi_start", "start navi after route,sessionId[" + r12.b() + ']');
        NavigationCallback r8 = NavigationCallback.l;
        if (r8 == null) goto L21;
        List r9 = r12.a();
        if (r9 == null) goto L20;
        r1 = (ul9.e) CollectionsKt.firstOrNull(r9);
    L20:
        r8.h(r1, true);
    L21:
        this.a.c(this.b, r5, r7, this.c, r12, StartBaiduNavigationMethod.d, this.d);
        return;
    L22:
        FLogger.a.e("js_bd_navi_start", "succ [" + r12.b() + "]no route");
        ev3.a.a("error", "succeed_but_no_route");
        ev3.a.d(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.ROUTE_ERROR, null, 4);
        f3.h.a.a(this.d, "no_route", null, null, 14);
        return;
    L11:
        r7 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public k(StartBaiduNavigationMethod r1, float r2, AbsStartBaiduNavigationIDL.b r3, f3.h<AbsStartBaiduNavigationIDL.c> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
