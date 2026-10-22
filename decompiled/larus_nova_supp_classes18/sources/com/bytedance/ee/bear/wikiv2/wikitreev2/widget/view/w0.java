package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w0 implements View.OnClickListener {
    public final /* synthetic */ WikiTreeCtrlView a;
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g b;

    public w0(WikiTreeCtrlView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        WikiTreeCtrlView.d r5 = this.a.getViewDelegate();
        if (r5 == null) goto L5;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r0 = this.b;
        r5.o(r0.n, r0.m, r0.o);
    L5:
        String r6 = this.a.getSpaceId();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g r1 = this.b;
        gq5.d.b(r6, r1.m, r1.t, sbb.e.c(r1.u));
    }
}
