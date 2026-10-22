package com.bytedance.android.livesdk.livecommerce.saascoupon.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ d a;

    public b(d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        com.bytedance.android.ec.core.arch.event.c.d(d.d0(this.a), new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.g("livesdk_coupon_window_click", "get_coupon", null, 4));
        com.bytedance.android.ec.core.arch.event.c.d(d.d0(this.a), new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.h(this.a.Y().a()));
    }
}
