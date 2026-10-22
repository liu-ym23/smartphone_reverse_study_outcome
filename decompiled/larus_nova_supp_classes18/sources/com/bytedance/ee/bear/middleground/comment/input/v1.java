package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v1 implements View.OnClickListener {
    public final /* synthetic */ InputCommentV2 a;

    public v1(InputCommentV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        tt5.a.h(this.a.i0, "click closeView, so dismiss inputComment");
        kf5.a.a(this.a, false, false, 3);
    }
}
