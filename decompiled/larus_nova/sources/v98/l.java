package v98;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f553832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f553833d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f553830a, r101.f553830a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553831b, r101.f553831b) == true) goto L15;
        return false;
    L15:
        if (this.f553832c == r101.f553832c) goto L18;
        return false;
    L18:
        if (this.f553833d == r101.f553833d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f553830a.hashCode() * 31) + this.f553831b.hashCode()) * 31;
        long r101 = this.f553832c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f553833d;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "DumpedFileInfo(filePath=" + this.f553830a + ", fileName=" + this.f553831b + ", sizeBytes=" + this.f553832c + ", creationTime=" + this.f553833d + ')';
    }

    public l(String r100, String r101, long r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        this.f553830a = r100;
        this.f553831b = r101;
        this.f553832c = r102;
        this.f553833d = r103;
    }
}
