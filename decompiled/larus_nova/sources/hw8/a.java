package hw8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487429b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f487428a, r101.f487428a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f487429b, r101.f487429b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f487428a.hashCode() * 31) + this.f487429b.hashCode();
    }

    public final String toString() {
        return "CitationInfo(content=" + this.f487428a + ", url=" + this.f487429b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f487428a = r100;
        this.f487429b = r101;
    }
}
