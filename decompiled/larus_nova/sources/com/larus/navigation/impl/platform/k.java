package com.larus.navigation.impl.platform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k implements e37.c {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter("BDNavigation", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
        int r101 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.a("kmp_sdk", "[BDNavigation] " + r100);
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("kmp_sdk", "[" + r100 + "] " + r101);
    }

    public final void a(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.a("kmp_sdk", "[" + r100 + "] " + r101);
    }

    public final void c(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("kmp_sdk", "[" + r100 + "] " + r101, r102);
    }

    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("kmp_sdk", "[" + r100 + "] " + r101);
    }

    public final void f(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("kmp_sdk", "[" + r100 + "] " + r101, r102);
    }
}
