package com.bytedance.android.shopping.buynow.ultimate.func;

import android.content.Context;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowFragment a;

    public static final class a {
    }

    static {
    }

    public q(BuyNowFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        Context r0 = this.a.getContext();
        if (r0 != null) goto L6;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "context is null", null, null, 57));
        return;
    L6:
        this.a.W90().getSkuService().h(r0, r7);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
