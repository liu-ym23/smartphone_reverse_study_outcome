package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t a;

    public c(com.bytedance.ee.bear.middleground.comment.control.t r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("Comment#DeleteCell", "Error deleting comment", r5, false);
        com.bytedance.ee.bear.middleground.comment.control.t r0 = this.a;
        String r6 = r5.getMessage();
        if (r6 != null) goto L5;
        r6 = "{}";
    L5:
        r0.w(r6, Action.DELETE);
    }
}
