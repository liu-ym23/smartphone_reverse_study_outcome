package com.ss.android.lark.widget.select;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f448437a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    public l(m r100) {
        this.f448437a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        m r101 = this.f448437a;
        r101.f448441d.getViewTreeObserver().removeOnScrollChangedListener(r101.f448455r);
        r101.h();
        r r102 = r101.f448452o;
        if (r102 == null) goto L5;
        r102.release();
        r101.f448452o = null;
    L5:
        r101.f448453p = null;
    }
}
