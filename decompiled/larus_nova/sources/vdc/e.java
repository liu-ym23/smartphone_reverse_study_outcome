package vdc;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.d f554319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f554320b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        a.d r101 = this.f554319a;
        r101.f554303m = r101.f554296f;
        float r102 = r101.f554297g;
        r101.f554304n = r102;
        r101.f554305o = r101.f554298h;
        r101.f554302l = (r101.f554302l + 1) % r101.f554301k.length;
        r101.f554296f = r102;
        r101.a();
        a r103 = this.f554320b;
        r103.f554280f = (r103.f554280f + 1.0f) % 5.0f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        this.f554320b.f554280f = 0.0f;
    }

    public e(a r100, a.d r101) {
        this.f554320b = r100;
        this.f554319a = r101;
    }
}
