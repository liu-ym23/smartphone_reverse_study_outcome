package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n1 implements View.OnClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public n1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        tt5.a.h("Comment#CardComment", "prevButton click");
        int r0 = this.a.n.getCurrentItem();
        if (r0 <= 0) goto L8;
        this.a.n.w(r0 - 1, true);
        tt5.a.h("Comment#CardComment", "prevButton click, so dismiss inputComment");
        kf5.b r5 = this.a.f;
        if (r5 == null) goto L9;
        kf5.a.a(r5, false, false, 3);
        return;
    L9:
        return;
    }
}
