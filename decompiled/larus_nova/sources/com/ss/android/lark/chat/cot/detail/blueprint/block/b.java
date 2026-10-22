package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f414925a;

    public b(c r100) {
        this.f414925a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        c r109 = this.f414925a;
        String r110 = r109.f414931f;
        if (r110 != null) goto L5;
        return;
    L5:
        int r111 = r103 - r101;
        if (r111 > 0) goto L8;
        return;
    L8:
        r109.f414931f = null;
        r109.d(r110, com.ss.android.lark.movable.utils.b.f(r111, r109.f414926a.getContext()));
    }
}
