package com.bytedance.android.livesdk.livecommerce.playback.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ LottieAnimationView b;
    public final /* synthetic */ FrameLayout c;
    public final /* synthetic */ ExplainPlaybackGuidePresenter d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ExplainPlaybackGuidePresenter.d0(this.d);
        this.b.removeAllUpdateListeners();
        this.a.removeView(this.c);
    }

    public b(ViewGroup r1, LottieAnimationView r2, FrameLayout r3, ExplainPlaybackGuidePresenter r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
