package com.bytedance.ee.bear.list.sort;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends t {
    public final /* synthetic */ h c;

    public f(h r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        tt5.a.h("SortAndFilterView", "onClick done()...");
        h r3 = this.c;
        a.InterfaceC0035a r0 = r3.r;
        if (r0 == null) goto L5;
        r0.z2(r3.o());
    L5:
        h.k(this.c, "done");
        h.h(this.c, "confirm");
    }
}
