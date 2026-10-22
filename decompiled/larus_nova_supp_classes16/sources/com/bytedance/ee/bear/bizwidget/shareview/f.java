package com.bytedance.ee.bear.bizwidget.shareview;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class f implements View.OnClickListener {
    public final /* synthetic */ h.a a;
    public final /* synthetic */ h.c b;

    public /* synthetic */ f(h.a r1, h.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        h.a r3 = this.a;
        h.c r0 = this.b;
        r3.getClass();
        r0.a();
        h r4 = r3.a;
        Dialog r1 = r4.b;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isShowing() == false) goto L9;
        h.a(r4.b);
        return;
    }
}
