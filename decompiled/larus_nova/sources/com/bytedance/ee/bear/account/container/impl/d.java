package com.bytedance.ee.bear.account.container.impl;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f206226a;

    public d(c r100) {
        this.f206226a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h(this.f206226a.a(), "pull userInfo done");
        UserInfoResult r101 = (UserInfoResult) ((Result) r100).data;
        if (r101 == null) goto L6;
        c r102 = this.f206226a;
        r102.f206211c.putString("ccm_account_domain", r101.domain);
        r102.f206211c.putString("ccm_account_department_id", r101.departmentId);
        r102.f206211c.putBoolean("ccm_account_isSuperAdmin", r101.isSuperAdmin);
        r102.f206211c.putBoolean("key_has_leader", r101.hasLeader);
        r102.b(r102.G2());
        return;
    }
}
