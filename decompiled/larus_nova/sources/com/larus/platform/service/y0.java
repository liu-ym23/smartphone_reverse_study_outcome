package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 implements com.larus.platform.api.t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f365861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365862b = null;

    public y0() {
    }

    static {
        f365861a = new y0();
        f365862b = LazyKt.lazy(new x0());
    }

    public static com.larus.platform.api.t2 j() {
        return (com.larus.platform.api.t2) f365862b.getValue();
    }

    @Override // com.larus.platform.api.t2
    public final boolean f() {
        Intrinsics.checkNotNullParameter("/alice/user/config/pull", "path");
        com.larus.platform.api.t2 r100 = j();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f();
    }

    @Override // com.larus.platform.api.t2
    public final String a() {
        com.larus.platform.api.t2 r100 = j();
        if (r100 == null) goto L6;
        String r101 = r100.a();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.t2
    public final void b() {
        com.larus.platform.api.t2 r100 = j();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.larus.platform.api.t2
    public final int c() {
        com.larus.platform.api.t2 r100 = j();
        if (r100 != null) goto L7;
        return 1;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.t2
    public final String d() {
        com.larus.platform.api.t2 r100 = j();
        if (r100 == null) goto L6;
        String r101 = r100.d();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.t2
    public final hq9.o e() {
        com.larus.platform.api.t2 r100 = j();
        if (r100 == null) goto L7;
        hq9.o r101 = r100.e();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new hq9.o("", "", "", MapsKt.emptyMap());
    }

    @Override // com.larus.platform.api.t2
    public final String g() {
        com.larus.platform.api.t2 r100 = j();
        if (r100 == null) goto L6;
        String r101 = r100.g();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.t2
    public final boolean h() {
        com.larus.platform.api.t2 r100 = j();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.h();
    }

    @Override // com.larus.platform.api.t2
    public final hq9.c1 i() {
        com.larus.platform.api.t2 r100 = j();
        if (r100 == null) goto L7;
        hq9.c1 r101 = r100.i();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new hq9.c1("", "", "", "");
    }
}
