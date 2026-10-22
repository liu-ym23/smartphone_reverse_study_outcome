package o8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f522331a;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f522331a, ((f) r100).f522331a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f522331a.hashCode();
    }

    public final String toString() {
        return "MonitorConfig(virtualAid=" + this.f522331a + ')';
    }

    public f(int r100) {
        Intrinsics.checkNotNullParameter("88888", "virtualAid");
        this.f522331a = "88888";
    }
}
