package com.bytedance.ee.bear.more.protocol3.panel;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 implements View.OnClickListener {
    public final /* synthetic */ OverrideUIMoreItemFactory a;
    public final /* synthetic */ String b;
    public final /* synthetic */ q c;
    public final /* synthetic */ x d;
    public final /* synthetic */ View.OnClickListener e;

    public d0(OverrideUIMoreItemFactory r1, String r2, q r3, x r4, View.OnClickListener r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (OverrideUIMoreItemFactory.c(this.a, this.b, this.c, this.d) == true) goto L8;
        View.OnClickListener r0 = this.e;
        if (r0 == null) goto L9;
        r0.onClick(r5);
        return;
    L9:
        return;
    }
}
