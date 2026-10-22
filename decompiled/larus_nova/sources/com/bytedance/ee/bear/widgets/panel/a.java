package com.bytedance.ee.bear.widgets.panel;

import com.bytedance.ee.bear.facade.common.widget.d;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonActionPanelLayout f240303a;

    public a(CommonActionPanelLayout r100) {
        this.f240303a = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d.b
    public final void a(int r100) {
        if (r100 != 0) goto L7;
        CommonActionPanelLayout.a r101 = this.f240303a.f240268d;
        if (r101 == null) goto L8;
        r101.d();
        return;
    L8:
        return;
    }
}
