package vdc;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.d f554315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f554316b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        a.d r101 = this.f554315a;
        r101.f554302l = (r101.f554302l + 1) % r101.f554301k.length;
        r101.f554303m = r101.f554296f;
        r101.f554304n = r101.f554297g;
        r101.f554305o = r101.f554298h;
        if (r101.f554306p == false) goto L5;
        r101.f554306p = false;
        r101.a();
    L5:
        a r102 = this.f554316b;
        r102.f554278d.startAnimation(r102.f554279e);
    }

    public c(a r100, a.d r101) {
        this.f554316b = r100;
        this.f554315a = r101;
    }
}
