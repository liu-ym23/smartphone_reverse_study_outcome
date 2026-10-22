package vl2;

import com.bytedance.android.livesdk.commerce.coupon.LiveCouponPresenter;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements js0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l.a f555656a;

    public h(LiveCouponPresenter.c r100) {
        this.f555656a = r100;
    }

    @Override // js0.a
    public final void onFail(String r100) {
        l.a r101 = this.f555656a;
        if (r101 == null) goto L6;
        r101.onFail();
        return;
    }
}
