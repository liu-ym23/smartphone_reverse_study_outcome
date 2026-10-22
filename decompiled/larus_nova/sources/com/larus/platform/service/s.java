package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes.dex */
public final class s implements com.larus.platform.api.t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f365799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365800b = null;

    public s() {
    }

    static {
        f365799a = new s();
        f365800b = LazyKt.lazy(new r());
    }

    public static com.larus.platform.api.t1 i() {
        return (com.larus.platform.api.t1) f365800b.getValue();
    }

    @Override // com.larus.platform.api.t1
    public final boolean a() {
        com.larus.platform.api.t1 r100 = i();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.t1
    public final boolean b() {
        com.larus.platform.api.t1 r100 = i();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.b();
    }

    @Override // com.larus.platform.api.t1
    public final boolean c() {
        com.larus.platform.api.t1 r100 = i();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.c();
    }

    @Override // com.larus.platform.api.t1
    public final String d() {
        com.larus.platform.api.t1 r100 = i();
        if (r100 == null) goto L6;
        String r101 = r100.d();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "release_version";
    }

    @Override // com.larus.platform.api.t1
    public final boolean e() {
        com.larus.platform.api.t1 r100 = i();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.e();
    }

    @Override // com.larus.platform.api.t1
    public final boolean f() {
        com.larus.platform.api.t1 r100 = i();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f();
    }

    @Override // com.larus.platform.api.t1
    public final boolean g() {
        com.larus.platform.api.t1 r100 = i();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.g();
    }

    @Override // com.larus.platform.api.t1
    public final String getBuildChannel() {
        com.larus.platform.api.t1 r100 = i();
        if (r100 == null) goto L6;
        String r101 = r100.getBuildChannel();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.platform.api.t1
    public final boolean h() {
        com.larus.platform.api.t1 r100 = i();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.h();
    }
}
