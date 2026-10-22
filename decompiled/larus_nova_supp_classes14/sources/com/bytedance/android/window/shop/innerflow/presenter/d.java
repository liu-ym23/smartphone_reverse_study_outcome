package com.bytedance.android.window.shop.innerflow.presenter;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.p;
import kotlin.Pair;
import zq3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ ECWindowInnerFlowToolbarPresenter a;

    public d(ECWindowInnerFlowToolbarPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r0 = rp.a.a;
        if (rp.a.a(r4.getId()) == false) goto L5;
        return;
    L5:
        int r5 = com.bytedance.android.window.shop.innerflow.a.a;
        com.bytedance.android.window.shop.innerflow.a.d(this.a.D(), "cart", new Pair[0]);
        ECWindowInnerFlowToolbarPresenter r6 = this.a;
        vp3.a r1 = r6.h;
        if (r1 == null) goto L9;
        int r2 = f.a;
        String r7 = f.c(r1.a, "a1.b76473.c411713.d15548", PageFinder.via(r6.y()), null);
        p.a.openSchema(this.a.u().c(), r7);
        return;
    }
}
