package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f474543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f474544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f474545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f474546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f474547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f474548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f474549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f474550h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f474543a, r101.f474543a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474544b, r101.f474544b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474545c, r101.f474545c) == true) goto L18;
        return false;
    L18:
        if (this.f474546d == r101.f474546d) goto L21;
        return false;
    L21:
        if (this.f474547e == r101.f474547e) goto L24;
        return false;
    L24:
        if (this.f474548f == r101.f474548f) goto L27;
        return false;
    L27:
        if (this.f474549g == r101.f474549g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f474550h, r101.f474550h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f474543a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f474544b.hashCode()) * 31;
        String r104 = this.f474545c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f474546d;
        int r108 = (((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f474547e) * 31) + this.f474548f) * 31;
        long r109 = this.f474549g;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.f474550h;
        if (r111 == null) goto L15;
        r101 = r111.hashCode();
    L15:
        return r110 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommentSelectedImage(id=" + this.f474543a + ", path=" + this.f474544b + ", mimeType=" + this.f474545c + ", duration=" + this.f474546d + ", width=" + this.f474547e + ", height=" + this.f474548f + ", size=" + this.f474549g + ", fileName=" + this.f474550h + ')';
    }

    public f(Integer r100, String r101, String r102, int r103, int r104, long r105, String r106) {
        Intrinsics.checkNotNullParameter(r101, "path");
        this.f474543a = r100;
        this.f474544b = r101;
        this.f474545c = r102;
        this.f474546d = 0;
        this.f474547e = r103;
        this.f474548f = r104;
        this.f474549g = r105;
        this.f474550h = r106;
    }
}
