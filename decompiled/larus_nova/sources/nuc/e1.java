package nuc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes42.dex */
public final class e1 extends j2<long[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f520666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520667b;

    @Override // nuc.j2
    public final long[] a() {
        return Arrays.copyOf(this.f520666a, this.f520667b);
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520667b;
    }

    public e1(long[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520666a = r100;
        this.f520667b = r100.length;
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        long[] r101 = this.f520666a;
        if (r101.length >= r100) goto L6;
        this.f520666a = Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, r101.length * 2));
        return;
    }
}
