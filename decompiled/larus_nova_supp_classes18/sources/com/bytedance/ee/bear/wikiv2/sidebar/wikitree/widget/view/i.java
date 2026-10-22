package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements koa.a {
    public final /* synthetic */ SidebarTreeView a;

    public final void b() {
        this.a.getStickyHeadContainerFromXml().c = Integer.MIN_VALUE;
        this.a.getStickyHeadContainerFromXml().setVisibility(4);
    }

    public i(SidebarTreeView r1) {
        this.a = r1;
    }

    public final void a(int r2) {
        this.a.getStickyHeadContainerFromXml().setVisibility(0);
    }
}
