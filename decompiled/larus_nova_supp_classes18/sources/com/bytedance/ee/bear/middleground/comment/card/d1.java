package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d1 implements View.OnClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public d1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        HalfScreenCardComment.s(this.a, false, true, 4);
    }
}
