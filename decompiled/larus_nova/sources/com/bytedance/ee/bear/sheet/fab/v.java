package com.bytedance.ee.bear.sheet.fab;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class v extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FabItem.FabSheetItem f237654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OfficeFabFragment f237655d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        this.f237655d.f237617g.clickItem(this.f237654c.getId(), null);
    }

    public v(OfficeFabFragment r100, FabItem.FabSheetItem r101) {
        this.f237655d = r100;
        this.f237654c = r101;
    }
}
