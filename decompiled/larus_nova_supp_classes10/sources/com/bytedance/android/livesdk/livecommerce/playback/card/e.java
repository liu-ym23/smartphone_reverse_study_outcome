package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ ExplainPlaybackCardPresenter a;

    public e(ExplainPlaybackCardPresenter r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        FrameLayout r3 = this.a.h;
        if (r3 == null) goto L6;
        r3.setVisibility(8);
        return;
    }
}
