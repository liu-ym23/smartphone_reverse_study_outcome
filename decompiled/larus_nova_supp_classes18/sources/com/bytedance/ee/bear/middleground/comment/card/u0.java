package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u0 implements View.OnClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public u0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        tt5.a.h("Comment#CardComment", "closeView click, so dismiss inputComment");
        kf5.b r4 = this.a.f;
        if (r4 == null) goto L6;
        kf5.a.a(r4, false, false, 3);
        return;
    }
}
