package g68;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h68.e f480172a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f480172a, ((b) r100).f480172a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f480172a.hashCode();
    }

    public final String toString() {
        return "Conflict(existingTask=" + this.f480172a + ')';
    }

    public b(h68.e r100) {
        Intrinsics.checkNotNullParameter(r100, "existingTask");
        this.f480172a = r100;
    }
}
