package com.bytedance.ee.bear.document.associateddocs.view;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends t {
    public final /* synthetic */ AssociatedAppUrlListAdapter c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public final void a(View r3) {
        AssociatedAppUrlListAdapter.a r4 = this.c.a;
        if (r4 == null) goto L6;
        r4.a(this.d, this.e);
        return;
    }

    public j(AssociatedAppUrlListAdapter r1, String r2, String r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
