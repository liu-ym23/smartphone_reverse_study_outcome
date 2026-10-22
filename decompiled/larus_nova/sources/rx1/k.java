package rx1;

import android.animation.ValueAnimator;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f539780a;

    public k(g r100) {
        this.f539780a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        int r101 = ((Integer) r100.getAnimatedValue()).intValue();
        f r102 = this.f539780a.f539751a;
        if (r102.f539750f == true) goto L6;
        WindowManager.LayoutParams r103 = r102.f539746b;
        r103.x = r101;
        r102.f539748d = r101;
        r102.f539745a.updateViewLayout(r102.f539747c, r103);
    L6:
        g r104 = this.f539780a;
        e r105 = r104.f539752b.f539801s;
        if (r105 == null) goto L10;
        int r106 = r104.f539751a.f539749e;
        r105.d();
        return;
    }
}
