package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c0 extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;
    public final AndroidYaTaInstance b;

    public static final class a {
    }

    static {
    }

    public c0(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2, AndroidYaTaInstance r3) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
        this.b = r3;
    }

    public final void c(final com.bytedance.kmp.ec.yata.event.core.a r3, final Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "chainNextCallback");
        OrderCommonErrorMonitorKt.c(this.a.E0(), "OrderSelfRegisterBridgeFunction-onExecuteAsync", new OrderSelfRegisterBridgeFunction$onExecuteAsync$1(this, r3, r4));
    }
}
