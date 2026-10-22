package nuc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes42.dex */
public final class s2 extends j2<short[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f520773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520774b;

    @Override // nuc.j2
    public final short[] a() {
        return Arrays.copyOf(this.f520773a, this.f520774b);
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520774b;
    }

    public s2(short[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520773a = r100;
        this.f520774b = r100.length;
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        short[] r101 = this.f520773a;
        if (r101.length >= r100) goto L6;
        this.f520773a = Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, r101.length * 2));
        return;
    }
}
