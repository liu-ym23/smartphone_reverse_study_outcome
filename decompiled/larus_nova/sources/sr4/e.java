package sr4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f543227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f543228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f543229c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f543227a == r101.f543227a) goto L12;
        return false;
    L12:
        if (this.f543228b == r101.f543228b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f543229c, r101.f543229c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f543227a * 31) + this.f543228b) * 31;
        Integer r101 = this.f543229c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "RatingStarSizeInfo(iconSize=" + this.f543227a + ", starPadding=" + this.f543228b + ", iconTextMargin=" + this.f543229c + ')';
    }

    public e(int r100, int r101, Integer r102) {
        this.f543227a = r100;
        this.f543228b = r101;
        this.f543229c = r102;
    }
}
