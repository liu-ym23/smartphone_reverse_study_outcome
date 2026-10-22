package fcc;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.C5881c f476435a;

    public d(c.C5881c r100) {
        this.f476435a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        this.f476435a.f476432k.f476421d.scrollTo(0, ((Integer) r100.getAnimatedValue()).intValue());
    }
}
