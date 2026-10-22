package com.bytedance.android.livesdk.livecommerce.saascoupon.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        com.bytedance.android.ec.core.arch.event.c.d(d.d0(this.a), new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.g("livesdk_coupon_window_click", "other_account", null, 4));
        com.bytedance.android.ec.core.arch.event.c.d(d.d0(this.a), new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.c(this.a.Y().a()));
    }
}
