package com.bytedance.ee.bear.lark;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocTabFragment f227430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f227431b;

    public /* synthetic */ i(DocTabFragment r100, g r101) {
        this.f227430a = r100;
        this.f227431b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        DocTabFragment r100 = this.f227430a;
        View.OnClickListener r101 = this.f227431b;
        int r102 = DocTabFragment.D;
        r100.getClass();
        if (r101 == null) goto L6;
        r101.onClick(r110);
        lc5.f.j(new lc5.p(r100.fa0(), r100.m6(), "search", "search_main_view", r100.m6(), r100.aa0(), r100.W9(), r100.ba0()));
        return;
    }
}
