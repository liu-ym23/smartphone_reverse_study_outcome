package com.bytedance.ee.bear.document;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z6 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View.OnLayoutChangeListener a;
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener b;
    public final /* synthetic */ a7 c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        this.c.c.removeOnLayoutChangeListener(this.a);
        this.c.c.getViewTreeObserver().removeOnPreDrawListener(this.b);
        this.c.c.removeOnAttachStateChangeListener(this);
    }

    public z6(a7 r1, q6 r2, r6 r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
