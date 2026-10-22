package com.bytedance.android.shopping.buynow.yata.abilities;

import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k {
    public final int a;
    public final AtomicBoolean b;
    public final AtomicBoolean c;
    public final BuyNowFragment d;
    public final BuyNowViewModel e;

    public k(BuyNowFragment r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.d = r2;
        this.e = r3;
        this.a = 3;
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
    }
}
