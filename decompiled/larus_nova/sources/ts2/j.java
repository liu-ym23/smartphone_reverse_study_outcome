package ts2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f547350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f547351b;

    public j() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f547350a, r101.f547350a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f547351b, r101.f547351b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f547350a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f547351b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OnPageScrollStateChangedData(state=" + this.f547350a + ", position=" + this.f547351b + ")";
    }

    public /* synthetic */ j(Integer r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public j(Integer r100, Integer r101) {
        this.f547350a = r100;
        this.f547351b = r101;
    }
}
