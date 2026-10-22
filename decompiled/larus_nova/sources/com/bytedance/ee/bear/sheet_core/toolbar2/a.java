package com.bytedance.ee.bear.sheet_core.toolbar2;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ItemV2 f238552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SheetBlockTextAttrAdapter f238553d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        SheetBlockTextAttrAdapter.c r101 = this.f238553d.f238541e;
        if (r101 == null) goto L6;
        SheetBlockTextAttrFragment.a r102 = (SheetBlockTextAttrFragment.a) r101;
        r102.a(this.f238552c);
        return;
    }

    public a(SheetBlockTextAttrAdapter r100, ItemV2 r101) {
        this.f238553d = r100;
        this.f238552c = r101;
    }
}
