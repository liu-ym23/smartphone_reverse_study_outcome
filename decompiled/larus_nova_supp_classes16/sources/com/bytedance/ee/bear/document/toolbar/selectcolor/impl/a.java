package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends t {
    public final /* synthetic */ String c;
    public final /* synthetic */ SelectColorAdapter d;

    public final void a(View r2) {
        SelectColorAdapter.a r3 = this.d.d;
        if (r3 == null) goto L6;
        String r0 = this.c;
        ((b) r3).a.h.colorSelected(r0);
        return;
    }

    public a(SelectColorAdapter r1, String r2) {
        this.d = r1;
        this.c = r2;
    }
}
