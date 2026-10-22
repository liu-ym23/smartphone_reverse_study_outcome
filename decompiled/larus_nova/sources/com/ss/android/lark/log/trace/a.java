package com.ss.android.lark.log.trace;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f431419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f431420b;

    public final long a() {
        long r100 = this.f431419a;
        if (r100 <= 0) goto L7;
        long r101 = this.f431420b;
        if (r101 <= 0) goto L7;
        return r101 - r100;
    L7:
        return -1;
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "step");
        this.f431419a = 0;
        this.f431420b = -1;
    }
}
