package com.bytedance.ee.bear.drive.biz.preview.screen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ k a;

    public h(k r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        View r4 = this.a.c;
        if (r4 == null) goto L5;
        r4.setVisibility(0);
        k r5 = this.a;
        k.j(r5.c, r5.f);
    L5:
        View r6 = this.a.b;
        if (r6 == null) goto L9;
        r6.setVisibility(0);
        k r7 = this.a;
        k.j(r7.b, r7.g);
        return;
    }
}
