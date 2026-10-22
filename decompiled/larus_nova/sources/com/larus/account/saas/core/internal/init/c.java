package com.larus.account.saas.core.internal.init;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements qb4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xqa.b.a f286247a;

    public c(kb7.b r100) {
        this.f286247a = r100;
    }

    @Override // qb4.f
    public final void onFail(int r100, JSONObject r101) {
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("SaaSAccountConfig", "Bdturing handle captcha fail, result = " + r100 + ", extras = " + r101);
        xqa.b.a r102 = this.f286247a;
        if (r102 == null) goto L6;
        r102.onFail();
        return;
    }

    @Override // qb4.f
    public final void onSuccess(int r100, JSONObject r101) {
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("SaaSAccountConfig", "Bdturing handle captcha success, result = " + r100 + ", extras = " + r101);
        xqa.b.a r102 = this.f286247a;
        if (r102 == null) goto L6;
        r102.onSuccess();
        return;
    }
}
