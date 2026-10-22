package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w implements View.OnAttachStateChangeListener {
    public final /* synthetic */ x a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
    }

    public w(x r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        this.a.a.c();
    }
}
