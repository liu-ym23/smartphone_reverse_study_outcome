package com.bytedance.sdk.account.impl;

/* JADX INFO: loaded from: classes22.dex */
public final class s extends sa7.h<xa7.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sa7.h f269136a;

    public s(r r100) {
        this.f269136a = r100;
    }

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.f r101 = (xa7.f) r100;
        r101.C = "success";
        r101.E = "v2";
        this.f269136a.onSuccess(r101);
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        xa7.f r102 = (xa7.f) r100;
        r102.C = "fail";
        r102.E = "v2";
        this.f269136a.onError(r102, r101);
    }
}
