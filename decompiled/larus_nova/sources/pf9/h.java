package pf9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f528916d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f528913a, r101.f528913a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528914b, r101.f528914b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528915c, r101.f528915c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528916d, r101.f528916d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f528913a.hashCode() * 31) + this.f528914b.hashCode()) * 31) + this.f528915c.hashCode()) * 31) + this.f528916d.hashCode();
    }

    public final String toString() {
        return "FileResult(uploadId=" + this.f528913a + ", url=" + this.f528914b + ", uri=" + this.f528915c + ", fileBizInfo=" + this.f528916d + ')';
    }

    public h(String r100, String r101, String r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, "uploadId");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "uri");
        Intrinsics.checkNotNullParameter(r103, "fileBizInfo");
        this.f528913a = r100;
        this.f528914b = r101;
        this.f528915c = r102;
        this.f528916d = r103;
    }
}
