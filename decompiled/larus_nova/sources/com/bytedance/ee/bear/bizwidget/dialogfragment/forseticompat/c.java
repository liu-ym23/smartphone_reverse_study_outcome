package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseForsetiCompatDialogFragment f216465a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public c(BaseForsetiCompatDialogFragment r100) {
        this.f216465a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        BaseForsetiCompatDialogFragment.S90(this.f216465a);
        BaseForsetiCompatDialogFragment r101 = this.f216465a;
        r101.getClass();
        r101.onDismiss(new d());
        this.f216465a.f216427f = null;
    }
}
