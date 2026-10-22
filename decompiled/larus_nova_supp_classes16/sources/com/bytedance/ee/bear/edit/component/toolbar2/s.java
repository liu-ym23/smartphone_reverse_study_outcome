package com.bytedance.ee.bear.edit.component.toolbar2;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ItemIdV2 d;
    public final /* synthetic */ BaseToolbarV2PanelFragment e;

    public final void a(View r3) {
        String r4 = String.valueOf(this.c);
        this.e.fa0(this.d, r4);
    }

    public s(BaseToolbarV2PanelFragment r1, boolean r2, ItemIdV2 r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
