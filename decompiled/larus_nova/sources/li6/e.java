package li6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f509394a;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f509394a, ((e) r100).f509394a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        h r100 = this.f509394a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "RTCPerformanceProfiles(performanceLowVideoParam=" + this.f509394a + ")";
    }

    public e(int r100) {
        this.f509394a = null;
    }
}
