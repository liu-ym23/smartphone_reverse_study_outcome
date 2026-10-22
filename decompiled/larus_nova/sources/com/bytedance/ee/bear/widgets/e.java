package com.bytedance.ee.bear.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f240201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f240202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f240203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f240204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f240205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BaseItemAnimator f240206f;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        if (this.f240202b == 0) goto L6;
        this.f240203c.setTranslationX(0.0f);
    L6:
        if (this.f240204d == 0) goto L9;
        this.f240203c.setTranslationY(0.0f);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f240205e.setListener(null);
        this.f240206f.dispatchMoveFinished(this.f240201a);
        this.f240206f.f240004i.remove(this.f240201a);
        this.f240206f.dispatchFinishedWhenDone();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        this.f240206f.dispatchMoveStarting(this.f240201a);
    }

    public e(BaseItemAnimator r100, RecyclerView.ViewHolder r101, int r102, View r103, int r104, ViewPropertyAnimator r105) {
        this.f240206f = r100;
        this.f240201a = r101;
        this.f240202b = r102;
        this.f240203c = r103;
        this.f240204d = r104;
        this.f240205e = r105;
    }
}
