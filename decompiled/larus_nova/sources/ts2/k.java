package ts2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f547352a;

    public k() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f547352a, ((k) r100).f547352a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f547352a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OnPageSelectData(position=" + this.f547352a + ")";
    }

    public k(Integer r100) {
        this.f547352a = r100;
    }
}
