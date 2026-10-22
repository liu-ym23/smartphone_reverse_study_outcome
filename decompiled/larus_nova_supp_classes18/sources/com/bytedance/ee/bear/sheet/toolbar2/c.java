package com.bytedance.ee.bear.sheet.toolbar2;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends t {
    public final /* synthetic */ SheetBlockTextAttrAdapter.b c;
    public final /* synthetic */ ItemV2 d;
    public final /* synthetic */ SheetBlockTextAttrAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        if (this.e.c == null) goto L10;
        CharSequence r5 = this.c.b.getText();
        ItemV2 r0 = this.d;
        if (r5 != null) goto L7;
        String r6 = "";
    L8:
        String r7 = r0.nextValueInList(r6, false);
        this.c.b.setText(r7);
        SheetBlockTextAttrAdapter r1 = this.e;
        SheetBlockTextAttrAdapter.b r2 = this.c;
        ItemV2 r3 = this.d;
        r1.getClass();
        SheetBlockTextAttrAdapter.A2(r2, r3, r7);
        SheetBlockTextAttrAdapter.c r8 = this.e.c;
        ItemV2 r9 = this.d;
        SheetBlockTextAttrFragment r10 = ((SheetBlockTextAttrFragment.a) r8).a;
        int r11 = SheetBlockTextAttrFragment.u;
        r10.ga0(r9, r7);
        return;
    L7:
        r6 = r5.toString();
        goto L8
    }

    public c(SheetBlockTextAttrAdapter r1, SheetBlockTextAttrAdapter.b r2, ItemV2 r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
