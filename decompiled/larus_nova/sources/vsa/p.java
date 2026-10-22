package vsa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class p extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator.AnimatorListener f557160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f557162c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f557161b.setScaleY(this.f557162c);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f557161b.setScaleY(this.f557162c);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Animator.AnimatorListener r101 = this.f557160a;
        if (r101 == null) goto L6;
        r101.onAnimationStart(r100);
        return;
    }

    public p(f.a r100, View r101, float r102) {
        this.f557160a = r100;
        this.f557161b = r101;
        this.f557162c = r102;
    }
}
