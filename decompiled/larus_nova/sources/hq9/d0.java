package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g4 f486568a;

    public d0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f486568a, ((d0) r100).f486568a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        g4 r100 = this.f486568a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "CapabilitiesConfig(rtc=" + this.f486568a + ')';
    }

    public d0(g4 r100) {
        this.f486568a = r100;
    }
}
