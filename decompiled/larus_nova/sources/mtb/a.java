package mtb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f515659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515660b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f515659a == r101.f515659a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515660b, r101.f515660b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f515659a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f515660b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ContactPageModel(isSidebarExperiment=" + this.f515659a + ", from=" + this.f515660b + ')';
    }

    public a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        this.f515659a = r100;
        this.f515660b = r101;
    }
}
