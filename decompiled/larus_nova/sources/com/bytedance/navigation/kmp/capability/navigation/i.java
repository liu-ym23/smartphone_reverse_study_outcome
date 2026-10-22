package com.bytedance.navigation.kmp.capability.navigation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements com.bytedance.bdnavigationsdk.e {
    public i() {
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter("BDNAAppContext 尝试重复初始化，但使用的不是同一个 Application Context", "msg");
        d37.i.f466749a.j(r100, "BDNAAppContext 尝试重复初始化，但使用的不是同一个 Application Context", r101);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void d(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        d37.i.f466749a.b(r100, r101, r102);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        d37.i.f466749a.d(r100, r101, r102);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void i(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        d37.i.f466749a.i(r100, r101, r102);
    }
}
