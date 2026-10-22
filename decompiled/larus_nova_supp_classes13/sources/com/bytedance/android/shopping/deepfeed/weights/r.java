package com.bytedance.android.shopping.deepfeed.weights;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends AnimatorListenerAdapter {
    public final /* synthetic */ DeepFeedProductInfoMarqueeView a;

    public static final class a implements Runnable {
        public final /* synthetic */ r a;

        public a(r r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ValueAnimator r0 = this.a.a.d;     // Catch: Throwable -> L10
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isRunning() == true) goto L17;
            ValueAnimator r1 = this.a.a.d;     // Catch: Throwable -> L10
            if (r1 == null) goto L18;
            r1.start();     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public r(DeepFeedProductInfoMarqueeView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        DeepFeedProductInfoMarqueeView r5 = this.a;
        if (r5.j == false) goto L7;
        View r0 = r5.a;
        if (r0 == null) goto L10;
        r0.setTranslationY(r5.c);
    L10:
        DeepFeedProductInfoMarqueeView r6 = this.a;
        r6.j = !r6.j;
        Runnable r1 = r6.e;
        if (r1 == null) goto L13;
        r6.f.removeCallbacks(r1);
    L13:
        DeepFeedProductInfoMarqueeView r7 = this.a;
        a r2 = new a(this);
        r7.e = r2;
        Handler r8 = r7.f;
        Intrinsics.checkNotNull(r2);
        r8.postDelayed(r2, this.a.h);
        return;
    L7:
        View r3 = r5.b;
        if (r3 == null) goto L10;
        r3.setTranslationY(r5.c);
        goto L10
    }
}
