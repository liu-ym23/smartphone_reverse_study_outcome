package com.larus.dora.o.impl.memory;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class z implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f338840a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f338840a, ((z) r100).f338840a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f338840a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "OMemoryEventGroup(timeString=" + this.f338840a + ')';
    }

    public z(String r100) {
        this.f338840a = r100;
    }
}
