package laa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f508226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f508227b;

    public o() {
        this(0.5f, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Float.compare(this.f508226a, r101.f508226a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508227b, r101.f508227b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.f508226a) * 31;
        Long r101 = this.f508227b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ObricMessageVisibilityConfig(minVisibleRatio=" + this.f508226a + ", visibleDurationMs=" + this.f508227b + ')';
    }

    public o(float r100, Long r101) {
        this.f508226a = r100;
        this.f508227b = r101;
    }
}
