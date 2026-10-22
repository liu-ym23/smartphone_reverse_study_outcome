package com.bytedance.ee.bear.middleground.comment.cell;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t a;

    public q(com.bytedance.ee.bear.middleground.comment.control.t r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        tt5.a.f("Comment#RetryCell", r4, false);
        com.bytedance.ee.bear.middleground.comment.control.t r0 = this.a;
        String r5 = r4.getMessage();
        if (r5 != null) goto L5;
        r5 = "{}";
    L5:
        r0.w(r5, Action.DELETE);
    }
}
