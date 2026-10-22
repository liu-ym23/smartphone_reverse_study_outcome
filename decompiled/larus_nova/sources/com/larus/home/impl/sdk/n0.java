package com.larus.home.impl.sdk;

import com.larus.platform.api.e5;
import com.larus.platform.api.f5;

/* JADX INFO: loaded from: classes29.dex */
public final class n0 implements n38.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e5 f346204a;

    public n0(e5 r100) {
        this.f346204a = r100;
    }

    @Override // n38.f
    public final void onResult(String r100, String r101, String r102) {
        this.f346204a.a(new f5(r100, r101, r102));
    }
}
