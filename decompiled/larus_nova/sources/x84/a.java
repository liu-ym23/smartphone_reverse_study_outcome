package x84;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f562898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f562899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f562900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f562901d;

    /* JADX INFO: renamed from: x84.a$a, reason: collision with other inner class name */
    public static final class C8202a {
    }

    static {
    }

    public a() {
        this(null, null, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f562898a, r101.f562898a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562899b, r101.f562899b) == true) goto L15;
        return false;
    L15:
        if (this.f562900c == r101.f562900c) goto L18;
        return false;
    L18:
        if (this.f562901d == r101.f562901d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Double r100 = this.f562898a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.f562899b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.f562900c == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f562901d == true) goto L19;
        r106 = 1237;
    L19:
        return r108 + r106;
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LineIntersectsResult(horizontalIntersection=" + this.f562898a + ", verticalIntersection=" + this.f562899b + ", onLine1=" + this.f562900c + ", onLine2=" + this.f562901d + ")";
    }

    public a(Double r100, Double r101, boolean r102, boolean r103) {
        this.f562898a = r100;
        this.f562899b = r101;
        this.f562900c = r102;
        this.f562901d = r103;
    }
}
