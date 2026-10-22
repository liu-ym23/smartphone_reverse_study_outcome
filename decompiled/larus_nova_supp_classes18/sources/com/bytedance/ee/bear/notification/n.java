package com.bytedance.ee.bear.notification;

import com.bytedance.ee.bear.contract.AccountService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends com.bytedance.ee.bear.contract.c {
    public final /* synthetic */ b b;

    public n(o.c r1) {
        this.b = r1;
    }

    public final void b(AccountService.Account r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.hasLogin() == false) goto L8;
        ((o.c) this.b).a.a();
        return;
    }
}
