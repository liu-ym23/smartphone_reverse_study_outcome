package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ItemV2 d;
    public final /* synthetic */ OfficeBaseToolbarV2PanelFragment e;

    public final void a(View r3) {
        String r4 = String.valueOf(this.c);
        this.e.ma0(this.d.id(), r4);
    }

    public t(OfficeBaseToolbarV2PanelFragment r1, boolean r2, ItemV2 r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
