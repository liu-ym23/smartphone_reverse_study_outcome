package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ KtvAnchorLyricsDisplayView a;
    public final /* synthetic */ int b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        KtvAnchorLyricsDisplayView r3 = this.a;
        r3.I = false;
        r3.i.setEmpty();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        KtvAnchorLyricsDisplayView r3 = this.a;
        r3.I = false;
        r3.q = 0;
        r3.s = false;
        r3.setCurShowIndex(this.b);
        this.a.i.setEmpty();
        this.a.invalidate();
    }

    public c(KtvAudienceLyricsDisplayView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
