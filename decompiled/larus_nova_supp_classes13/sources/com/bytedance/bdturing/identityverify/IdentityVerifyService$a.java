package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import com.bytedance.bdturing.setting.e;
import com.larus.apm.impl.protector.RunnableProtector;
import jc4.a;
import qb4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class IdentityVerifyService$a implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Activity c;
    public final /* synthetic */ f d;
    public final /* synthetic */ IdentityVerifyService e;

    public final void a() {
        jc4.f r0 = this.a;
        if (r0.t == true) goto L5;
    L12:
        IdentityVerifyService.access$200(this.e, this.c, r0, this.d);
        return;
    L5:
        if (this.b == true) goto L12;
        e r1 = e.a;
        boolean r2 = false;
        if (e.e("common").optInt("identity_use_dialog_v2", 0) != 1) goto L9;
        r2 = true;
    L9:
        if (r2 == false) goto L11;
        IdentityVerifyService.access$000(this.e, this.c, this.a, this.d);
        return;
    L11:
        IdentityVerifyService.access$100(this.e, this.c, this.a, this.d);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public IdentityVerifyService$a(IdentityVerifyService r1, a r2, boolean r3, Activity r4, f r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
