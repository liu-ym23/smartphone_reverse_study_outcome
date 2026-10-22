package com.bytedance.kmp.ab;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.c;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f251225c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f251226b;

    static {
        f251225c = new b();
    }

    @Override // com.bytedance.kmp.ab.a
    public final Float J1(String r100, Float r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f251226b.J1(r100, r101);
    }

    @Override // com.bytedance.kmp.ab.a
    public final Long K0(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f251226b.K0(r100, r101);
    }

    @Override // com.bytedance.kmp.ab.a
    public final Boolean Q0(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f251226b.Q0(r100, r101);
    }

    @Override // com.bytedance.kmp.ab.a
    public final Integer X0(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f251226b.X0(r100, r101);
    }

    @Override // com.bytedance.kmp.ab.a
    public final String Z0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f251226b.Z0(r100, r101);
    }

    @Override // com.bytedance.kmp.ab.a
    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f251226b.contains(r100);
    }

    public b() {
        pd6.b r100 = c.f528682a;
        pd6.a r101 = c.a(Reflection.getOrCreateKotlinClass(a.class));
        Intrinsics.checkNotNull(r101);
        this.f251226b = (a) r101;
    }
}
