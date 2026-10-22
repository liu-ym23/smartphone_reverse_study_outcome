package eoa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473403b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f473402a, r101.f473402a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f473403b, r101.f473403b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f473402a.hashCode() * 31) + this.f473403b.hashCode();
    }

    public final String toString() {
        return "Item(title=" + this.f473402a + ", content=" + this.f473403b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f473402a = r100;
        this.f473403b = r101;
    }
}
