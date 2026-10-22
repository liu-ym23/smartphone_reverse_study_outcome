package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements WikItemLeafView.e {
    public final /* synthetic */ SidebarItemSpaceView a;

    public e(SidebarItemSpaceView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView.e
    public final void a() {
        SidebarItemSpaceView r0 = this.a;
        WikItemDirView.b r1 = r0.t;
        if (r1 == null) goto L6;
        r1.a(!r0.u);
        return;
    }
}
