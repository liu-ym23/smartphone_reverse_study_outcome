package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0 f502485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0 f502486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g0 f502487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g0 f502488f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f502483a, r101.f502483a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502484b, r101.f502484b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502485c, r101.f502485c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502486d, r101.f502486d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f502487e, r101.f502487e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f502488f, r101.f502488f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f502483a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f502484b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g0 r107 = this.f502485c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        g0 r110 = this.f502486d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        g0 r113 = this.f502487e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        g0 r116 = this.f502488f;
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
        return "LocalCreationImageData(key=" + this.f502483a + ", requestId=" + this.f502484b + ", origin=" + this.f502485c + ", thumb=" + this.f502486d + ", preview=" + this.f502487e + ", raw=" + this.f502488f + ')';
    }

    public f0(String r100, String r101, g0 r102, g0 r103, g0 r104, g0 r105) {
        this.f502483a = r100;
        this.f502484b = r101;
        this.f502485c = r102;
        this.f502486d = r103;
        this.f502487e = r104;
        this.f502488f = r105;
    }
}
