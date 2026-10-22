package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.monitor.param.BuyNowOrderNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y extends com.bytedance.kmp.ec.yata.event.common.b {
    public final pa3.a a;

    public static final class a {
    }

    static {
    }

    public y(pa3.a r1) {
        this.a = r1;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        BuyNowLog.d("selfSubmitBtnClick", "selfSubmitBtnClick starts");
        pa3.a r0 = this.a;
        if (r0 == null) goto L7;
        com.bytedance.android.shopping.buynow.monitor.order.a r1 = r0.b;
        if (r1 == null) goto L7;
        r1.a(BuyNowOrderNode.INITIAL, System.currentTimeMillis());
    L7:
        pa3.a r2 = this.a;
        if (r2 == null) goto L12;
        com.bytedance.android.shopping.buynow.monitor.order.a r3 = r2.b;
        if (r3 == null) goto L12;
        r3.a(BuyNowOrderNode.ORDER_SUBMIT, System.currentTimeMillis());
    L12:
        BuyNowLog.d("selfSubmitBtnClick", "selfSubmitBtnClick finishes");
        int r6 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
