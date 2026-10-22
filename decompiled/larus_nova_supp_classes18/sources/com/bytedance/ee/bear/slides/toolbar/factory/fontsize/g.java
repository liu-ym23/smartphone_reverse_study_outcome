package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.edit_toolbar.ToolbarV2PanelViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements i {
    public final /* synthetic */ d a;
    public final /* synthetic */ an4.b b;

    @Override // com.bytedance.ee.bear.slides.toolbar.factory.fontsize.i
    public final void a(int r5) {
        d r0 = this.a;
        an4.b r1 = this.b;
        String r6 = String.valueOf(r5);
        r0.getClass();
        tt5.a.h("FontSizeToolbarFactory", "processOnItemClick " + r6);     // Catch: Exception -> L5
        q.c(r1.getPluginHost(), ToolbarV2PanelViewModel.class, null).processSubToolbarItemClick(c.a, r6, 3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d("FontSizeToolbarFactory", e.getMessage());
    }

    public g(d r1, an4.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
