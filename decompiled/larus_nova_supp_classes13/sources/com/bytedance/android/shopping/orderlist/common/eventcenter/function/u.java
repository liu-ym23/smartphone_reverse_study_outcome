package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import android.app.Activity;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u extends com.bytedance.kmp.ec.yata.event.common.b {
    public final Activity a;
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a b;

    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        OrderCommonErrorMonitorKt.c(this.b.E0(), "OrderCommonSetStatusBarFunction-doExecuteSync", new OrderCommonSetStatusBarFunction$onExecuteSync$1(this, r3));
        int r4 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }

    public u(Activity r2, com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "ability");
        this.a = r2;
        this.b = r3;
    }
}
