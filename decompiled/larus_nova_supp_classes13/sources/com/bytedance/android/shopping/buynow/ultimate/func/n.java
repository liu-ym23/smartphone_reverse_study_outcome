package com.bytedance.android.shopping.buynow.ultimate.func;

import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowViewModel a;

    public static final class a {
    }

    static {
    }

    public n(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r3, final Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "chainNextCallback");
        this.a.getSkuService().z(r3, new SelfToastFunction$onExecuteAsync$1(r4));
    }
}
