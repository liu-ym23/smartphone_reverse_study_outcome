package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.ee.bear.contract.AccountService$Account;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f0 extends com.bytedance.ee.bear.contract.c {
    public final /* synthetic */ h0 b;

    public f0(h0 r1) {
        this.b = r1;
    }

    @Override // com.bytedance.ee.bear.contract.c
    public final void b(AccountService$Account r3) {
        tt5.a.b("PreloadManager", "onChanged().... account = " + r3);
        this.b.d(r3);
    }
}
