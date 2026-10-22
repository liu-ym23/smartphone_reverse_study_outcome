package xv0;

import android.view.View;
import com.bytedance.android.live.recharge.adapter.CustomRecommendPriceAdapter;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f565136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CustomRecommendPriceAdapter f565137b;

    public a(long r100, CustomRecommendPriceAdapter r101) {
        this.f565136a = r100;
        this.f565137b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CustomRecommendPriceAdapter.a r101 = this.f565137b.f89624b;
        if (r101 == null) goto L6;
        r101.Yq(this.f565136a);
        return;
    }
}
