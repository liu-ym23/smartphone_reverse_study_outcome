package com.bytedance.ee.bear.notification;

import com.bytedance.ee.bear.contract.AccountService$Account;

/* JADX INFO: loaded from: classes18.dex */
public final class n extends com.bytedance.ee.bear.contract.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f235130b;

    public n(o.c r100) {
        this.f235130b = r100;
    }

    @Override // com.bytedance.ee.bear.contract.c
    public final void b(AccountService$Account r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.hasLogin() == false) goto L8;
        ((o.c) this.f235130b).f235140a.a();
        return;
    }
}
