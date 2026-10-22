package sf0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f541710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f541711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f541712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f541713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f541714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f541715f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (this.f541710a == r101.f541710a) goto L8;
        return false;
    L8:
        if (this.f541711b == r101.f541711b) goto L10;
        return false;
    L10:
        if (this.f541712c == r101.f541712c) goto L12;
        return false;
    L12:
        if (this.f541713d == r101.f541713d) goto L14;
        return false;
    L14:
        if (this.f541714e == r101.f541714e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f541715f, r101.f541715f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f541710a * 31) + this.f541711b) * 31) + this.f541712c) * 31) + this.f541713d) * 31) + this.f541714e) * 31;
        c r101 = this.f541715f;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "DynamicSeatItemFrameInfo(position=" + this.f541710a + ", x=" + this.f541711b + ", y=" + this.f541712c + ", width=" + this.f541713d + ", height=" + this.f541714e + ", avatar=" + this.f541715f + ")";
    }

    public d(int r100, int r101, int r102, int r103, int r104, c r105) {
        this.f541710a = r100;
        this.f541711b = r101;
        this.f541712c = r102;
        this.f541713d = r103;
        this.f541714e = r104;
        this.f541715f = r105;
    }
}
