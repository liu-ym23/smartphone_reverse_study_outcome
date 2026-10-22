package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.store.home.entity.ECShopCartInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ ECShopFloatCartEntryPresenterV2.d a;
    public final /* synthetic */ ECShopCartInfo b;

    public b0(ECShopFloatCartEntryPresenterV2.d r1, ECShopCartInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ((z3) this.a.a.g.getValue()).onClick();
        int r5 = com.bytedance.android.ec.store.utils.b.a;
        String r6 = com.bytedance.android.ec.store.utils.b.b(this.b.getCartSchema(), "a1.b6269.c2429.d72866", PageFinder.via(this.a.a.y()), null);
        if (r6 != null) goto L5;
        return;
    L5:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.a.u().c(), r6);
    }
}
