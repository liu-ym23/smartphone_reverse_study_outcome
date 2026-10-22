package com.larus.home.impl.main.side_bar.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f344503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f344504b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h1) == true) goto L8;
        return false;
    L8:
        h1 r101 = (h1) r100;
        if (Intrinsics.areEqual(this.f344503a, r101.f344503a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344504b, r101.f344504b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f344503a.hashCode() * 31) + this.f344504b.hashCode();
    }

    public final String toString() {
        return "UserExpandState(userId=" + this.f344503a + ", cache=" + this.f344504b + ')';
    }

    public h1(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "cache");
        this.f344503a = r100;
        this.f344504b = r101;
    }
}
