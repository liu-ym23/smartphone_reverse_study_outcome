package qz1;

import android.animation.Animator;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends o12.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f535229a;

    public g(e r100) {
        this.f535229a = r100;
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f535229a.run();
    }
}
