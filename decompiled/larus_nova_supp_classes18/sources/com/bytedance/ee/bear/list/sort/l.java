package com.bytedance.ee.bear.list.sort;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l extends t {
    public final /* synthetic */ m c;

    public l(m r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        m r5 = this.c;
        List<q> r0 = r5.h.b;
        if (r0 == null) goto L15;
        q r6 = (q) ListProtector.get(r0, r5.d);
        if (r6 == null) goto L16;
        m r1 = this.c;
        if (r1.f == true) goto L9;
    L13:
        r1.i.g6(r1.h(r6));
        return;
    L9:
        if (r6.f != SortAscType.TITLE) goto L11;
        boolean r2 = true;
    L12:
        r6.c = r2;
        goto L13
    L11:
        r2 = false;
        goto L12
    L16:
        return;
    }
}
