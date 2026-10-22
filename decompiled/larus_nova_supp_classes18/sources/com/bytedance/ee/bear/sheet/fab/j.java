package com.bytedance.ee.bear.sheet.fab;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ FabItem.FabSheetItem c;
    public final /* synthetic */ FabFragment d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        this.d.g.clickItem(this.c.getId(), null);
    }

    public j(FabFragment r1, FabItem.FabSheetItem r2) {
        this.d = r1;
        this.c = r2;
    }
}
