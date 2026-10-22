package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f313701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f313702b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f313701a, r101.f313701a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313702b, r101.f313702b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f313701a.hashCode() * 31) + this.f313702b.hashCode();
    }

    public final String toString() {
        return "ResourceNodeExecutionResult(node=" + this.f313701a + ", result=" + this.f313702b + ')';
    }

    public m0(l0 r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f313701a = r100;
        this.f313702b = r101;
    }
}
