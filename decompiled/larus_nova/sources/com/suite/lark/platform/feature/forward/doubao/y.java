package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class y implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardDoubaoActivity f461374a;

    public y(ForwardDoubaoActivity r100) {
        this.f461374a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        int r109 = r104 - r102;
        ForwardDoubaoActivity r110 = this.f461374a;
        if (r110.f461266o == false) goto L7;
        if (r109 <= 0) goto L8;
        r110.f461261j = r109;
        return;
    L8:
        return;
    }
}
