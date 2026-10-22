package com.obric.assistant;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes32.dex */
public final class i4 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f389413a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    public i4(ConstraintLayout r100) {
        this.f389413a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f389413a.removeOnAttachStateChangeListener(this);
        ViewCompat.requestApplyInsets(r100);
    }
}
