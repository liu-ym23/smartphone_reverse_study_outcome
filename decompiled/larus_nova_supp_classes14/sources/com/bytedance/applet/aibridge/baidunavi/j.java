package com.bytedance.applet.aibridge.baidunavi;

import android.os.SystemClock;
import com.bytedance.applet.aibridge.baidunavi.bean.NavigationVerbalMode;
import com.larus.navigation.api.baidu.BaiduNaviServiceDelegate;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.trace.RealTimeNavStartFailReason;
import com.larus.trace.RealTimeNavStartResult;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements e.a {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ long b;
    public final /* synthetic */ f3.h<AbsStartBaiduNavigationIDL.c> c;
    public final /* synthetic */ dv3.e d;
    public final /* synthetic */ Float e;
    public final /* synthetic */ AbsStartBaiduNavigationIDL.b f;
    public final /* synthetic */ Pair<Integer, Integer> g;
    public final /* synthetic */ StartBaiduNavigationMethod h;

    @Override // com.bytedance.applet.aibridge.baidunavi.e.a
    public final void a(GeoLocationInfo r21) {
        Intrinsics.checkNotNullParameter(r21, "lastGeoLocation");
        Lazy r1 = e.a;
        Intrinsics.checkNotNullParameter(this, "callback");
        String r3 = null;
        if (Intrinsics.areEqual(e.m, this) == false) goto L6;
        e.m = null;
    L6:
        Ref.BooleanRef r2 = this.a;
        if (r2.element == true) goto L9;
        return;
    L9:
        r2.element = false;
        String r4 = ev3.a.a;
        ev3.a.e = Long.valueOf(SystemClock.elapsedRealtime() - this.b);
        ul9.a r12 = new ul9.a(r21.getLatitude(), r21.getLongitude(), 0.0d);
        ul9.a r7 = new ul9.a(this.d.b().a(), this.d.b().b(), 0.0d);
        int r8 = (int) this.e.floatValue();
        Integer r5 = this.f.getRidingRoutePrefer();
        if (r5 != null) goto L14;
        r5 = this.f.getDrivingRoutePrefer();
        if (r5 != null) goto L14;
        int r9 = 0;
    L16:
        Integer r6 = this.f.getVerbalMode();
        if (r6 == null) goto L31;
        NavigationVerbalMode.a r10 = NavigationVerbalMode.Companion;
        int r11 = r6.intValue();
        r10.getClass();
        if (r11 != 0) goto L21;
        r3 = "simple";
    L28:
        if (r3 == null) goto L31;
        String r13 = r3;
    L32:
        ul9.g r14 = new ul9.g(r12, r7, r8, r9, r13, this.g, this.d.c(), this.d.a(), 768);
        FLogger.a.i("js_bd_navi_start", "routePlan by the start from continuous locating");
        StartBaiduNavigationMethod r15 = this.h;
        r15.b = Long.valueOf(SystemClock.elapsedRealtime());
        BaiduNaviServiceDelegate r16 = BaiduNaviServiceDelegate.b;
        StartBaiduNavigationMethod r17 = this.h;
        float r18 = this.e.floatValue();
        AbsStartBaiduNavigationIDL.b r19 = this.f;
        f3.h<AbsStartBaiduNavigationIDL.c> r20 = this.c;
        r17.getClass();
        r16.j(r14, new k(r17, r18, r19, r20));
        return;
    L21:
        if (r11 != 1) goto L23;
        r3 = "simple_v2";
        goto L28
    L23:
        if (r11 != 2) goto L28;
        r3 = "standard";
    L31:
        r13 = "standard";
    L14:
        r9 = r5.intValue();
        goto L16
    }

    @Override // com.bytedance.applet.aibridge.baidunavi.e.a
    public final void onFailed(int r7) {
        if (r7 != 0) goto L12;
        Lazy r0 = e.a;
        Intrinsics.checkNotNullParameter(this, "callback");
        if (Intrinsics.areEqual(e.m, this) == false) goto L7;
        e.m = null;
    L7:
        Ref.BooleanRef r1 = this.a;
        if (r1.element == true) goto L10;
        return;
    L10:
        r1.element = false;
        String r2 = ev3.a.a;
        ev3.a.e = Long.valueOf(SystemClock.elapsedRealtime() - this.b);
        ev3.a.a("get_origin_error_code", String.valueOf(r7));
        ev3.a.d(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.GET_ORIGIN_ERROR, null, 4);
        FLogger.a.i("js_bd_navi_start", "routePlan fails because continuous locating fails, code[" + r7 + ']');
        f3.h<AbsStartBaiduNavigationIDL.c> r8 = this.c;
        Intrinsics.checkNotNullParameter(AbsStartBaiduNavigationIDL.c.class, "<this>");
        AbsStartBaiduNavigationIDL.c r3 = k3.c.a(AbsStartBaiduNavigationIDL.c.class);
        AbsStartBaiduNavigationIDL.c r4 = r3;
        r4.setStatusType("biz");
        r4.setStatus(1);
        f3.h.a.b(r8, r3);
        return;
    }

    public j(Ref.BooleanRef r1, long r2, f3.h<AbsStartBaiduNavigationIDL.c> r4, dv3.e r5, Float r6, AbsStartBaiduNavigationIDL.b r7, Pair<Integer, Integer> r8, StartBaiduNavigationMethod r9) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
