package com.larus.disk.impl.handler;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements com.larus.disk.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f330714c;

    @Override // com.larus.disk.api.c
    public final void h(boolean r100, boolean r101) {
    }

    @Override // com.larus.disk.api.c
    public final boolean i() {
        return false;
    }

    @Override // com.larus.disk.api.c
    public final String a() {
        return new PolarisFileWrapper(aa9.a.f2357a.a(), this.f330712a).getAbsolutePath();
    }

    @Override // com.larus.disk.api.c
    public final long getCacheSize() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(a());
        if (r100.exists() == true) goto L5;
        return 0;
    L5:
        return RangesKt.coerceAtLeast(com.larus.utils.r.r(r100), 0);
    }

    @Override // com.larus.disk.api.c
    public final String bizTag() {
        return this.f330713b;
    }

    @Override // com.larus.disk.api.c
    public final String business() {
        return this.f330714c;
    }

    @Override // com.larus.disk.api.c
    public final long b(boolean r100) {
        return getCacheSize();
    }

    public p(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "directoryName");
        Intrinsics.checkNotNullParameter(r101, "cacheBizTag");
        Intrinsics.checkNotNullParameter(r102, "cacheBusiness");
        this.f330712a = r100;
        this.f330713b = r101;
        this.f330714c = r102;
    }
}
