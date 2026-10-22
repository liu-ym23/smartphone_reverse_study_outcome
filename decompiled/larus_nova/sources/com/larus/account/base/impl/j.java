package com.larus.account.base.impl;

import com.larus.login.impl.w3;

/* JADX INFO: loaded from: classes24.dex */
public final class j extends yb7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.m f286171a;

    public j(w3 r100) {
        this.f286171a = r100;
    }

    public final void b(ua7.e<wb7.b> r100) {
        this.f286171a.onSuccess(null);
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r100) {
        b((ua7.e) r100);
    }

    public final void a(ua7.e<wb7.b> r100, int r101) {
        n38.m r102 = this.f286171a;
        if (r100 == null) goto L5;
        String r103 = r100.f549255i;
    L6:
        r102.a(r101, r103, null, null);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // sa7.h
    public final /* bridge */ /* synthetic */ void onError(ua7.b r100, int r101) {
        a((ua7.e) r100, r101);
    }
}
