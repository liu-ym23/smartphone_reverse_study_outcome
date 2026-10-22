package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474581a;

    public n() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f474581a, ((n) r100).f474581a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474581a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "CommonFileSelectorRequest(srcObjToken=" + this.f474581a + ')';
    }

    public n(String r100) {
        this.f474581a = r100;
    }
}
