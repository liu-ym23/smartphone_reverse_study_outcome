package com.bytedance.ee.bear.sheet_core.toolbar2;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends t {
    public final /* synthetic */ ItemV2 c;
    public final /* synthetic */ SheetBlockTextAttrAdapter d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        SheetBlockTextAttrAdapter.c r3 = this.d.e;
        if (r3 == null) goto L6;
        SheetBlockTextAttrFragment.a r4 = (SheetBlockTextAttrFragment.a) r3;
        r4.a(this.c);
        return;
    }

    public b(SheetBlockTextAttrAdapter r1, ItemV2 r2) {
        this.d = r1;
        this.c = r2;
    }
}
