package com.bytedance.ee.bear.widgets;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends t {
    public final /* synthetic */ BaseTitleBar.a c;
    public final /* synthetic */ BaseTitleBar d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        this.c.performAction(r3);
        BaseTitleBar r0 = this.d;
        if (r0.s == false) goto L12;
        BaseTitleBar.a r1 = this.c;
        r0.getClass();
        if ((r1 instanceof BaseTitleBar.c) == false) goto L13;
        View r4 = r3.findViewById(2131393181);
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.getVisibility() != 0) goto L15;
        r4.setVisibility(8);
        return;
    L15:
        return;
    L13:
        return;
    }

    public k(BaseTitleBar r1, BaseTitleBar.b r2) {
        this.d = r1;
        this.c = r2;
    }
}
