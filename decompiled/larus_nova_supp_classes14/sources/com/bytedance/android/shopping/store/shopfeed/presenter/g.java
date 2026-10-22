package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements Runnable {
    public final /* synthetic */ ECShopMomentFlowGuidePresenter a;
    public final /* synthetic */ View b;

    public g(ECShopMomentFlowGuidePresenter r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        FrameLayout r0 = this.a.g;
        if (r0 == null) goto L5;
        r0.removeAllViews();
        r0.addView(this.b);
    L5:
        ECShopMomentFlowGuidePresenter r1 = this.a;
        r1.getClass();
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r2.setDuration(3500);
        r2.addListener(new f(r1));
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(0);
        r3.addListener(new e(r1));
        AnimatorSet r4 = new AnimatorSet();
        r4.playTogether(new Animator[]{r2, r3});
        r4.start();
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
