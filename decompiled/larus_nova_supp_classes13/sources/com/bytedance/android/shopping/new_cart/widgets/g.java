package com.bytedance.android.shopping.new_cart.widgets;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements Runnable {
    public final /* synthetic */ ECCartLoadingView a;

    public g(ECCartLoadingView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [android.view.ViewGroup, com.bytedance.android.shopping.new_cart.widgets.ECCartLoadingView] */
    public final void a() {
        Context r0 = this.a.getContext();
        Intrinsics.checkNotNullParameter(r0, "$this$isActivityAlive");
        if ((r0 instanceof Activity) == false) goto L9;
        Activity r1 = (Activity) r0;
        if (r1.isFinishing() == true) goto L9;
        if (r1.isDestroyed() == true) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        dm.a.a("ECCartLoadingView").i("activity is not alive,clearValueAnimator");
        this.a.U5();
        return;
    L14:
        this.a.setVisibility(0);
        if (this.a.h.get() == false) goto L22;
        dm.a.a("ECCartLoadingView").i("wireFrame startLoading");
        ExtensionsKt.visible(ECCartLoadingView.T5(this.a));
        ExtensionsKt.gone(ECCartLoadingView.S5(this.a));
        ECCartLoadingView.R5(this.a).stopAnimate();
        this.a.U5();
        ?? r3 = this.a;
        r3.k = r3.findViewById(2131386221);
        View r4 = this.a.k;
        if (r4 == null) goto L19;
        r4.clearAnimation();
    L19:
        ECCartLoadingView r5 = this.a;
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r6.setDuration(800);
        r6.setRepeatCount(-1);
        r6.setRepeatMode(1);
        r6.addUpdateListener(new n(this.a));
        Unit r7 = Unit.INSTANCE;
        r5.j = r6;
        ValueAnimator r8 = this.a.j;
        if (r8 == null) goto L24;
        r8.start();
        return;
    L24:
        return;
    L22:
        ExtensionsKt.gone(ECCartLoadingView.T5(this.a));
        ExtensionsKt.visible(ECCartLoadingView.S5(this.a));
        ExtensionsKt.visible(ECCartLoadingView.R5(this.a));
        ECCartLoadingView.R5(this.a).startAnimate();
        return;
    L9:
        r2 = false;
        goto L11
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
