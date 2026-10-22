package mtb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f515673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515674b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f515673a, r101.f515673a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515674b, r101.f515674b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f515673a.hashCode() * 31) + this.f515674b.hashCode();
    }

    public final String toString() {
        return "OfficeContactSearchPageModel(keyword=" + this.f515673a + ", from=" + this.f515674b + ')';
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        Intrinsics.checkNotNullParameter("global_search", "from");
        this.f515673a = r100;
        this.f515674b = "global_search";
    }
}
