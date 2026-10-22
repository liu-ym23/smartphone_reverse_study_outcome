package u16;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f548301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f548302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f548303d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f548300a, r101.f548300a) == true) goto L12;
        return false;
    L12:
        if (this.f548301b == r101.f548301b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f548302c, r101.f548302c) == true) goto L18;
        return false;
    L18:
        if (this.f548303d == r101.f548303d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f548300a.hashCode() * 31;
        long r101 = this.f548301b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f548302c.hashCode()) * 31;
        if (this.f548303d == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public final String toString() {
        return "{file:" + this.f548300a + ",duration:" + this.f548301b + ",from:" + this.f548302c + "},is_disabled=" + this.f548303d;
    }

    public c(String r100, long r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r102, "from");
        this.f548300a = r100;
        this.f548301b = r101;
        this.f548302c = r102;
        this.f548303d = r103;
    }
}
