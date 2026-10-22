package com.bytedance.locallife.biz.base.cube;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f256541a = null;

    static {
        f256541a = new i();
    }

    public i() {
    }

    public final boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        yn6.c r102 = yn6.a.f568561a;
        return yn6.a.c(r100, r101);
    }

    public final Object b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        yn6.c r102 = yn6.a.f568561a;
        return yn6.a.e(r100, null, r101);
    }

    public final boolean c(String r100, Object r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        yn6.c r103 = yn6.a.f568561a;
        return yn6.a.f(r100, r101, r102);
    }
}
