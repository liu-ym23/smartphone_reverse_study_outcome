package com.larus.home.impl.sdk;

import com.larus.platform.api.g5;
import com.larus.platform.api.h5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o0 implements n38.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h5 f346207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainDouyinAuthService f346208b;

    @Override // n38.p
    public final void a(n38.e r110) {
        Intrinsics.checkNotNullParameter(r110, "oouYinTokenResult");
        h5 r100 = this.f346207a;
        this.f346208b.getClass();
        r100.a(new g5(r110.f516997a, r110.f516998b, r110.f516999c, r110.f517000d, r110.f517001e, r110.f517002f));
    }

    @Override // n38.p
    public final void onFail(int r100) {
        this.f346207a.onFailure(r100);
    }

    public o0(h5 r100, MainDouyinAuthService r101) {
        this.f346207a = r100;
        this.f346208b = r101;
    }
}
