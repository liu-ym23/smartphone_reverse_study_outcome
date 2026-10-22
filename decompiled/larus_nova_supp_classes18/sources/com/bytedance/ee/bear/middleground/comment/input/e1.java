package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e1 implements View.OnClickListener {
    public final /* synthetic */ InputComment a;

    public e1(InputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        tt5.a.h("Comment#InputComment", "at click");
        InputComment.A(this.a);
    }
}
