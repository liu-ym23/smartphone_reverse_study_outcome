package com.larus.bmhome.taskskill.network;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f314379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f314380b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f314379a, r101.f314379a) == true) goto L12;
        return false;
    L12:
        if (this.f314380b == r101.f314380b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f314379a.hashCode() * 31) + this.f314380b;
    }

    public final String toString() {
        return "RemotePcAuthorizationMeta(availableModeValues=" + this.f314379a + ", selectedModeValue=" + this.f314380b + ')';
    }

    public g(List<Integer> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "availableModeValues");
        this.f314379a = r100;
        this.f314380b = r101;
    }
}
