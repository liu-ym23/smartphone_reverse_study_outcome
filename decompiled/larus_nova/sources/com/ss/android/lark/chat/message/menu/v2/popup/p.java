package com.ss.android.lark.chat.message.menu.v2.popup;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class p implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f415900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PopupMenuRootView f415901b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f415900a.removeOnAttachStateChangeListener(this);
        this.f415901b.f415867e.setAlpha(0.0f);
        this.f415901b.f415867e.animate().alpha(1.0f).setDuration(200).start();
        PopupMenuRootView r101 = this.f415901b;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        View r104 = r101.getChildAt(r103);
        if (Intrinsics.areEqual(r104, this.f415901b.f415867e) == true) goto L7;
        r104.setAlpha(0.0f);
        r104.setScaleX(0.98f);
        r104.setScaleY(0.98f);
        r104.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public p(PopupMenuRootView r100, PopupMenuRootView r101) {
        this.f415900a = r100;
        this.f415901b = r101;
    }
}
