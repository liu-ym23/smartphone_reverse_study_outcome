package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j1 implements View.OnClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public j1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.b.p1().invoke(0);
        HalfScreenCardComment r5 = this.a;
        com.bytedance.ee.bear.middleground.comment.export.bean.a r1 = r5.Y;
        if (r1 == null) goto L5;
        r1.j = true;
    L5:
        r5.Ni(true);
        com.bytedance.ee.bear.middleground.comment.export.bean.a r6 = this.a.Y;
        if (r6 == null) goto L9;
        r6.j = false;
        return;
    }
}
