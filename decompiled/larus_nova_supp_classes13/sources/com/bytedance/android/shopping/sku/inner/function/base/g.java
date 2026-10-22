package com.bytedance.android.shopping.sku.inner.function.base;

import android.app.Activity;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.common.ability.SkuCommonAbility;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public g(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        SkuCommonLog.c("SkuSelfFun-selfOpenSchema", "selfOpenSkuSchema");
        Activity r0 = this.a.P2();
        if (r0 != null) goto L5;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "localContext is null", null, null, 57));
        return;
    L5:
        SkuCommonAbility r1 = this.a.dq();
        PageFinder r2 = this.a.tS();
        com.bytedance.android.shopping.sku.common.ability.c r3 = this.a.zJ();
        if (r3 == null) goto L12;
        SkuParams r4 = r3.a();
        if (r4 == null) goto L12;
        Integer r5 = r4.getHeightPercent();
        if (r5 == null) goto L12;
        int r6 = r5.intValue();
    L13:
        r1.k(r0, r7, r2, r6);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L12:
        r6 = 73;
        goto L13
    }
}
