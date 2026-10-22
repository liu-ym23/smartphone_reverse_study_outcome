package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f474576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f474577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f474578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f474579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f474580g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f474574a, r101.f474574a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474575b, r101.f474575b) == true) goto L15;
        return false;
    L15:
        if (this.f474576c == r101.f474576c) goto L18;
        return false;
    L18:
        if (this.f474577d == r101.f474577d) goto L21;
        return false;
    L21:
        if (this.f474578e == r101.f474578e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474579f, r101.f474579f) == true) goto L27;
        return false;
    L27:
        if (this.f474580g == r101.f474580g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f474574a.hashCode() * 31;
        String r101 = this.f474575b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f474576c) * 31) + this.f474577d) * 31;
        long r105 = this.f474578e;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.f474579f;
        if (r107 == null) goto L10;
        r102 = r107.hashCode();
    L10:
        int r108 = (r106 + r102) * 31;
        if (this.f474580g == false) goto L13;
        int r109 = 1231;
    L15:
        return r108 + r109;
    L13:
        r109 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonFileBean(path=" + this.f474574a + ", mimeType=" + this.f474575b + ", width=" + this.f474576c + ", height=" + this.f474577d + ", size=" + this.f474578e + ", compressPath=" + this.f474579f + ", isOrigin=" + this.f474580g + ')';
    }

    public l(String r100, String r101, int r102, int r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f474574a = r100;
        this.f474575b = r101;
        this.f474576c = r102;
        this.f474577d = r103;
        this.f474578e = r104;
        this.f474579f = null;
        this.f474580g = false;
    }
}
