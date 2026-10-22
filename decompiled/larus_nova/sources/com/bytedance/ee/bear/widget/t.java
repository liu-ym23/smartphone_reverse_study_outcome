package com.bytedance.ee.bear.widget;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class t extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtFinderView.c f239956a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void a() {
        w r100 = this.f239956a.f239889q;
        if (r100 == null) goto L6;
        r100.onCancel();
        return;
    }

    public t(AtFinderView.c r100) {
        this.f239956a = r100;
    }
}
