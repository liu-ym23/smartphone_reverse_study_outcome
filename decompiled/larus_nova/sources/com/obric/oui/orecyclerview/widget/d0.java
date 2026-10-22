package com.obric.oui.orecyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class d0 implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f401799a;

    public final int a() {
        return this.f401799a.getChildCount();
    }

    public d0(RecyclerView r100) {
        this.f401799a = r100;
    }

    public final void b(int r100) {
        View r101 = this.f401799a.getChildAt(r100);
        if (r101 == null) goto L5;
        RecyclerView r102 = this.f401799a;
        r102.getClass();
        RecyclerView.E(r101);
        RecyclerView.Adapter r103 = r102.f401620l;
        r101.clearAnimation();
    L5:
        this.f401799a.removeViewAt(r100);
    }
}
