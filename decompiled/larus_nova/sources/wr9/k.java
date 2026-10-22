package wr9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<Integer> f560900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d<List<Long>> f560901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<Integer> f560902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d<Integer> f560903d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f560900a, r101.f560900a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560901b, r101.f560901b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f560902c, r101.f560902c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f560903d, r101.f560903d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f560900a.hashCode() * 31) + this.f560901b.hashCode()) * 31) + this.f560902c.hashCode()) * 31) + this.f560903d.hashCode();
    }

    public final String toString() {
        return "StaticCpuProfile(logicalCoreCount=" + this.f560900a + ", coreMaxFrequencyKhz=" + this.f560901b + ", littleCoreCount=" + this.f560902c + ", bigCoreCount=" + this.f560903d + ')';
    }

    public k(d<Integer> r100, d<List<Long>> r101, d<Integer> r102, d<Integer> r103) {
        Intrinsics.checkNotNullParameter(r100, "logicalCoreCount");
        Intrinsics.checkNotNullParameter(r101, "coreMaxFrequencyKhz");
        Intrinsics.checkNotNullParameter(r102, "littleCoreCount");
        Intrinsics.checkNotNullParameter(r103, "bigCoreCount");
        this.f560900a = r100;
        this.f560901b = r101;
        this.f560902c = r102;
        this.f560903d = r103;
    }
}
