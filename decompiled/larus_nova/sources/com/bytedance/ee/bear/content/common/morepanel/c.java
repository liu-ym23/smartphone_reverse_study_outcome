package com.bytedance.ee.bear.content.common.morepanel;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonMorePanelFragment f216797a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        tt5.a.h("CommonMorePanelFragment", "onClick close()...");
        a.InterfaceC3091a r100 = this.f216797a.f216779h;
        if (r100 == null) goto L6;
        ((hw4.a) r100).a();
        return;
    }

    public c(CommonMorePanelFragment r100) {
        this.f216797a = r100;
    }
}
