package com.bytedance.android.shopping.sku.inner.function.base;

import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public h(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(final com.bytedance.kmp.ec.yata.event.core.a r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r5, "chainNextCallback");
        SkuCommonLog.c("SkuSelfFun-selfPollQueueEvents", "selfPollQueueEvents");
        SkuRunCatchExtKt.a(this.a.qn().getSkuParams().getMonitorId(), "SkuSelfFun-selfPollQueueEvents", new SkuYataPollQueueEvents$onExecuteAsync$1(this, r4));
        int r6 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r5.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
