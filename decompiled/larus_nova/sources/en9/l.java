package en9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f473227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f473229c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Float.compare(this.f473227a, r101.f473227a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f473228b, r101.f473228b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f473229c, r101.f473229c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f473227a) * 31) + this.f473228b.hashCode()) * 31) + Float.floatToIntBits(this.f473229c);
    }

    public final String toString() {
        return "ColorStop(alpha=" + this.f473227a + ", color=" + this.f473228b + ", offset=" + this.f473229c + ')';
    }

    public l(float r100, String r101, float r102) {
        Intrinsics.checkNotNullParameter(r101, "color");
        this.f473227a = r100;
        this.f473228b = r101;
        this.f473229c = r102;
    }
}
