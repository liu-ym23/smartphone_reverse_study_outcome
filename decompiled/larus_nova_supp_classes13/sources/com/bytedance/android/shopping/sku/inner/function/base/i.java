package com.bytedance.android.shopping.sku.inner.function.base;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.shopping.sku.common.ability.SkuCommonAbility;
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

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r10, "chainNextCallback");
        SkuCommonLog.c("SkuSelfFun-selfPreviewImg", "selfPreviewImg");
        Activity r2 = this.a.P2();
        if (r2 != null) goto L5;
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "localContext is null", null, null, 57));
        return;
    L5:
        SkuCommonAbility r1 = this.a.dq();
        com.bytedance.android.shopping.sku.inner.container.b r4 = this.a;
        com.bytedance.kmp.ec.yata.common.platform.o r0 = r9.d.b;
        if (r0 == null) goto L9;
        View r3 = r0.a;
        if (r3 == null) goto L9;
    L10:
        r1.t(r2, r4, r4, r9, r3, new SkuYataPreviewImgFunction$onExecuteAsync$1(this));
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r10.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L9:
        r3 = r4.i();
        Intrinsics.checkNotNull(r3);
        goto L10
    }
}
