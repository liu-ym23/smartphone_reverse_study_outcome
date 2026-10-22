package com.bytedance.bdturing.loginverify;

import com.larus.apm.impl.protector.RunnableProtector;
import hc4.d;
import org.json.JSONObject;
import qb4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LoginVerifyService$c implements Runnable {
    public final f a;
    public boolean b;
    public final /* synthetic */ LoginVerifyService c;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.b == true) goto L9;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L6
        d.b(r0, "errorMsg", "login verify timeOut");     // Catch: Throwable -> L6
        LoginVerifyService.access$100(this.c, false, r0, this.a);     // Catch: Throwable -> L6
        return;
    }

    public LoginVerifyService$c(LoginVerifyService r1, f r2) {
        this.c = r1;
        this.a = r2;
    }
}
