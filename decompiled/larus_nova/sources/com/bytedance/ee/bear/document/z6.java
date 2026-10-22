package com.bytedance.ee.bear.document;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes16.dex */
public final class z6 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnLayoutChangeListener f222557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener f222558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a7 f222559c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        this.f222559c.f218655c.removeOnLayoutChangeListener(this.f222557a);
        this.f222559c.f218655c.getViewTreeObserver().removeOnPreDrawListener(this.f222558b);
        this.f222559c.f218655c.removeOnAttachStateChangeListener(this);
    }

    public z6(a7 r100, q6 r101, r6 r102) {
        this.f222559c = r100;
        this.f222557a = r101;
        this.f222558b = r102;
    }
}
