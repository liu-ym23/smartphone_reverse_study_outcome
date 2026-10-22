package com.bytedance.android.shopping.buynow.container;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ BuyNowFragment a;
    public final /* synthetic */ Context b;

    public g(BuyNowFragment r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        com.bytedance.android.shopping.buynow.controller.f.b(this.b, BuyNowCloseMethod.CLICK_RIGHT, this.a);
    }
}
