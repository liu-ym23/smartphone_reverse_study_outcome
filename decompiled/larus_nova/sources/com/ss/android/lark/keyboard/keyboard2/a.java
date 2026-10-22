package com.ss.android.lark.keyboard.keyboard2;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f429501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BasicKeyboard f429502b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        this.f429501a.removeOnAttachStateChangeListener(this);
        BasicKeyboard.Q(this.f429502b);
    }

    public a(KeyboardRootContainer r100, BasicKeyboard r101) {
        this.f429501a = r100;
        this.f429502b = r101;
    }
}
