package com.bytedance.android.shopping.buynow.container;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ BuyNowFragment a;

    public e(BuyNowFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.W90().getSkuService().f();
    }
}
