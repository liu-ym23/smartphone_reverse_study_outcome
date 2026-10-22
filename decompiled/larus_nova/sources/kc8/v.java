package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f502579a;

    public v() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f502579a, ((v) r100).f502579a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f502579a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ElapsedBlockUIConfig(defaultCollapsed=" + this.f502579a + ')';
    }

    public v(Boolean r100) {
        this.f502579a = r100;
    }
}
