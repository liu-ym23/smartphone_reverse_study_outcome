package nuc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes42.dex */
public final class z extends j2<double[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f520807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520808b;

    @Override // nuc.j2
    public final double[] a() {
        return Arrays.copyOf(this.f520807a, this.f520808b);
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520808b;
    }

    public z(double[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520807a = r100;
        this.f520808b = r100.length;
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        double[] r101 = this.f520807a;
        if (r101.length >= r100) goto L6;
        this.f520807a = Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, r101.length * 2));
        return;
    }
}
