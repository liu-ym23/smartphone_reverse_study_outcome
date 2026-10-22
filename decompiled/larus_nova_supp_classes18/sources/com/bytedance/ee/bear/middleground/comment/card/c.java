package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements sa5.d {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final boolean onBackPressed() {
        if (this.a.a() == false) goto L5;
        return true;
    L5:
        b r0 = this.a;
        if (r0.a.n != CommentStyle.ASIDE) goto L9;
        return false;
    L9:
        r0.Ni(true);
        return true;
    }
}
