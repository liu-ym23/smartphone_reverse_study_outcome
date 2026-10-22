package com.bytedance.android.shopping.deepfeed.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedProductBannerIndicatorAnimator {
    public final b a;
    public final a b;
    public final Lazy c;
    public final com.bytedance.android.shopping.deepfeed.ui.b d;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ DeepFeedProductBannerIndicatorAnimator a;

        public a(DeepFeedProductBannerIndicatorAnimator r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a.a().removeAllUpdateListeners();
            this.a.a().removeAllListeners();
            this.a.d.j(1.0f, true);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ DeepFeedProductBannerIndicatorAnimator a;

        public b(DeepFeedProductBannerIndicatorAnimator r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a.d.j(r3.getAnimatedFraction(), false);
        }
    }

    public final ValueAnimator a() {
        return (ValueAnimator) this.c.getValue();
    }

    public final void b() {
        if (a().isRunning() == false) goto L5;
        return;
    L5:
        a().addUpdateListener(this.a);
        a().addListener(this.b);
        a().start();
    }

    public final void c() {
        a().removeAllUpdateListeners();
        a().removeAllListeners();
        a().cancel();
    }

    public DeepFeedProductBannerIndicatorAnimator(com.bytedance.android.shopping.deepfeed.ui.b r2) {
        Intrinsics.checkNotNullParameter(r2, "banner");
        this.d = r2;
        this.a = new b(this);
        this.b = new a(this);
        this.c = LazyKt.lazy(DeepFeedProductBannerIndicatorAnimator$animator$2.INSTANCE);
    }
}
