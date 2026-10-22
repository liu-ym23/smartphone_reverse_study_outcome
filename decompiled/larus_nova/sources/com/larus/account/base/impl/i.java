package com.larus.account.base.impl;

import com.larus.login.impl.t3;

/* JADX INFO: loaded from: classes24.dex */
public final class i extends yb7.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n38.m f286170a;

    public i(t3 r100) {
        this.f286170a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        ua7.i r101 = (ua7.i) r100;
        n38.m r102 = this.f286170a;
        if (r101 == null) goto L5;
        String r103 = r101.f549289p;
    L6:
        r102.onSuccess(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        ua7.i r102 = (ua7.i) r100;
        n38.m r103 = this.f286170a;
        if (r102 == null) goto L5;
        String r104 = r102.f549255i;
    L6:
        r103.a(r101, r104, null, null);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
