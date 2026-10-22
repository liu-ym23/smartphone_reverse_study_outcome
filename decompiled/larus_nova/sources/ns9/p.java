package ns9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f520401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f520402b;

    public p() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f520401a, r101.f520401a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520402b, r101.f520402b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f520401a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        m r104 = this.f520402b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachNotifyEvent(cmdType=" + this.f520401a + ", reachNotify=" + this.f520402b + ')';
    }

    public p(Integer r100, m r101) {
        this.f520401a = r100;
        this.f520402b = r101;
    }
}
