package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.View;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import vg3.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v implements View.OnClickListener {
    public final /* synthetic */ PdpRootComponent a;

    public v(PdpRootComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        this.a.v0(new k0(true, false, 6));
        s0.a(new jd3.h());
        s0.a(new com.bytedance.android.shopping.feed.event.y(PageScrollStatus.slide));
    }
}
