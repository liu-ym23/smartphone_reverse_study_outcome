package com.bytedance.ee.bear.list.sort;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends t {
    public final /* synthetic */ h c;

    public e(h r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        tt5.a.h("SortAndFilterView", "onClick reset()...");
        h r3 = this.c;
        if (r3.c == false) goto L5;
        FilterTypeAdapter r0 = r3.p;
        r0.c = r3.g;
        r0.notifyDataSetChanged();
    L5:
        h r4 = this.c;
        if (r4.d == false) goto L8;
        ((q) ListProtector.get(r4.q.b, r4.h)).c = false;
        h r5 = this.c;
        SortTypeAdapter r1 = r5.q;
        r1.c = r5.h;
        r1.notifyDataSetChanged();
    L8:
        this.c.s();
        h r6 = this.c;
        a.InterfaceC0035a r7 = r6.r;
        if (r7 == null) goto L11;
        r7.y2(r6.o());
    L11:
        h.k(this.c, "reset");
        h.h(this.c, "reset");
    }
}
