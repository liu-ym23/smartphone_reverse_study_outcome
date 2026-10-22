package com.bytedance.ee.bear.list.sort;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import zd5.q;
import zd5.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends t {
    public final /* synthetic */ int c;
    public final /* synthetic */ q d;
    public final /* synthetic */ SortAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        SortAdapter r4 = this.e;
        if (r4.d == true) goto L5;
    L8:
        r4.c = this.c;
        SortAdapter.a r5 = r4.e;
        if (r5 == null) goto L13;
        q r0 = this.d;
        m r6 = ((r) r5).a;
        b.a r1 = r6.i;
        if (r1 == null) goto L13;
        r1.g6(r6.h(r0));
    L13:
        this.e.notifyDataSetChanged();
        return;
    L5:
        if (r4.c != this.c) goto L7;
        q r2 = this.d;
        r2.c = !r2.c;
        goto L8
    L7:
        this.d.c = false;
        goto L8
    }

    public c(SortAdapter r1, int r2, q r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
