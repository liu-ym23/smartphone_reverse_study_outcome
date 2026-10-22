package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a a;

    public v(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r8) {
        Intrinsics.checkNotNullParameter(r8, "input");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = new Pair(Boolean.TRUE, null);
        OrderCommonErrorMonitorKt.c(this.a.E0(), "OrderCommonToTabFunction-doExecuteSync", new OrderCommonToTabFunction$onExecuteSync$1(this, r8, r0));
        if (((Boolean) ((Pair) r0.element).getFirst()).booleanValue() == false) goto L5;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L5:
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, (String) ((Pair) r0.element).getSecond(), null, null, 57);
    }
}
