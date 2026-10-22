package no1;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animation.AnimationListener f519890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f519891b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        Animation.AnimationListener r101 = this.f519890a;
        if (r101 == null) goto L5;
        r101.onAnimationEnd(r100);
    L5:
        this.f519891b.b(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
        Animation.AnimationListener r101 = this.f519890a;
        if (r101 == null) goto L6;
        r101.onAnimationRepeat(r100);
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        Animation.AnimationListener r101 = this.f519890a;
        if (r101 == null) goto L6;
        r101.onAnimationStart(r100);
        return;
    }

    public f(g r100, Animation.AnimationListener r101) {
        this.f519891b = r100;
        this.f519890a = r101;
    }
}
