package vfc;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f554654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f554655b;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        RelativeLayout.LayoutParams r101 = (RelativeLayout.LayoutParams) this.f554654a.getLayoutParams();
        r101.topMargin = (int) (((Float) r100.getAnimatedValue()).floatValue() * this.f554655b);
        this.f554654a.setLayoutParams(r101);
    }

    public n(View r100, int r101) {
        this.f554654a = r100;
        this.f554655b = r101;
    }
}
