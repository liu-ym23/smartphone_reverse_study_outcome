package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.ee.bear.contract.AccountService$Account;

/* JADX INFO: loaded from: classes16.dex */
public final class f0 extends com.bytedance.ee.bear.contract.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f220587b;

    public f0(h0 r100) {
        this.f220587b = r100;
    }

    @Override // com.bytedance.ee.bear.contract.c
    public final void b(AccountService$Account r100) {
        tt5.a.b("PreloadManager", "onChanged().... account = " + r100);
        this.f220587b.d(r100);
    }
}
