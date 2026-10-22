package k90;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f502138a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        r101.getClass();
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L20;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L21;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == false) goto L22;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        if (Float.compare(this.f502138a, r101.f502138a) == 0) goto L25;
        return false;
    L25:
        return true;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L16:
        return false;
    }

    public final int getType() {
        return 0;
    }

    public final int hashCode() {
        return (((((((((0 * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + Float.floatToIntBits(this.f502138a);
    }

    public final String toString() {
        return "LensData(type=0, sticker=null, icon=null, name=null, LensTabDatas=null, defaultValue=" + this.f502138a + ")";
    }
}
