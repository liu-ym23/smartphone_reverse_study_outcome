package xw6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565256a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f565256a, ((d) r100).f565256a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f565256a.hashCode();
    }

    public final String toString() {
        return "DowngradeInfo(url=" + this.f565256a + ')';
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f565256a = r100;
    }
}
