package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s1 implements View.OnClickListener {
    public final /* synthetic */ InputComment a;

    public s1(InputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        tt5.a.h("Comment#InputComment", "click closeView, so dismiss inputComment");
        kf5.a.a(this.a, false, false, 3);
    }
}
