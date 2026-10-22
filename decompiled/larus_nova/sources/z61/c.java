package z61;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f570449a;

    public c() {
        this(1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f570449a, ((c) r100).f570449a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f570449a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "MsgWindowPreparedEvent(screenOrientation=" + this.f570449a + ")";
    }

    public c(Integer r100) {
        this.f570449a = r100;
    }
}
