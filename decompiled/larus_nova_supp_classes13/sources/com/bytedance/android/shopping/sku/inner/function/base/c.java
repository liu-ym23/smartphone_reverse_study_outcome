package com.bytedance.android.shopping.sku.inner.function.base;

import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public c(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "chainNextCallback");
        SkuCommonLog.c("SkuSelfFun-selfCalCurSkuIdToUpdate", "selfCalCurSkuIdToUpdate");
        this.a.dq().j(r3, SkuYataCalCurSkuIdToUpdateFunction$onExecuteAsync$1.INSTANCE);
        int r5 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r4.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
