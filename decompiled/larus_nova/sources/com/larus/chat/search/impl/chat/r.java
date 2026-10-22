package com.larus.chat.search.impl.chat;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes26.dex */
public final class r implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f325536a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    public r(View r100) {
        this.f325536a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f325536a.removeOnAttachStateChangeListener(this);
        ViewCompat.requestApplyInsets(r100);
    }
}
