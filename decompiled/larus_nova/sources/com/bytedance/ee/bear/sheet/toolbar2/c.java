package com.bytedance.ee.bear.sheet.toolbar2;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SheetBlockTextAttrAdapter.b f238457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ItemV2 f238458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SheetBlockTextAttrAdapter f238459e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (this.f238459e.f238441c == null) goto L10;
        CharSequence r101 = this.f238457c.f238444b.getText();
        ItemV2 r102 = this.f238458d;
        if (r101 != null) goto L7;
        String r103 = "";
    L8:
        String r104 = r102.nextValueInList(r103, false);
        this.f238457c.f238444b.setText(r104);
        SheetBlockTextAttrAdapter r105 = this.f238459e;
        SheetBlockTextAttrAdapter.b r106 = this.f238457c;
        ItemV2 r107 = this.f238458d;
        r105.getClass();
        SheetBlockTextAttrAdapter.A2(r106, r107, r104);
        SheetBlockTextAttrAdapter.c r108 = this.f238459e.f238441c;
        ItemV2 r109 = this.f238458d;
        SheetBlockTextAttrFragment r110 = ((SheetBlockTextAttrFragment.a) r108).f238448a;
        int r111 = SheetBlockTextAttrFragment.f238446u;
        r110.ga0(r109, r104);
        return;
    L7:
        r103 = r101.toString();
        goto L8
    }

    public c(SheetBlockTextAttrAdapter r100, SheetBlockTextAttrAdapter.b r101, ItemV2 r102) {
        this.f238459e = r100;
        this.f238457c = r101;
        this.f238458d = r102;
    }
}
