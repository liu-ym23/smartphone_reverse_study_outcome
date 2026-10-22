package fh1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f476956a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f476956a, ((a) r100).f476956a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f476956a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "DebugFirstScreenEvent(message=" + this.f476956a + ")";
    }

    public a(Object r100) {
        this.f476956a = r100;
    }
}
