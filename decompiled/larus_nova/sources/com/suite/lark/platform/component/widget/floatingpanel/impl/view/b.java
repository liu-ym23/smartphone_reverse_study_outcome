package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatingCardContainer f460782a;

    public b(FloatingCardContainer r100) {
        this.f460782a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        FloatingCardContainer r109 = this.f460782a;
        int r110 = FloatingCardContainer.f460727h;
        r109.c(false);
    }
}
