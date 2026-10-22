package ts2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f547342a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f547342a, ((c) r100).f547342a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f547342a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ExtraWidgetLoadData(businessData=" + this.f547342a + ")";
    }

    public c() {
        this.f547342a = null;
    }
}
