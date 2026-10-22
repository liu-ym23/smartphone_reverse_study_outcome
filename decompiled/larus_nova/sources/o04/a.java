package o04;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f521631b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f521630a, r101.f521630a) == true) goto L12;
        return false;
    L12:
        if (this.f521631b == r101.f521631b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f521630a.hashCode() * 31) + this.f521631b;
    }

    public final String toString() {
        return "AosFragmentCreatedEvent(fragmentName=" + this.f521630a + ", pagerIndex=" + this.f521631b + ')';
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentName");
        this.f521630a = r100;
        this.f521631b = r101;
    }
}
