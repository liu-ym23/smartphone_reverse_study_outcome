package nuc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes42.dex */
public final class g extends j2<boolean[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean[] f520677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520678b;

    @Override // nuc.j2
    public final boolean[] a() {
        return Arrays.copyOf(this.f520677a, this.f520678b);
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520678b;
    }

    public g(boolean[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520677a = r100;
        this.f520678b = r100.length;
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        boolean[] r101 = this.f520677a;
        if (r101.length >= r100) goto L6;
        this.f520677a = Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, r101.length * 2));
        return;
    }
}
