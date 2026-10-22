package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f474454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f474455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x f474456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y f474457d;

    public z() {
        this(false, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (this.f474454a == r101.f474454a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474455b, r101.f474455b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474456c, r101.f474456c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474457d, r101.f474457d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f474454a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        w r102 = this.f474455b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        x r106 = this.f474456c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        y r109 = this.f474457d;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShelfProductPoiUIData(visible=" + this.f474454a + ", poiDistanceUIData=" + this.f474455b + ", poiNameUIData=" + this.f474456c + ", poiTipUIData=" + this.f474457d + ')';
    }

    public z(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this.f474454a = r100;
        this.f474455b = null;
        this.f474456c = null;
        this.f474457d = null;
    }
}
