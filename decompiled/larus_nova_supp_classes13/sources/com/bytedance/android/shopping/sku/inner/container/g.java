package com.bytedance.android.shopping.sku.inner.container;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ SkuFullScreenFragment a;

    public g(SkuFullScreenFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.close(0);
    }
}
