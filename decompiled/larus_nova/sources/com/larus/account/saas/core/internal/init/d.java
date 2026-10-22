package com.larus.account.saas.core.internal.init;

import android.app.Activity;
import jc4.m;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends xqa.a {
    @Override // xqa.b
    public final void c() {
    }

    public d() {
    }

    @Override // xqa.b
    public final void a(String r100, kb7.b r101) {
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("SaaSAccountConfig", "Passport handle captcha, call bdturing showVerifyDialog");
        qb4.b r102 = qb4.b.c.f532315a;
        Activity r103 = com.bytedance.sdk.account.utils.d.b();
        if (r100 == null) goto L5;
        m r104 = new m(r100);
    L6:
        r102.i(r103, r104, new c(r101));
        return;
    L5:
        r104 = null;
        goto L6
    }
}
