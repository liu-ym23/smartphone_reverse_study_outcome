package com.larus.home.impl.sdk;

import java.util.Map;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements x38.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.platform.api.a f346139a;

    public b(com.larus.platform.api.a r100) {
        this.f346139a = r100;
    }

    @Override // x38.e
    public final void a(int r100, String r101, Throwable r102) {
        this.f346139a.a(r100, r101, r102);
    }

    @Override // x38.e
    public final void b(String r100, String r101, Map<String, String> r102, Map<String, ? extends Object> r103) {
        this.f346139a.onSuccess(r100, r101);
    }
}
