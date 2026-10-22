package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a {
    public final /* synthetic */ SidebarTreeView a;
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j b;
    public final /* synthetic */ SidebarItemSpaceView c;

    public c(SidebarTreeView r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r2, SidebarItemSpaceView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.d.a
    public final void a(int r3, View r4) {
        WikiTreeView.b r5 = this.a.getListener();
        if (r5 == null) goto L6;
        r5.a(this.b, r3, this.c);
        return;
    }
}
