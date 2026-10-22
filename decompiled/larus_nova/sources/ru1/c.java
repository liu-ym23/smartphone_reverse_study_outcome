package ru1;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import su1.e;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f539250a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f539250a, ((c) r100).f539250a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<e> r100 = this.f539250a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OperationSet(operations=" + this.f539250a + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends e> r100) {
        Intrinsics.checkNotNullParameter(r100, "operations");
        this.f539250a = r100;
    }
}
