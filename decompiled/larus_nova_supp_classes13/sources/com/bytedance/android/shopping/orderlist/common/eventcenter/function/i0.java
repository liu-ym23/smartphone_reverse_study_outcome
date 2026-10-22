package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i0 extends com.bytedance.kmp.ec.yata.event.common.b {

    public static final class a {
    }

    static {
    }

    public i0() {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("selfUpdateCustomFields", new OrderSelfUpdateCustomFieldFunction$onExecuteSync$1(r5));
        com.bytedance.kmp.ec.yata.store.node.c r1 = r5.j();
        if (r1 == null) goto L10;
        Object r6 = r5.y();
        if ((r6 instanceof Map) == true) goto L7;
        r6 = null;
    L7:
        Map r7 = (Map) r6;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r2 = r1.b.b;
        if (r2 == null) goto L10;
        com.bytedance.kmp.ec.yata.common.protocol.data.q.d(r2, r7);
    L10:
        OrderCommonLog.a("selfUpdateCustomFields", OrderSelfUpdateCustomFieldFunction$onExecuteSync$2.INSTANCE);
        int r8 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
