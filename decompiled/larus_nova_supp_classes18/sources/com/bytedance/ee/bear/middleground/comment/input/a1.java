package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a1 implements View.OnClickListener {
    public final /* synthetic */ InputComment a;

    public a1(InputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.a.S.getVisibility() != 0) goto L7;
        this.a.a.d0.m("text_edit");
        com.bytedance.ee.bear.middleground.comment.audio.b r4 = this.a.u.a;
        if (r4 == null) goto L12;
        r4.onClick();
    L12:
        tt5.a.h("Comment#InputComment", "input click");
        return;
    L7:
        InputComment r5 = this.a;
        if (r5.n0 == true) goto L10;
        r5.Z(0);
        this.a.B(false);
    L11:
        this.a.C();
        goto L12
    L10:
        r5.B(true);
        goto L11
    }
}
