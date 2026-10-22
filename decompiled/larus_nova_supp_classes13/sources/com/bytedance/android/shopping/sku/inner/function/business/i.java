package com.bytedance.android.shopping.sku.inner.function.business;

import android.app.Activity;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public i(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        SkuCommonLog.c("SkuSelfFun-selfOpenDetail", "selfOpenDetail");
        Activity r0 = this.a.P2();
        if (r0 != null) goto L6;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "localContext_is_null", null, null, 57));
        return;
    L6:
        this.a.dq().q(r0, this.a.tS(), r7);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
