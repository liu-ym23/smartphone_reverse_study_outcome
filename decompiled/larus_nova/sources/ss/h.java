package ss;

import android.animation.ValueAnimator;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f543313a;

    public h(e r100) {
        this.f543313a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) r100.getAnimatedValue()).intValue();
        d r102 = this.f543313a.f543287a;
        if (r102.f543286f == true) goto L6;
        WindowManager.LayoutParams r103 = r102.f543282b;
        r103.x = r101;
        r102.f543284d = r101;
        r102.f543281a.updateViewLayout(r102.f543283c, r103);
    L6:
        this.f543313a.f543288b.getClass();
    }
}
