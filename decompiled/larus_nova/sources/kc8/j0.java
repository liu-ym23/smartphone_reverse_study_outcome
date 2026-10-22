package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f502511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f502512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f502513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f502514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f502515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f502516f;

    public j0() {
        this(null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f502511a, r101.f502511a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502512b, r101.f502512b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502513c, r101.f502513c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502514d, r101.f502514d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f502515e, r101.f502515e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f502516f, r101.f502516f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f502511a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f502512b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f502513c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f502514d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f502515e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f502516f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PureVideoColumnGridDecorationConfig(marginStart=" + this.f502511a + ", spaceHorizontal=" + this.f502512b + ", spaceVertical=" + this.f502513c + ", marginEnd=" + this.f502514d + ", marginTop=" + this.f502515e + ", marginBottom=" + this.f502516f + ')';
    }

    public j0(Integer r100, Integer r101, Integer r102, Integer r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 8) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 16) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 32) == 0) goto L14;
        r103 = null;
    L14:
        this.f502511a = r100;
        this.f502512b = null;
        this.f502513c = null;
        this.f502514d = r101;
        this.f502515e = r102;
        this.f502516f = r103;
    }
}
