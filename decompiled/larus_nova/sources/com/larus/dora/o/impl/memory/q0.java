package com.larus.dora.o.impl.memory;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f338829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f338830b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.f338829a, r101.f338829a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f338830b, r101.f338830b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        p0 r100 = this.f338829a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f338830b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OPersonalMemoryMutationResult(data=" + this.f338829a + ", code=" + this.f338830b + ')';
    }

    public q0(p0 r100, Long r101) {
        this.f338829a = r100;
        this.f338830b = r101;
    }
}
