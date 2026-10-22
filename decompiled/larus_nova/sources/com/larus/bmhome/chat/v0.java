package com.larus.bmhome.chat;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes25.dex */
public final class v0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f310314a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    public v0(View r100) {
        this.f310314a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f310314a.removeOnAttachStateChangeListener(this);
        ViewCompat.requestApplyInsets(r100);
    }
}
