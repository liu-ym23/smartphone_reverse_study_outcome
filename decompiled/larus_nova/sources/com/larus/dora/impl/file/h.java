package com.larus.dora.impl.file;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraFileFetchTask f335745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraFileStreamingSinkReason f335746b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f335745a, r101.f335745a) == true) goto L12;
        return false;
    L12:
        if (this.f335746b == r101.f335746b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f335745a.hashCode() * 31) + this.f335746b.hashCode();
    }

    public final String toString() {
        return "DoraFileStreamingSinkTaskWrapper(task=" + this.f335745a + ", reason=" + this.f335746b + ')';
    }

    public h(DoraFileFetchTask r100, DoraFileStreamingSinkReason r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f335745a = r100;
        this.f335746b = r101;
    }
}
