package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.bytedance.android.ec.core.utils.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ float a;
    public final /* synthetic */ AnchorV4DetailHeadView b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        float r0 = k1.m(this.b.getContext()) / com.bytedance.android.ec.core.utils.q.a(Float.valueOf(this.a));
        float r1 = (AnchorV4DetailHeadView.b(this.b).getMeasuredHeight() * r0) - AnchorV4DetailHeadView.b(this.b).getMeasuredHeight();
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(vf4.a.b(Float.valueOf(this.a - 16.0f)), -2);
        r2.bottomMargin = (int) (vf4.a.b(12) + r1);
        AnchorV4DetailHeadView.b(this.b).setLayoutParams(r2);
        AnchorV4DetailHeadView.b(this.b).setPivotX(0.0f);
        AnchorV4DetailHeadView.b(this.b).setPivotY(0.0f);
        AnchorV4DetailHeadView.b(this.b).setScaleX(r0);
        AnchorV4DetailHeadView.b(this.b).setScaleY(r0);
        this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public k(float r1, AnchorV4DetailHeadView r2) {
        this.a = r1;
        this.b = r2;
    }
}
