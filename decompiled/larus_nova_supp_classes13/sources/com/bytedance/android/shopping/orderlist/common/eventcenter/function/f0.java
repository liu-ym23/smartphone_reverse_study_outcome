package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.controller.OrderBottomBarHandler;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f0 extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;
    public final OrderBottomBarHandler b;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        OrderCommonErrorMonitorKt.c(this.a.E0(), "OrderSelfShowBottomBarFunction-doExecuteSync", new OrderSelfShowBottomBarFunction$onExecuteSync$1(this));
        int r4 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }

    public f0(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2, OrderBottomBarHandler r3) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
        this.b = r3;
    }
}
