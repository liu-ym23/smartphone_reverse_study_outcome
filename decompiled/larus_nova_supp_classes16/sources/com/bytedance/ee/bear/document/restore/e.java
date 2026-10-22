package com.bytedance.ee.bear.document.restore;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends t {
    public final /* synthetic */ DocDeletedView c;

    public e(DocDeletedView r3) {
        this.c = r3;
        super(500);
    }

    public final void a(View r1) {
        DocDeletedView.b r2 = this.c.d;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }
}
