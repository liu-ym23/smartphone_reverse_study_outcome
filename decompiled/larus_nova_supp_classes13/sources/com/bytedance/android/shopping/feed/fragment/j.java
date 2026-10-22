package com.bytedance.android.shopping.feed.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ LottieAnimationView b;
    public final /* synthetic */ VideoProductFeedFragment c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.removeAllUpdateListeners();
        this.a.removeView(this.c.s);
    }

    public j(ViewGroup r1, LottieAnimationView r2, VideoProductFeedFragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
