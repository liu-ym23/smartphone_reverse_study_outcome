package com.bytedance.locallife.biz.collect.guide;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f256580b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f256579a, r101.f256579a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f256580b, r101.f256580b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f256579a.hashCode() * 31) + this.f256580b.hashCode();
    }

    public final String toString() {
        return "EffectiveEvent(traceSessionId=" + this.f256579a + ", type=" + this.f256580b + ')';
    }

    public final String getType() {
        return this.f256580b;
    }

    public g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "traceSessionId");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f256579a = r100;
        this.f256580b = r101;
    }
}
