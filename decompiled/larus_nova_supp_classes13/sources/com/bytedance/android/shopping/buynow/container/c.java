package com.bytedance.android.shopping.buynow.container;

import android.view.View;
import com.bytedance.android.ec.local.api.buynow.OpenDebugPanelSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ BuyNowFragment a;

    public c(BuyNowFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.W90().getStaticState().c();
        OpenDebugPanelSource r2 = OpenDebugPanelSource.YATA;
        cl.d r3 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r3 == null) goto L6;
        r3.b();
        return;
    }
}
