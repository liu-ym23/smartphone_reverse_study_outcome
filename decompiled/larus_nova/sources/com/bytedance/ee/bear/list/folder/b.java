package com.bytedance.ee.bear.list.folder;

import android.content.DialogInterface;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f228054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f228055b;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        DialogInterface.OnClickListener r100 = this.f228055b.f228053c;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.onClick(this.f228054a, -1);
    }

    public b(a.b r100, a r101) {
        this.f228055b = r100;
        this.f228054a = r101;
    }
}
