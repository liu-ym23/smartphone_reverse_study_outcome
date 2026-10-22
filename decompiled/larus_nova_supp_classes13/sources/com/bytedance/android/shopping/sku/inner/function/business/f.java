package com.bytedance.android.shopping.sku.inner.function.business;

import android.content.Context;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public f(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        SkuCommonLog.c("SkuSelfFun-selfClickConfirmButton", "selfClickConfirmButton");
        Context r0 = this.a.context();
        if (r0 != null) goto L6;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "localContext_is_null", null, null, 57));
        return;
    L6:
        Map<String, ? extends Object> r10 = r7.q();
        if (r10 != null) goto L9;
        r10 = MapsKt.emptyMap();
    L9:
        com.bytedance.android.shopping.sku.common.ability.c r1 = this.a.zJ();
        if (r1 == null) goto L12;
        r1.i(r0, this.a.tS(), r10);
    L12:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
