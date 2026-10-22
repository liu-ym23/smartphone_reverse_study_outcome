package ts2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f547359a;

    public p() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f547359a, ((p) r100).f547359a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f547359a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OnSetUserVisibleHintData(isVisibleToUser=" + this.f547359a + ")";
    }

    public p(Boolean r100) {
        this.f547359a = r100;
    }
}
