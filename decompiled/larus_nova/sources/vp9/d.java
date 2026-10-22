package vp9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final op9.d f556672a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f556672a, ((d) r100).f556672a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f556672a.hashCode();
    }

    public final String toString() {
        return "CurSelected(curSelectedUIMediaItem=" + this.f556672a + ')';
    }

    public d(op9.d r100) {
        Intrinsics.checkNotNullParameter(r100, "curSelectedUIMediaItem");
        this.f556672a = r100;
    }
}
