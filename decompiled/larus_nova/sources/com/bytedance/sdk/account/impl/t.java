package com.bytedance.sdk.account.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends sa7.h<xa7.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sa7.h f269137a;

    public t(r r100) {
        this.f269137a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.f r101 = (xa7.f) r100;
        r101.D = "success";
        r101.E = "v2";
        r101.B = 0;
        this.f269137a.onSuccess(r101);
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.f r102 = (xa7.f) r100;
        r102.D = "fail";
        r102.E = "v2";
        r102.B = 0;
        this.f269137a.onError(r102, r101);
    }
}
