package vl2;

import com.bytedance.android.livesdk.commerce.coupon.LiveCouponPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements js0.a {
    public final /* synthetic */ l.a a;

    public h(LiveCouponPresenter.c r1) {
        this.a = r1;
    }

    public final void onFail(String r1) {
        l.a r2 = this.a;
        if (r2 == null) goto L6;
        r2.onFail();
        return;
    }
}
