package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends t {
    public final /* synthetic */ Highlight.ColorItem c;
    public final /* synthetic */ SelectColorV2Adapter d;

    public final void a(View r2) {
        SelectColorV2Adapter.b r3 = this.d.f;
        if (r3 == null) goto L6;
        r3.a(this.c);
        return;
    }

    public d(SelectColorV2Adapter r1, Highlight.ColorItem r2, int r3) {
        this.d = r1;
        this.c = r2;
    }
}
