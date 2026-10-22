package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;

    public m(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        OrderCommonErrorMonitorKt.c(this.a.E0(), "OrderCommonQuitSplitContainer-doExecuteSync", new OrderCommonQuitSplitContainer$onExecuteSync$1(this));
        int r4 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
