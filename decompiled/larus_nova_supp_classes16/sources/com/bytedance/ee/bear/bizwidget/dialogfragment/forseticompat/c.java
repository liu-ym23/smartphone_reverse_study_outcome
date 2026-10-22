package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.view.animation.Animation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Animation.AnimationListener {
    public final /* synthetic */ BaseForsetiCompatDialogFragment a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public c(BaseForsetiCompatDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r2) {
        BaseForsetiCompatDialogFragment.S90(this.a);
        BaseForsetiCompatDialogFragment r3 = this.a;
        r3.getClass();
        r3.onDismiss(new d());
        this.a.f = null;
    }
}
