package com.bytedance.android.shopping.buynow.ultimate.func;

import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowViewModel a;

    public static final class a {
    }

    static {
    }

    public o(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final void c(final com.bytedance.kmp.ec.yata.event.core.a r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r5, "chainNextCallback");
        com.bytedance.android.shopping.buynow.monitor.error.a.f(this.a.getTracker(), "runtime_error", "SelfUpdateCommonEventParamsFunction-doExecuteAsync", new SelfUpdateCommonEventParamsFunction$onExecuteAsync$1(this, r4));
        int r6 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r5.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
