package mtb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515694a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f515694a, ((l) r100).f515694a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f515694a.hashCode();
    }

    public final String toString() {
        return "OfficeQrcodePageIntent(from=" + this.f515694a + ')';
    }

    public l() {
        Intrinsics.checkNotNullParameter("", "from");
        this.f515694a = "";
    }
}
