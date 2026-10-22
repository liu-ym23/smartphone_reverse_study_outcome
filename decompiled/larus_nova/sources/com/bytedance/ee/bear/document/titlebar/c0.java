package com.bytedance.ee.bear.document.titlebar;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes16.dex */
public final class c0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnLayoutChangeListener f222201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener f222202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d0 f222203c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        this.f222203c.f222209c.removeOnLayoutChangeListener(this.f222201a);
        this.f222203c.f222209c.getViewTreeObserver().removeOnPreDrawListener(this.f222202b);
        this.f222203c.f222209c.removeOnAttachStateChangeListener(this);
    }

    public c0(d0 r100, w r101, n r102) {
        this.f222203c = r100;
        this.f222201a = r101;
        this.f222202b = r102;
    }
}
