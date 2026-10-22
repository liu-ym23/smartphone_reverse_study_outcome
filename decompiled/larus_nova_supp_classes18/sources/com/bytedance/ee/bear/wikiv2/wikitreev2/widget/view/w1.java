package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w1 implements WikItemLeafView.e {
    public final /* synthetic */ WikiTreeView a;

    public w1(WikiTreeView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView.e
    public final void a() {
        WikiHomePageV2 r0 = this.a.u;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isValid() == true) goto L9;
        tt5.a.k("Wiki_WikiTreeRvView", "WikiTreeView.initStickyHeadView, homePageV2 invalid. ");
        return;
    L9:
        WikiTreeView r1 = this.a;
        String r2 = r0.wikiToken;
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        r1.k(r2, "");
        this.a.h();
        this.a.e.notifyDataSetChanged();
        WikiTreeView.b r3 = this.a.getListener();
        if (r3 == null) goto L16;
        r3.d(r0);
        return;
    }
}
