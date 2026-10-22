package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer;

import android.view.View;
import vg3.k0;
import vg3.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LoadingComponent a;

    public b(LoadingComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        u r6 = (u) this.a.N1(u.class);
        if (r6 == null) goto L6;
        r6.v0(new k0(true, false, 6));
        return;
    }
}
