package ue3;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f549797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f549798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f549799c;

    public a(View r100, int r101, int r102) {
        this.f549797a = r100;
        this.f549798b = r101;
        this.f549799c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        int r102 = ((Integer) r101).intValue();
        int r103 = this.f549797a.getWidth();
        int r104 = this.f549797a.getHeight();
        View r105 = this.f549797a;
        int r106 = this.f549798b;
        int r107 = this.f549799c;
        r105.layout(r106 + r102, r107, (r106 + r102) + r103, r104 + r107);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
