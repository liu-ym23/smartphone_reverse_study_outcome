package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends t {
    public final /* synthetic */ SidebarItemTitleRootView c;

    public b(SidebarItemTitleRootView r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        SidebarItemTitleRootView r3 = this.c;
        int r0 = SidebarItemTitleRootView.D;
        WikItemLeafView.e r4 = r3.n;
        if (r4 == null) goto L6;
        r4.a();
        return;
    }
}
