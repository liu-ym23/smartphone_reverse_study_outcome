package com.bytedance.ee.bear.lark;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class i implements View.OnClickListener {
    public final /* synthetic */ DocTabFragment a;
    public final /* synthetic */ View.OnClickListener b;

    public /* synthetic */ i(DocTabFragment r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        DocTabFragment r0 = this.a;
        View.OnClickListener r1 = this.b;
        int r2 = DocTabFragment.D;
        r0.getClass();
        if (r1 == null) goto L6;
        r1.onClick(r13);
        lc5.f.j(new lc5.p(r0.fa0(), r0.m6(), "search", "search_main_view", r0.m6(), r0.aa0(), r0.W9(), r0.ba0()));
        return;
    }
}
