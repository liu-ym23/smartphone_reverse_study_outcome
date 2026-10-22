package com.bytedance.ee.bear.list.folder;

import android.content.DialogInterface;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends CommonActionPanelLayout.b {
    public final /* synthetic */ a a;
    public final /* synthetic */ a.b b;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        DialogInterface.OnClickListener r0 = this.b.c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onClick(this.a, -1);
    }

    public b(a.b r1, a r2) {
        this.b = r1;
        this.a = r2;
    }
}
