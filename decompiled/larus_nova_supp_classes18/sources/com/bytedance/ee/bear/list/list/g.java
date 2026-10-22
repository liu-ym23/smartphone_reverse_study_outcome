package com.bytedance.ee.bear.list.list;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends t {
    public final /* synthetic */ int c;
    public final /* synthetic */ Document d;
    public final /* synthetic */ ListStyleAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        j r0 = this.e.c;
        if (r0 == null) goto L5;
        r0.P(r4, this.c, this.d);
    L5:
        this.e.D2();
    }

    public g(ListStyleAdapter r1, int r2, Document r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
