package com.bytedance.ee.bear.middleground.comment.input.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f232010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f232011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f232012c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f232010a == r101.f232010a) goto L12;
        return false;
    L12:
        if (this.f232011b == r101.f232011b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f232012c, r101.f232012c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f232010a * 31) + this.f232011b) * 31) + this.f232012c.hashCode();
    }

    public final String toString() {
        return "UserSpanRange(start=" + this.f232010a + ", end=" + this.f232011b + ", token=" + this.f232012c + ')';
    }

    public g(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "token");
        this.f232010a = r100;
        this.f232011b = r101;
        this.f232012c = r102;
    }
}
