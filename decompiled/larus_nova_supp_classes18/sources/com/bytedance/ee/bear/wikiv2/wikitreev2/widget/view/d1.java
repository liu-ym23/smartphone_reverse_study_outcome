package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.ViewParent;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d1 implements pc5.i.c {
    public final /* synthetic */ WikiTreeCtrlView a;

    @Override // pc5.i.c
    public final void j0() {
        pc5.i r0 = this.a.i;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L6:
        if (r1 == null) goto L9;
        this.a.getUploadViewContainerFromXml().removeView(this.a.i);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // pc5.i.c
    public final void o0() {
        WikiTreeCtrlView r0 = this.a;
        pc5.i r1 = r0.i;
        if (r1 == null) goto L10;
        if (r1 == null) goto L6;
        ViewParent r2 = r1.getParent();
    L7:
        if (r2 != null) goto L11;
        r0.getUploadViewContainerFromXml().addView(r1);
        return;
    L11:
        return;
    L6:
        r2 = null;
        goto L7
    }

    public d1(WikiTreeCtrlView r1) {
        this.a = r1;
    }

    @Override // pc5.i.c
    public final void k(rf5.d r3) {
        if (r3 == null) goto L4;
        String r0 = r3.b;
    L5:
        com.bytedance.ee.bear.wikiv2.browser.plugin.p0.b(r0, this.a.getUserComponentAbility());
        if (r3 == null) goto L11;
        WikiTreeCtrlView.d r1 = this.a.getViewDelegate();
        if (r1 == null) goto L12;
        r1.r(GsonProtectorUtils.toJson(new Gson(), r3));
        return;
    L12:
        return;
    L11:
        return;
    L4:
        r0 = null;
        goto L5
    }
}
