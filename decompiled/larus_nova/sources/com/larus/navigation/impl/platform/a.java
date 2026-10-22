package com.larus.navigation.impl.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements com.bytedance.bdnavigationsdk.e {

    /* JADX INFO: renamed from: com.larus.navigation.impl.platform.a$a, reason: collision with other inner class name */
    public static final class C4429a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter("BDNAAppContext 尝试重复初始化，但使用的不是同一个 Application Context", "msg");
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("bdna_sdk", "[" + r100 + "] BDNAAppContext 尝试重复初始化，但使用的不是同一个 Application Context", r101);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void d(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.a("bdna_sdk", "[" + r100 + "] " + r101);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("bdna_sdk", "[" + r100 + "] " + r101, r102);
    }

    @Override // com.bytedance.bdnavigationsdk.e
    public final void i(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("bdna_sdk", "[" + r100 + "] " + r101);
    }
}
