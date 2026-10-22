package com.bytedance.ee.bear.share;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f237009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f237010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f237011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f237012d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f237009a, r101.f237009a) == true) goto L12;
        return false;
    L12:
        if (this.f237010b == r101.f237010b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f237011c, r101.f237011c) == true) goto L18;
        return false;
    L18:
        if (this.f237012d == r101.f237012d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f237009a.hashCode() * 31) + this.f237010b) * 31) + this.f237011c.hashCode()) * 31;
        if (this.f237012d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ReportShareClickParams(token=" + this.f237009a + ", type=" + this.f237010b + ", subType=" + this.f237011c + ", isWiki=" + this.f237012d + ')';
    }

    public final int getType() {
        return this.f237010b;
    }

    public c(String r100, int r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "subType");
        this.f237009a = r100;
        this.f237010b = r101;
        this.f237011c = r102;
        this.f237012d = r103;
    }
}
