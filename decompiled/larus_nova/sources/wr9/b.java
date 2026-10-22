package wr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<Double> f560879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<Double> f560880b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f560879a, r101.f560879a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560880b, r101.f560880b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f560879a.hashCode() * 31) + this.f560880b.hashCode();
    }

    public final String toString() {
        return "CpuState(appUsagePercent=" + this.f560879a + ", appSpeedPercent=" + this.f560880b + ')';
    }

    public b(d<Double> r100, d<Double> r101) {
        Intrinsics.checkNotNullParameter(r100, "appUsagePercent");
        Intrinsics.checkNotNullParameter(r101, "appSpeedPercent");
        this.f560879a = r100;
        this.f560880b = r101;
    }
}
