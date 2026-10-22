package com.bytedance.ee.bear.sheet.toolbar2;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ItemV2 f238455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SheetBlockTextAttrAdapter f238456d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        SheetBlockTextAttrAdapter.c r101 = this.f238456d.f238441c;
        if (r101 == null) goto L6;
        SheetBlockTextAttrFragment.a r102 = (SheetBlockTextAttrFragment.a) r101;
        r102.a(this.f238455c);
        return;
    }

    public b(SheetBlockTextAttrAdapter r100, ItemV2 r101) {
        this.f238456d = r100;
        this.f238455c = r101;
    }
}
