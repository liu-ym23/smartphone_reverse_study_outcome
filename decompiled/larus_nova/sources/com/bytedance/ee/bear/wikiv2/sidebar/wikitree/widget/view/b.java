package com.bytedance.ee.bear.wikiv2.sidebar.wikitree.widget.view;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SidebarItemTitleRootView f241289c;

    public b(SidebarItemTitleRootView r100) {
        this.f241289c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        SidebarItemTitleRootView r101 = this.f241289c;
        int r102 = SidebarItemTitleRootView.D;
        WikItemLeafView.e r103 = r101.f242235n;
        if (r103 == null) goto L6;
        r103.a();
        return;
    }
}
