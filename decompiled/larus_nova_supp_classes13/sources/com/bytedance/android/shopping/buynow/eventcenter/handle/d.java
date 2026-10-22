package com.bytedance.android.shopping.buynow.eventcenter.handle;

import android.content.Context;
import com.bytedance.android.shopping.buynow.controller.CheckPayStatusController;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.kmp.ec.yata.event.common.a {
    public final CheckPayStatusController a;

    public static final class a {
    }

    static {
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        Object r9 = r7.p(Reflection.getOrCreateKotlinClass(Map.class), "check_pay_status_params");
        if ((r9 instanceof Map) == true) goto L5;
        r9 = null;
    L5:
        Map r10 = (Map) r9;
        CheckPayStatusController r0 = this.a;
        r0.getClass();
        if (r10 == null) goto L8;
        Object r2 = r10.get("api_path");
    L10:
        if ((r2 instanceof String) == true) goto L12;
        r2 = null;
    L12:
        String r3 = (String) r2;
        if (r10 == null) goto L15;
        Object r11 = r10.get("params");
    L17:
        if ((r11 instanceof Map) == true) goto L19;
        r11 = null;
    L19:
        Map r12 = (Map) r11;
        if (r12 == null) goto L22;
        Map r13 = MapsKt.toMutableMap(r12);
    L24:
        if (r3 == null) goto L32;
        if (r13 == null) goto L32;
        nl.c r4 = r0.f.W90().getStaticState().a;
        if (r4 == null) goto L30;
        String r5 = r4.getQueryParam("enter_from_live_saas");
    L31:
        boolean r6 = Intrinsics.areEqual(String.valueOf(r5), "1");
        na3.g r14 = na3.g.a;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(na3.g.a(r3, r13, com.bytedance.android.shopping.buynow.utils.e.a(), com.bytedance.android.shopping.buynow.utils.e.b(r6))).subscribe(new com.bytedance.android.shopping.buynow.controller.k(r0), new com.bytedance.android.shopping.buynow.controller.l(r0)), r0.h);
    L46:
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L30:
        r5 = null;
    L32:
        BuyNowLog.d("selfPayAndCheck", "api_path or params are both null");
        com.bytedance.android.shopping.buynow.tracker.a r1 = r0.f.W90().getTracker();
        StringBuilder r16 = new StringBuilder("url == null is ");
        boolean r17 = true;
        if (r3 != null) goto L35;
    L38:
        boolean r18 = true;
    L39:
        r16.append(r18);
        r16.append(", params == null is ");
        if (r13 != null) goto L42;
    L45:
        r16.append(r17);
        com.bytedance.android.shopping.buynow.monitor.error.a.b(r1, "blank_params", r16.toString());
        goto L46
    L42:
        if (r13.isEmpty() == true) goto L45;
        r17 = false;
        goto L45
    L35:
        if (r3.length() == 0) goto L38;
        r18 = false;
        goto L39
    L22:
        r13 = null;
        goto L24
    L15:
        r11 = null;
        goto L17
    L8:
        r2 = null;
        goto L10
    }

    public d(BuyNowViewModel r2, Context r3, CheckPayStatusController r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "checkPayStatusController");
        this.a = r4;
    }
}
