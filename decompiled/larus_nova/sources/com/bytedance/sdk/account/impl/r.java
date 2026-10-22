package com.bytedance.sdk.account.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends sa7.h<xa7.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f269133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f269134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f269135c;

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        p r101 = this.f269135c;
        Map r102 = this.f269133a;
        String r103 = this.f269134b;
        p.q(r101, r102, r103, (xa7.f) r100);
    }

    @Override // sa7.h
    public final void onError(ua7.b r100, int r101) {
        p r102 = this.f269135c;
        Map r103 = this.f269133a;
        String r104 = this.f269134b;
        p.q(r102, r103, r104, (xa7.f) r100);
    }

    public r(p r100, Map r101, String r102) {
        this.f269135c = r100;
        this.f269133a = r101;
        this.f269134b = r102;
    }
}
