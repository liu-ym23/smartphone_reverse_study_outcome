package com.bytedance.ee.bear.bitable.uikit.catalog;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ gv4.a a;
    public final /* synthetic */ SimpleItemModel b;

    public c(gv4.a r1, SimpleItemModel r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        gv4.a r6 = this.a;
        if (r6 == null) goto L13;
        SimpleItemModel r1 = this.b;
        String r2 = null;
        if (r1 == null) goto L7;
        String r3 = r1.getId();
    L8:
        SimpleItemModel r4 = this.b;
        if (r4 == null) goto L11;
        r2 = r4.getClickAction();
    L11:
        r6.a(new Action(r3, r2));
        return;
    L7:
        r3 = null;
        goto L8
    }
}
