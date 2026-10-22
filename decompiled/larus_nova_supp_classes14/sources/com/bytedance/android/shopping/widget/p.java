package com.bytedance.android.shopping.widget;

import android.view.animation.Animation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p implements Animation.AnimationListener {
    public final /* synthetic */ VerticalMarqueeView a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r1) {
    }

    public p(VerticalMarqueeView r1) {
        this.a = r1;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r1) {
        Function0<Unit> r2 = this.a.c;
        if (r2 == null) goto L6;
        Unit r3 = (Unit) r2.invoke();
        return;
    }
}
