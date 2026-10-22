package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.oubowu.stickyitemdecoration.StickyHeadContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements StickyHeadContainer.a {
    public final /* synthetic */ SidebarTreeView a;
    public final /* synthetic */ SidebarItemTitleRootView b;

    public h(SidebarTreeView r1, SidebarItemTitleRootView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(int r5) {
        int r6 = Math.max(r5 - this.a.getWikiAdapter().getHeaderLayoutCount(), 0);
        WikiTreeView.WikiAdapter r1 = this.a.getWikiAdapter();
        if ((r1 instanceof SidebarTreeView.SidebarTreeAdapter) == false) goto L5;
        SidebarTreeView.SidebarTreeAdapter r2 = (SidebarTreeView.SidebarTreeAdapter) r1;
    L6:
        if (r2 == null) goto L8;
        r2.F2(this.b, (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.a.getWikiUIList().a, r6), true);
    L8:
        this.b.getBackgroundView().b(this.b, this.a.getStickyHeadContainerFromXml().getMeasuredWidth(), 0);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
