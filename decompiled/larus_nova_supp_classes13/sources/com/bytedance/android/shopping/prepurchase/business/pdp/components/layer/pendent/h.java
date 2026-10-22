package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.legacy.DragRelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements View.OnLayoutChangeListener {
    public final /* synthetic */ DragRelativeLayout a;
    public final /* synthetic */ MoreVideoComponent b;
    public final /* synthetic */ ViewGroup c;

    public h(DragRelativeLayout r1, MoreVideoComponent r2, ViewGroup r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        this.a.setEnableKeepLayout(true);
        MoreVideoComponent r10 = this.b;
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r10.O1())).b.c, r10, new i(r10));
    }
}
