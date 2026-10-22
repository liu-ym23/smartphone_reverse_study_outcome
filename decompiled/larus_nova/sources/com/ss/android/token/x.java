package com.ss.android.token;

/* JADX INFO: loaded from: classes38.dex */
public final class x extends va7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f449815a;

    public x(String r100) {
        this.f449815a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        com.ss.android.account.d r101 = ((xa7.d) r100).f549279p;     // Catch: Exception -> L9
        if (r101 != null) goto L6;
    L11:
        com.bytedance.sdk.account.utils.f.a().c(this.f449815a, System.currentTimeMillis() + 86400000);
        return;
    L6:
        if (r101.f541360a <= 0) goto L11;
        TTTokenMonitor.r("syn_login_status_error", null);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.d r102 = (xa7.d) r100;
        com.bytedance.sdk.account.utils.f.a().c(this.f449815a, System.currentTimeMillis() + 86400000);
    }
}
