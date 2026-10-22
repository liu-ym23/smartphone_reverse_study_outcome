package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f465946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f465947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f465948c;

    public y() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f465946a, r101.f465946a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465947b, r101.f465947b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465948c, r101.f465948c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f465946a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f465947b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f465948c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasTabExtra(isSupportRefImage=" + this.f465946a + ", effectMode=" + this.f465947b + ", abilityType=" + this.f465948c + ')';
    }

    public y(Boolean r100, Integer r101, Integer r102) {
        this.f465946a = r100;
        this.f465947b = r101;
        this.f465948c = r102;
    }
}
