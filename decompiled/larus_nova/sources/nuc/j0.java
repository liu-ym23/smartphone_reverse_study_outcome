package nuc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes42.dex */
public final class j0 extends j2<float[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f520714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520715b;

    @Override // nuc.j2
    public final float[] a() {
        return Arrays.copyOf(this.f520714a, this.f520715b);
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520715b;
    }

    public j0(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520714a = r100;
        this.f520715b = r100.length;
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        float[] r101 = this.f520714a;
        if (r101.length >= r100) goto L6;
        this.f520714a = Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, r101.length * 2));
        return;
    }
}
