package com.bytedance.android.shopping.sku.inner.function.business;

import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public d(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        if (this.a.qn().getStaticState().d == null) goto L5;
        this.a.qn().getStaticState().d = null;
        SkuCommonLog.c("SkuYataCancelStashedClickEventFunction", "SkuYataCancelStashedClickEventFunction success");
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        SkuCommonLog.c("SkuYataCancelStashedClickEventFunction", "SkuYataCancelStashedClickEventFunction fail");
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, "check_error", null, null, 57));
    }
}
