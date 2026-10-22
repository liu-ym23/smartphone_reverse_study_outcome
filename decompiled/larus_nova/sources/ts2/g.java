package ts2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f547346a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f547346a, ((g) r100).f547346a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f547346a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OnCurrentPageSelectedData(isSelect=" + this.f547346a + ")";
    }

    public g() {
        this(Boolean.FALSE);
    }

    public g(Boolean r100) {
        this.f547346a = r100;
    }
}
