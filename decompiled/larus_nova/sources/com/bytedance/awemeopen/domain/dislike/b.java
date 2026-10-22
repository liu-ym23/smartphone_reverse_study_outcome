package com.bytedance.awemeopen.domain.dislike;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f198319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198320b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f198319a, r101.f198319a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f198320b, r101.f198320b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f198319a.hashCode() * 31) + this.f198320b.hashCode();
    }

    public final String toString() {
        return "DislikeModelDm(authorOpenId=" + this.f198319a + ", aid=" + this.f198320b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "authorOpenId");
        Intrinsics.checkNotNullParameter(r101, "aid");
        this.f198319a = r100;
        this.f198320b = r101;
    }
}
