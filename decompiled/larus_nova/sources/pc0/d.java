package pc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f528467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f528468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f528469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f528470e;

    public d() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (this.f528466a == r101.f528466a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f528467b, r101.f528467b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f528468c, r101.f528468c) == true) goto L12;
        return false;
    L12:
        if (this.f528469d == r101.f528469d) goto L14;
        return false;
    L14:
        if (this.f528470e == r101.f528470e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f528466a * 31;
        Integer r101 = this.f528467b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f528468c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return ((((r104 + r102) * 31) + this.f528469d) * 31) + this.f528470e;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "PkExposeData(leftTime=" + this.f528466a + ", pkState=" + this.f528467b + ", playMode=" + this.f528468c + ", iconId=" + this.f528469d + ", loadStatus=" + this.f528470e + ")";
    }

    public /* synthetic */ d(Integer r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = null;
    L5:
        this(0, r100, null, 0, 0);
    }

    public d(int r100, Integer r101, Integer r102, int r103, int r104) {
        this.f528466a = r100;
        this.f528467b = r101;
        this.f528468c = r102;
        this.f528469d = r103;
        this.f528470e = r104;
    }
}
