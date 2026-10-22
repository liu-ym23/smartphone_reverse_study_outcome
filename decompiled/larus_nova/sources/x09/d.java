package x09;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f562052b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f562051a, r101.f562051a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f562052b, r101.f562052b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f562051a.hashCode() * 31) + Float.floatToIntBits(this.f562052b);
    }

    public final String toString() {
        return "GradientStop(color=" + this.f562051a + ", position=" + this.f562052b + ')';
    }

    public d(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "color");
        this.f562051a = r100;
        this.f562052b = r101;
    }
}
