package com.bytedance.ee.bear.sheet.fab;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FabItem.FabSheetItem f237641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FabFragment f237642d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        this.f237642d.f237597g.clickItem(this.f237641c.getId(), null);
    }

    public j(FabFragment r100, FabItem.FabSheetItem r101) {
        this.f237642d = r100;
        this.f237641c = r101;
    }
}
