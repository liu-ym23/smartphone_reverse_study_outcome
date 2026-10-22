package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f557121a;

    public d(jsa.d r100) {
        this.f557121a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Animator.AnimatorListener r101 = this.f557121a;
        if (r101 == null) goto L6;
        r101.onAnimationEnd(r100);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Animator.AnimatorListener r101 = this.f557121a;
        if (r101 == null) goto L6;
        r101.onAnimationStart(r100);
        return;
    }
}
