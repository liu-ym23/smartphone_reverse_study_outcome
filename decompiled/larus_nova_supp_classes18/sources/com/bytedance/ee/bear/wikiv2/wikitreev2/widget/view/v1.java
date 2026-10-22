package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.oubowu.stickyitemdecoration.StickyHeadContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v1 implements StickyHeadContainer.a {
    public final /* synthetic */ WikiTreeView a;

    public v1(WikiTreeView r1) {
        this.a = r1;
    }

    public final void a(int r4) {
        int r5 = Math.max(r4 - this.a.e.getHeaderLayoutCount(), 0);
        WikiTreeView r0 = this.a;
        r0.e.B2(r0.getStickyHeadFromXml(), (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.a.getWikiUIList().a, r5), true);
    }
}
