package xa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f563025b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f563024a, r101.f563024a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f563025b, r101.f563025b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f563024a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f563025b);
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "PredictionData(sceneId=" + this.f563024a + ", confidence=" + this.f563025b + ')';
    }

    public c(String r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        this.f563024a = r100;
        this.f563025b = r101;
    }
}
