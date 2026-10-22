package com.bytedance.ee.bear.bitable.uikit.catalog;

import android.view.View;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ gv4.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Icon c;

    public b(gv4.a r1, String r2, Icon r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        gv4.a r5 = this.a;
        if (r5 == null) goto L10;
        String r1 = this.b;
        Icon r2 = this.c;
        if (r2 == null) goto L7;
        String r3 = r2.getClickAction();
    L8:
        r5.a(new Action(r1, r3));
        return;
    L7:
        r3 = null;
        goto L8
    }
}
