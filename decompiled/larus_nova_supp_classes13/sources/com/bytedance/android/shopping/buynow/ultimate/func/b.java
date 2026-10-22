package com.bytedance.android.shopping.buynow.ultimate.func;

import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowViewModel a;
    public final BuyNowFragment b;

    public static final class a {
    }

    static {
    }

    public b(BuyNowViewModel r2, BuyNowFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "buyNowViewModel");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.a = r2;
        this.b = r3;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "chainNextCallback");
        this.a.getSkuService().j(r3, new SelfCalCurIdFunction$onExecuteAsync$1(this));
        int r5 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r4.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
