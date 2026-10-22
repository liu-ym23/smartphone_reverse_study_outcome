package com.ss.android.lark.location.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MapSource f431207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SearchResultErrorCode f431208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f431209c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f431207a == r101.f431207a) goto L12;
        return false;
    L12:
        if (this.f431208b == r101.f431208b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f431209c, r101.f431209c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f431207a.hashCode() * 31) + this.f431208b.hashCode()) * 31) + this.f431209c.hashCode();
    }

    public final String toString() {
        return "SearchResultError(source=" + this.f431207a + ", errorCode=" + this.f431208b + ", rawErrorCode=" + this.f431209c + ')';
    }

    public k(MapSource r100, SearchResultErrorCode r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        Intrinsics.checkNotNull(Integer.valueOf(r102), "null cannot be cast to non-null type kotlin.Any");
        Integer r103 = Integer.valueOf(r102);
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        Intrinsics.checkNotNullParameter(r103, "rawErrorCode");
        this.f431207a = r100;
        this.f431208b = r101;
        this.f431209c = r103;
    }
}
