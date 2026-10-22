package g0a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479506a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f479506a, ((h) r100).f479506a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f479506a.hashCode();
    }

    public final String toString() {
        return "MobClickCreateButtonParamsKmp(currentPage=" + this.f479506a + ')';
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        this.f479506a = r100;
    }
}
