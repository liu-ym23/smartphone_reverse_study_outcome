package com.ss.android.lark.message.lynxcard.message;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class q implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f432220a;

    public q(a r100) {
        this.f432220a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        LynxCardViewHolder r101 = LynxCardViewHolder.V3(r100);
        if (r101 == null) goto L6;
        this.f432220a.b(r101);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        LynxCardViewHolder r101 = LynxCardViewHolder.V3(r100);
        if (r101 == null) goto L6;
        this.f432220a.j(r101);
        return;
    }
}
