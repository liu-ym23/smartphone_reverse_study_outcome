package com.bytedance.sdk.account.impl;

/* JADX INFO: loaded from: classes22.dex */
public final class l extends va7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f269102a;

    public l(j r100) {
        this.f269102a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.d r101 = (xa7.d) r100;
        this.f269102a.u();
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.d r102 = (xa7.d) r100;
        this.f269102a.u();
    }
}
