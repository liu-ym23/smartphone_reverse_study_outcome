package er5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473606b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f473605a, r101.f473605a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f473606b, r101.f473606b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f473605a.hashCode() * 31) + this.f473606b.hashCode();
    }

    public final String toString() {
        return "WorkspaceInfo(token=" + this.f473605a + ", name=" + this.f473606b + ')';
    }

    public i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f473605a = r100;
        this.f473606b = r101;
    }
}
