package com.larus.bmhome.clarification;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f310618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f310619b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v1) == true) goto L8;
        return false;
    L8:
        v1 r101 = (v1) r100;
        if (Intrinsics.areEqual(this.f310618a, r101.f310618a) == true) goto L12;
        return false;
    L12:
        if (this.f310619b == r101.f310619b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f310618a.hashCode() * 31) + this.f310619b;
    }

    public final String toString() {
        return "ClarificationInputSnapshot(text=" + this.f310618a + ", status=" + this.f310619b + ')';
    }

    public v1(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f310618a = r100;
        this.f310619b = r101;
    }
}
