package k88;

import ey9.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f502114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ey9.a f502115b;

    public d() {
        this(null, null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f502114a, r101.f502114a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502115b, r101.f502115b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        k r100 = this.f502114a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ey9.a r104 = this.f502115b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DigitalAvatarMaterialGalleryData(preGenImage=" + this.f502114a + ", refVideo=" + this.f502115b + ')';
    }

    public d(k r100, ey9.a r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f502114a = r100;
        this.f502115b = r101;
    }
}
