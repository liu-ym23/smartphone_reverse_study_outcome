package sm4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f542569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f542570b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f542569a == r101.f542569a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542570b, r101.f542570b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f542569a * 31) + this.f542570b.hashCode();
    }

    public final String toString() {
        return "FileCategoryConfig(priority=" + this.f542569a + ", title=" + this.f542570b + ')';
    }

    public a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f542569a = r100;
        this.f542570b = r101;
    }
}
