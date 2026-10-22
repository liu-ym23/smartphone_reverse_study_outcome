package com.bytedance.ee.bear.widget;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t extends CommonActionPanelLayout.b {
    public final /* synthetic */ AtFinderView.c a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void a() {
        w r0 = this.a.q;
        if (r0 == null) goto L6;
        r0.onCancel();
        return;
    }

    public t(AtFinderView.c r1) {
        this.a = r1;
    }
}
