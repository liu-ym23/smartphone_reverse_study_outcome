package com.bytedance.android.shopping.sku.inner.function.base;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public j(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r5, "chainNextCallback");
        Map r6 = r4.q();
        if (r6 != null) goto L5;
        r6 = MapsKt.emptyMap();
    L5:
        Object r7 = r6.get("close_type");
        if ((r7 instanceof Integer) == true) goto L8;
        r7 = null;
    L8:
        Integer r8 = (Integer) r7;
        if (r8 == null) goto L11;
        int r9 = r8.intValue();
    L12:
        this.a.close(r9);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r5.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L11:
        r9 = 0;
        goto L12
    }
}
