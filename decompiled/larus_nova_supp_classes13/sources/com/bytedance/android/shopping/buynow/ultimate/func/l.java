package com.bytedance.android.shopping.buynow.ultimate.func;

import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowFragment a;

    public static final class a {
    }

    static {
    }

    public l(BuyNowFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "chainNextCallback");
        this.a.W90().getSkuService().p(r3, new SelfSaveSpecShowModeFunction$onExecuteAsync$1(this));
        int r5 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r4.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
