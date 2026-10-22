package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends AnimatorListenerAdapter {
    public final /* synthetic */ k a;

    public g(k r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        View r3 = this.a.c;
        if (r3 == null) goto L5;
        k.j(r3, 0);
    L5:
        View r4 = this.a.b;
        if (r4 == null) goto L9;
        k.j(r4, 0);
        return;
    }
}
