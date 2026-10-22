package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ IAction b;
    public final /* synthetic */ e c;

    public d(FrameLayout r1, IAction r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.c.i.invoke(this.a, this.b);
    }
}
