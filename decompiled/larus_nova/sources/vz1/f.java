package vz1;

import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f557676a;

    public f() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f557676a, ((f) r100).f557676a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        k r100 = this.f557676a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "GiftBottomLabelInfo(bottomLabel=" + this.f557676a + ")";
    }

    public f(k r100) {
        this.f557676a = r100;
    }
}
