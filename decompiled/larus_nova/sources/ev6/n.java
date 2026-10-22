package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f474389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f474390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f474391c;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f474389a, r101.f474389a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474390b, r101.f474390b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474391c, r101.f474391c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474389a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f474390b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.f474391c;
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
        return "ShelfProductImgInfoUIData(imgUrl=" + this.f474389a + ", height=" + this.f474390b + ", width=" + this.f474391c + ')';
    }

    public n(int r100) {
        this.f474389a = null;
        this.f474390b = null;
        this.f474391c = null;
    }
}
