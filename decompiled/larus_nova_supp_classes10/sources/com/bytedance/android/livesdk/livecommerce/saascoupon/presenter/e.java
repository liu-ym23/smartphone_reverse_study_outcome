package com.bytedance.android.livesdk.livecommerce.saascoupon.presenter;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.SaasCouponViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ SaasCouponPresenterV2 a;

    public e(SaasCouponPresenterV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        SaasCouponViewModel r7 = this.a.f;
        if (r7 == null) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(r7, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.g("livesdk_coupon_window_click", "cancel", null, 4));
    L5:
        SaasCouponViewModel r8 = this.a.f;
        if (r8 == null) goto L8;
        com.bytedance.android.ec.core.arch.event.c.d(r8, com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.e.a);
    L8:
        SaasCouponViewModel r9 = this.a.f;
        if (r9 == null) goto L12;
        com.bytedance.android.ec.core.arch.event.c.d(r9, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.b(false));
        return;
    }
}
