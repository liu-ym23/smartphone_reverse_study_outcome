package vq;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f556749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f556750b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Float.compare(this.f556749a, r101.f556749a) == 0) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f556750b, r101.f556750b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.f556749a) * 31;
        List<d> r101 = this.f556750b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "BgGradientInputInfo(degree=" + this.f556749a + ", colors=" + this.f556750b + ")";
    }

    public b(float r100, List<d> r101) {
        this.f556749a = r100;
        this.f556750b = r101;
    }
}
