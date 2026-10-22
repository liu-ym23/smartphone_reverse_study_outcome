package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ WikiCreateToFragment c;

    public n(WikiCreateToFragment r3) {
        this.c = r3;
        super(1000);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        StringBuilder r5 = new StringBuilder("click add node on root ");
        WikiTreeCtrlView r0 = this.c.o;
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getFocusToken();
        if (r2 == null) goto L6;
    L7:
        r5.append(du5.b.g(r2));
        tt5.a.h("Wiki_WikiCreateToFragment", r5.toString());
        if (qc5.a.h() == false) goto L17;
        WikiTreeCtrlView r6 = this.c.o;
        if (r6 != null) goto L12;
        return;
    L12:
        if (r6.f == null) goto L31;
        String r3 = r6.getViewModel().getRootToken();
        String r7 = r6.getViewModel().getRootUid();
        if (r3 == null) goto L32;
        if (r7 == null) goto L33;
        r6.k(r3, r7);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L17:
        WikiTreeCtrlView r8 = this.c.o;
        if (r8 == null) goto L35;
        String r9 = r8.getFocusToken();
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        WikiTreeCtrlView r10 = this.c.o;
        if (r10 == null) goto L28;
        String r11 = r10.getFocusUid();
        if (r11 == null) goto L28;
        r1 = r11;
    L28:
        r8.k(r9, r1);
        return;
    L35:
        return;
    L6:
        r2 = "";
        goto L7
    }
}
