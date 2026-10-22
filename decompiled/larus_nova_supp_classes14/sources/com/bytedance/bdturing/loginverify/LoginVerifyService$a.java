package com.bytedance.bdturing.loginverify;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;
import jc4.a;
import qb4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LoginVerifyService$a implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ a b;
    public final /* synthetic */ f c;
    public final /* synthetic */ LoginVerifyService d;

    @Override // java.lang.Runnable
    public final void run() {
        LoginVerifyService.access$000(this.d, this.a, this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LoginVerifyService$a(LoginVerifyService r1, Activity r2, a r3, f r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
