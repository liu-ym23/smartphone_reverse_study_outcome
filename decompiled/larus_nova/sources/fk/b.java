package fk;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f477553a;

    public b(e r100) {
        this.f477553a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        FrameLayout r101 = this.f477553a.f477559i;
        if (r101 != null) goto L5;
        return;
    L5:
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L13;
        float r103 = ((Float) r102).floatValue();
        if (this.f477553a.i() == false) goto L10;
        r101.setTranslationY(r101.getMeasuredHeight() * (1 - r103));
        return;
    L10:
        r101.setAlpha(r103);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
