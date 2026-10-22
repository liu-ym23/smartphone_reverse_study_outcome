package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f486545a;

    public b3() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b3) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f486545a, ((b3) r100).f486545a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f486545a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "LocationExtraInfo(bdLocation=" + this.f486545a + ')';
    }

    public b3(Object r100) {
        this.f486545a = r100;
    }
}
