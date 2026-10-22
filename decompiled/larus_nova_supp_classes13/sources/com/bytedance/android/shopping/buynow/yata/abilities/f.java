package com.bytedance.android.shopping.buynow.yata.abilities;

import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements v96.c {
    public final BuyNowViewModel a;

    public f(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final void a(com.bytedance.kmp.ec.yata.common.error.d r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        if (this.a.getYataInstance() == null) goto L6;
        com.bytedance.android.shopping.buynow.monitor.error.a.a(null, "yata_error", r4.a + ' ' + r4.b, r4.f());
        return;
    }
}
