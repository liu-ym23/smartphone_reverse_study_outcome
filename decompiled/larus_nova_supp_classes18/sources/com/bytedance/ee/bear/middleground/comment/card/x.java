package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ FloatCardComment a;

    public x(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (((Boolean) this.a.j.invoke()).booleanValue() == false) goto L5;
        return;
    L5:
        this.a.f.p1().invoke(0);
        FloatCardComment r5 = this.a;
        com.bytedance.ee.bear.middleground.comment.export.bean.a r1 = r5.E;
        if (r1 == null) goto L8;
        r1.j = true;
    L8:
        r5.Ni(true);
        com.bytedance.ee.bear.middleground.comment.export.bean.a r6 = this.a.E;
        if (r6 == null) goto L12;
        r6.j = false;
        return;
    }
}
