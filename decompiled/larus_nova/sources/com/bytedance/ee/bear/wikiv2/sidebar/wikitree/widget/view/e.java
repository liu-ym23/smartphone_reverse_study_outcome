package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemDirView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements WikItemLeafView.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SidebarItemSpaceView f241295a;

    public e(SidebarItemSpaceView r100) {
        this.f241295a = r100;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView.e
    public final void a() {
        SidebarItemSpaceView r100 = this.f241295a;
        WikItemDirView.b r101 = r100.f242216t;
        if (r101 == null) goto L6;
        r101.a(!r100.f242217u);
        return;
    }
}
