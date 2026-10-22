package zs1;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f573462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.coupon.balancecoupon.model.a f573463b;

    public c(i r100, com.bytedance.android.livesdk.coupon.balancecoupon.model.a r101) {
        this.f573462a = r100;
        this.f573463b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f573462a.b(this.f573463b);
    }
}
