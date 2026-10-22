package com.bytedance.android.shopping.sku.inner.container;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ SkuFullScreenFragment a;

    public h(SkuFullScreenFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        SkuFullScreenFragment r3 = this.a;
        int r0 = SkuFullScreenFragment.t;
        if (r3.W90() == true) goto L6;
        this.a.close(0);
        return;
    }
}
