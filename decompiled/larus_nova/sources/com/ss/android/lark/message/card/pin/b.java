package com.ss.android.lark.message.card.pin;

import android.view.ViewTreeObserver;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f431910a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f431910a.f431916d.getMeasuredHeight() < UIHelper.dp2px(240.0f)) goto L5;
        this.f431910a.f431919g.setVisibility(0);
    L5:
        this.f431910a.f431916d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    public b(d r100) {
        this.f431910a = r100;
    }
}
