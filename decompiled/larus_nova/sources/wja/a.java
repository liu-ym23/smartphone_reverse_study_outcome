package wja;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f560053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f560054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f560055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f560056e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f560052a, r101.f560052a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560053b, r101.f560053b) == true) goto L15;
        return false;
    L15:
        if (this.f560054c == r101.f560054c) goto L18;
        return false;
    L18:
        if (this.f560055d == r101.f560055d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f560056e, r101.f560056e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f560052a.hashCode() * 31) + this.f560053b.hashCode()) * 31;
        long r101 = this.f560054c;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f560055d) * 31) + this.f560056e.hashCode();
    }

    public final String toString() {
        return "TransferableFile(base=" + this.f560052a + ", originRelativePath=" + this.f560053b + ", size=" + this.f560054c + ", retryTimes=" + this.f560055d + ", newRelativePath=" + this.f560056e + ")";
    }

    public a(String r100, String r101, long r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "base");
        Intrinsics.checkNotNullParameter(r101, "originRelativePath");
        Intrinsics.checkNotNullParameter(r104, "newRelativePath");
        this.f560052a = r100;
        this.f560053b = r101;
        this.f560054c = r102;
        this.f560055d = r103;
        this.f560056e = r104;
    }
}
