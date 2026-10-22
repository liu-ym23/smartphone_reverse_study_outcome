package ry9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f539945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f539946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f539947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f539948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f539949f;

    public k() {
        this(null, null, 0, false, false, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f539944a, r101.f539944a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f539945b, r101.f539945b) == true) goto L15;
        return false;
    L15:
        if (this.f539946c == r101.f539946c) goto L18;
        return false;
    L18:
        if (this.f539947d == r101.f539947d) goto L21;
        return false;
    L21:
        if (this.f539948e == r101.f539948e) goto L24;
        return false;
    L24:
        if (this.f539949f == r101.f539949f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f539944a.hashCode() * 31) + this.f539945b.hashCode()) * 31;
        long r101 = this.f539946c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        int r103 = 1231;
        if (this.f539947d == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f539948e == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r105 + r106) * 31;
        if (this.f539949f == true) goto L15;
        r103 = 1237;
    L15:
        return r107 + r103;
    L9:
        r106 = 1237;
        goto L10
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "MultiMediaSelectorStatus(resourceKey=" + this.f539944a + ", status=" + this.f539945b + ", progress=" + this.f539946c + ", isPrivate=" + this.f539947d + ", isAvatar=" + this.f539948e + ", hideLoading=" + this.f539949f + ')';
    }

    public k(String r100, j r101, long r102, boolean r103, boolean r104, boolean r105, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = j.b.f539937b;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = false;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = false;
    L18:
        if ((r110 & 32) == 0) goto L20;
        r105 = false;
    L20:
        Intrinsics.checkNotNullParameter(r100, "resourceKey");
        Intrinsics.checkNotNullParameter(r101, "status");
        this.f539944a = r100;
        this.f539945b = r101;
        this.f539946c = r102;
        this.f539947d = r103;
        this.f539948e = r104;
        this.f539949f = r105;
    }
}
