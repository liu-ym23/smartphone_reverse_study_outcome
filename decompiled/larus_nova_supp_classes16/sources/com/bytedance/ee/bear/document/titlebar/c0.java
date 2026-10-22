package com.bytedance.ee.bear.document.titlebar;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View.OnLayoutChangeListener a;
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener b;
    public final /* synthetic */ d0 c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        this.c.c.removeOnLayoutChangeListener(this.a);
        this.c.c.getViewTreeObserver().removeOnPreDrawListener(this.b);
        this.c.c.removeOnAttachStateChangeListener(this);
    }

    public c0(d0 r1, w r2, n r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
