package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f557132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f557134c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f557133b.setTranslationY(this.f557134c);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f557133b.setTranslationY(this.f557134c);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Animator.AnimatorListener r101 = this.f557132a;
        if (r101 == null) goto L6;
        r101.onAnimationStart(r100);
        return;
    }

    public h(l.a r100, View r101, float r102) {
        this.f557132a = r100;
        this.f557133b = r101;
        this.f557134c = r102;
    }
}
