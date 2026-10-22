package com.bytedance.android.shopping.orderlist.common.controller;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonPageConfig {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(OrderCommonPageConfig$splitService$2.INSTANCE);
    }

    public static boolean a() {
        nj.d r0 = (nj.d) a.getValue();
        if (r0 == null) goto L7;
        r0.isFold();
        return false;
    L7:
        return false;
    }

    public static com.bytedance.android.ecom.arch.slice.render.context.b b(boolean r7) {
        a();
        ECAppInfoService r0 = ECAppInfoService.e;
        float r2 = 1.0f;
        int r3 = 0;
        if (com.bytedance.android.shopping.extensions.k.e(r0.getCurrentFontScale(), 1.0f) < 1.15f) goto L5;
        boolean r1 = true;
    L6:
        Lazy r5 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonPageConfig", OrderCommonPageConfig$getSlcDisplayMetrics$1.INSTANCE);
        com.bytedance.android.ecom.arch.slice.render.context.b.a r6 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        if (r1 == false) goto L11;
        Float r8 = r0.getCurrentFontScale();
        if (r8 == null) goto L11;
        float r9 = r8.floatValue();
    L12:
        if (r1 == true) goto L14;
    L16:
        if (r7 == false) goto L21;
        nj.d r10 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r10 == null) goto L20;
        r10.getSpiltWidth();
    L22:
        r6.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.b(375.0f, r2, r9, r3);
    L20:
        r3 = 360;
        goto L22
    L21:
        r3 = -1;
        goto L22
    L14:
        if (com.bytedance.android.shopping.extensions.k.d(r0.getCurrentFontScale()) <= 1.15f) goto L16;
        r2 = 1.15f;
    L11:
        r9 = 1.0f;
        goto L12
    L5:
        r1 = false;
        goto L6
    }
}
