package com.bytedance.bdturing.uc_twiceverify;

import com.larus.apm.impl.protector.RunnableProtector;
import jc4.a;
import qb4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class UCTwiceVerifyService$a implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ f b;
    public final /* synthetic */ UCTwiceVerifyService c;

    @Override // java.lang.Runnable
    public final void run() {
        UCTwiceVerifyService.access$000(this.c, this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public UCTwiceVerifyService$a(UCTwiceVerifyService r1, a r2, f r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
