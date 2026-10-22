package com.bytedance.ee.bear.middleground.comment.input;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u1 implements Runnable {
    public final /* synthetic */ InputCommentV2 a;

    public u1(InputCommentV2 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InputCommentV2 r0 = this.a;     // Catch: Throwable -> L4
        r0.n0.f(false);     // Catch: Throwable -> L4
        r0.R();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
