package com.bytedance.ee.bear.middleground.comment.control;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements PopupWindow.OnDismissListener {
    public final /* synthetic */ CommentFunction a;

    public p(CommentFunction r1) {
        this.a = r1;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        CommentFunction r0 = this.a;
        sa5.b r1 = r0.i;
        if (r1 == null) goto L5;
        r1.d(r0.k);
    L5:
        CommentFunction r2 = this.a;
        r2.n = System.currentTimeMillis();
        this.a.a.N.a(new ef5.c0());
    }
}
