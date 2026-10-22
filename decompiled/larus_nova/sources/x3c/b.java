package x3c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f562417c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f562415a, r101.f562415a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562416b, r101.f562416b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f562417c, r101.f562417c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f562415a.hashCode() * 31) + this.f562416b.hashCode()) * 31) + this.f562417c.hashCode();
    }

    public final String toString() {
        return "RecFilterData(id=" + this.f562415a + ", avatarKey=" + this.f562416b + ", title=" + this.f562417c + ')';
    }

    public b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "avatarKey");
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f562415a = r100;
        this.f562416b = r101;
        this.f562417c = r102;
    }
}
