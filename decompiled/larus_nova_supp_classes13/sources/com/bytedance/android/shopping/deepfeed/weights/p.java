package com.bytedance.android.shopping.deepfeed.weights;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements Runnable {
    public final /* synthetic */ DeepFeedProductInfoMarqueeView a;

    public p(DeepFeedProductInfoMarqueeView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoMarqueeView] */
    public final void a() {
        ?? r0 = this.a;
        View r1 = r0.a;
        View r2 = r0.b;
        if (r1 == null) goto L5;
        int r3 = r1.getHeight();
    L6:
        r0.c = r3;
        if (r1 == null) goto L24;
        if (r2 == null) goto L24;
        if (DeepFeedProductInfoMarqueeView.T5(r1) == false) goto L24;
        if (DeepFeedProductInfoMarqueeView.T5(r2) == false) goto L24;
        if (r1.getVisibility() != 0) goto L24;
        if (r2.getVisibility() != 0) goto L24;
        if (r0.c <= 0) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == false) goto L38;
        ValueAnimator r5 = r0.d;
        if (r5 == null) goto L31;
        if (r5.isRunning() != true) goto L31;
        return;
    L31:
        if (r0.i == false) goto L40;
        ValueAnimator r6 = r0.d;
        if (r6 == null) goto L36;
        r6.cancel();
    L36:
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{0.0f, -r0.c});
        r7.setDuration(r0.g);
        r7.setInterpolator(new LinearInterpolator());
        r7.addUpdateListener(new q(r0));
        r7.addListener(new r(r0));
        Unit r8 = Unit.INSTANCE;
        r0.d = r7;
        r7.start();
        return;
    L40:
        return;
    L38:
        return;
    L24:
        r4 = false;
        goto L25
    L5:
        r3 = r0.getHeight();
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
