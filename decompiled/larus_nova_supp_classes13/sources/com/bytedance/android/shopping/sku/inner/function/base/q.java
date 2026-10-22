package com.bytedance.android.shopping.sku.inner.function.base;

import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public q(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        SkuCommonLog.c("SkuSelfFun-selfUpdateSkipTriggers", "selfUpdateSkipTriggers");
        this.a.dq().r(r3);
        int r4 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
