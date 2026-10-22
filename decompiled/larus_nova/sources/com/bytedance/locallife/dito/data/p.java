package com.bytedance.locallife.dito.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FmpType f258229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f258230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f258231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f258232d;

    public final FmpType getType() {
        return this.f258229a;
    }

    public p(FmpType r100, long r101, boolean r102, long r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f258229a = r100;
        this.f258230b = r101;
        this.f258231c = r102;
        this.f258232d = r103;
    }
}
