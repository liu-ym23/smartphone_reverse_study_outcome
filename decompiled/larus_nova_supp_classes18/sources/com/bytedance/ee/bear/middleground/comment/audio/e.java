package com.bytedance.ee.bear.middleground.comment.audio;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ RecordPanelView b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        RecordPanelView.b(this.b, this.a);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        super.onAnimationStart(r3);
        ImageView r0 = null;
        if (this.a == false) goto L9;
        ImageView r4 = this.b.d;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("pause");
    L8:
        r0.setVisibility(0);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        ImageView r5 = this.b.c;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("play");
    L13:
        r0.setVisibility(0);
        return;
    L12:
        r0 = r5;
        goto L13
    }

    public e(boolean r1, RecordPanelView r2) {
        this.a = r1;
        this.b = r2;
    }
}
