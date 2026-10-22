package com.bytedance.android.shopping.buynow.ultimate.func;

import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p extends com.bytedance.kmp.ec.yata.event.common.b {
    public final BuyNowViewModel a;

    public static final class a {
    }

    static {
    }

    public p(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        this.a.getSkuService().r(r3);
        int r4 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
