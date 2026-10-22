package qfc;

import android.animation.Animator;

/* JADX INFO: loaded from: classes38.dex */
public final class o implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f532807a;

    public o(w r100) {
        this.f532807a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f532807a.f532837t = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f532807a.f532837t = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        this.f532807a.f532837t = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f532807a.f532837t = true;
    }
}
