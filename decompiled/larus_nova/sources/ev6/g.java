package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f474315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0 f474316b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f474315a, r101.f474315a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474316b, r101.f474316b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f474315a.hashCode() * 31) + this.f474316b.hashCode();
    }

    public final String toString() {
        return "ShelfIndustryTagUIData(tagImage=" + this.f474315a + ", tagText=" + this.f474316b + ')';
    }

    public g(f r100, n0 r101) {
        Intrinsics.checkNotNullParameter(r100, "tagImage");
        Intrinsics.checkNotNullParameter(r101, "tagText");
        this.f474315a = r100;
        this.f474316b = r101;
    }
}
