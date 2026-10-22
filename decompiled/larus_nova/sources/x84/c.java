package x84;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f562903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f562904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f562905c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f562903a, r101.f562903a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f562904b, r101.f562904b) == 0) goto L15;
        return false;
    L15:
        if (this.f562905c == r101.f562905c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f562903a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f562904b);
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f562905c;
    }

    public final String toString() {
        return "TurfFeature(point=" + this.f562903a + ", dist=" + this.f562904b + ", index=" + this.f562905c + ")";
    }

    public c(f r100, double r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "point");
        this.f562903a = r100;
        this.f562904b = r101;
        this.f562905c = r102;
    }
}
