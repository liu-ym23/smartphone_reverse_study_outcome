package com.bytedance.android.livesdk.livecommerce.saascoupon.presenter;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.SaasCouponViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ SaasCouponPresenterV2 a;

    public f(SaasCouponPresenterV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        SaasCouponViewModel r7 = this.a.f;
        if (r7 == null) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(r7, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.g("livesdk_coupon_window_click", "get_coupon", null, 4));
    L5:
        SaasCouponPresenterV2 r8 = this.a;
        SaasCouponViewModel r0 = r8.f;
        if (r0 == null) goto L9;
        com.bytedance.android.ec.core.arch.event.c.d(r0, new com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a.h(r8.Y().a()));
        return;
    }
}
