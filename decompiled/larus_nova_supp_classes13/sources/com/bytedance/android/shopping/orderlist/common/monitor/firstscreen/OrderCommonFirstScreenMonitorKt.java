package com.bytedance.android.shopping.orderlist.common.monitor.firstscreen;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonFirstScreenMonitorKt {
    public static final void a(final String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "task");
        final long r0 = System.currentTimeMillis();
        r3.invoke();
        Lazy r4 = OrderCommonLog.a;
        OrderCommonLog.a("OrderCommonFirstScreenMonitor", new OrderCommonFirstScreenMonitorKt$logDuration$1(r2, r0));
    }
}
