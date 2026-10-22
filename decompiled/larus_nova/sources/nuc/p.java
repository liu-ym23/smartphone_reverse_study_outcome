package nuc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes42.dex */
public final class p extends j2<char[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f520749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520750b;

    @Override // nuc.j2
    public final char[] a() {
        return Arrays.copyOf(this.f520749a, this.f520750b);
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520750b;
    }

    public p(char[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520749a = r100;
        this.f520750b = r100.length;
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        char[] r101 = this.f520749a;
        if (r101.length >= r100) goto L6;
        this.f520749a = Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, r101.length * 2));
        return;
    }
}
