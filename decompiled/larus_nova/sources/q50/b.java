package q50;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f531722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f531723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f531724c;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f531722a, r101.f531722a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f531723b, r101.f531723b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f531724c, r101.f531724c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        a r100 = this.f531722a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.f531723b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.f531724c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnimationLayers(backgroundLayer=" + this.f531722a + ", frontendLayer=" + this.f531723b + ", overMp4Layer=" + this.f531724c + ")";
    }

    public b(a r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = null;
    L5:
        this.f531722a = null;
        this.f531723b = r100;
        this.f531724c = null;
    }
}
