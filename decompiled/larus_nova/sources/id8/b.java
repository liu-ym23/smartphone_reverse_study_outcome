package id8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f489362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f489363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f489364d;

    public b() {
        this(null, 0, 0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f489361a, r101.f489361a) == true) goto L12;
        return false;
    L12:
        if (this.f489362b == r101.f489362b) goto L15;
        return false;
    L15:
        if (this.f489363c == r101.f489363c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489364d, r101.f489364d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f489361a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f489362b) * 31) + this.f489363c) * 31;
        String r104 = this.f489364d;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImmutableImageObj(url=" + this.f489361a + ", width=" + this.f489362b + ", height=" + this.f489363c + ", format=" + this.f489364d + ')';
    }

    public b(String r100, int r101, int r102, String r103) {
        this.f489361a = r100;
        this.f489362b = r101;
        this.f489363c = r102;
        this.f489364d = r103;
    }
}
