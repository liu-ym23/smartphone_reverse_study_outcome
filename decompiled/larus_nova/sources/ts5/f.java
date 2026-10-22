package ts5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547403b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f547402a, r101.f547402a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547403b, r101.f547403b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f547402a.hashCode() * 31) + this.f547403b.hashCode();
    }

    public final String toString() {
        return "NativeSubComponentParams(id=" + this.f547402a + ", viewType=" + this.f547403b + ')';
    }

    public f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "viewType");
        this.f547402a = r100;
        this.f547403b = r101;
    }
}
