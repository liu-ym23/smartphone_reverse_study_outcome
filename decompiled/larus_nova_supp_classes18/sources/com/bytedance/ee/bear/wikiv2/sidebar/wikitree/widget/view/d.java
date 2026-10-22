package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b {
    public final /* synthetic */ SidebarTreeView a;
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;

    public d(SidebarTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.b
    public final void a(boolean r3) {
        WikiTreeView.b r0 = this.a.getListener();
        if (r0 == null) goto L6;
        r0.b(this.b, r3);
        return;
    }
}
