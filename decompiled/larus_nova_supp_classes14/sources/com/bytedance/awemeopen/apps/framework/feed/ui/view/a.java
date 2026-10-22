package com.bytedance.awemeopen.apps.framework.feed.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends AnimatorListenerAdapter {
    public final /* synthetic */ LongPressSpeedView a;

    public a(LongPressSpeedView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        if (LongPressSpeedView.a(this.a).getVisibility() != 8) goto L5;
        return;
    L5:
        LongPressSpeedView r5 = this.a;
        r5.i = ObjectAnimator.ofFloat(LongPressSpeedView.b(r5), "alpha", new float[]{0.2f, 0.5f, 1.0f});
        ObjectAnimator r6 = this.a.i;
        if (r6 == null) goto L9;
        r6.setDuration(800);
    L9:
        ObjectAnimator r7 = this.a.i;
        if (r7 == null) goto L13;
        r7.setRepeatCount(-1);
    L13:
        ObjectAnimator r8 = this.a.i;
        if (r8 == null) goto L17;
        r8.setRepeatMode(2);
    L17:
        ObjectAnimator r9 = this.a.i;
        if (r9 == null) goto L21;
        r9.start();
        return;
    }
}
