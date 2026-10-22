package rx1;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f539779a;

    public j(g r100) {
        this.f539779a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) r100.getAnimatedValue("x")).intValue();
        int r102 = ((Integer) r100.getAnimatedValue("y")).intValue();
        this.f539779a.f539751a.a(r101, r102);
        e r103 = this.f539779a.f539752b.f539801s;
        if (r103 == null) goto L6;
        r103.d();
        return;
    }
}
