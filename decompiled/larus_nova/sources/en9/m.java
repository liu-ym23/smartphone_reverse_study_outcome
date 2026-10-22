package en9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f473230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<l> f473232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f473233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f473234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f473235f;

    public m() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f473230a == r101.f473230a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f473231b, r101.f473231b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f473232c, r101.f473232c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f473233d, r101.f473233d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f473234e, r101.f473234e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f473235f, r101.f473235f) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f473230a * 31) + this.f473231b.hashCode()) * 31) + this.f473232c.hashCode()) * 31) + Float.floatToIntBits(this.f473233d)) * 31) + Float.floatToIntBits(this.f473234e)) * 31) + Float.floatToIntBits(this.f473235f);
    }

    public final String toString() {
        return "GradientDetail(angle=" + this.f473230a + ", gradientType=" + this.f473231b + ", colorStops=" + this.f473232c + ", centerX=" + this.f473233d + ", centerY=" + this.f473234e + ", radius=" + this.f473235f + ')';
    }

    public m(int r100, String r101, List r102) {
        Intrinsics.checkNotNullParameter(r101, "gradientType");
        Intrinsics.checkNotNullParameter(r102, "colorStops");
        this.f473230a = r100;
        this.f473231b = r101;
        this.f473232c = r102;
        this.f473233d = 0.5f;
        this.f473234e = 0.5f;
        this.f473235f = 1.0f;
    }
}
