package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.kmp.ec.yata.event.common.a {
    public final List<String> a;
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a b;

    public e(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.b = r2;
        this.a = new ArrayList();
    }

    public final void c(final com.bytedance.kmp.ec.yata.event.core.a r3, final Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "chainNextCallback");
        OrderCommonErrorMonitorKt.d(this.b.E0(), "OrderCommonDoOnceFunction-doExecuteASync", new OrderCommonDoOnceFunction$onExecuteAsync$1(this, r3, r4), new OrderCommonDoOnceFunction$onExecuteAsync$2(r4));
    }
}
