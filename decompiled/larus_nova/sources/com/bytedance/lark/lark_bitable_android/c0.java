package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f252989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f252990b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f252989a, r101.f252989a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f252990b, r101.f252990b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f252989a.hashCode() * 31) + this.f252990b.hashCode();
    }

    public final String toString() {
        return "HomepageCreateBitableResult(url=" + this.f252989a + ", token=" + this.f252990b + ')';
    }

    public c0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "token");
        this.f252989a = r100;
        this.f252990b = r101;
    }
}
