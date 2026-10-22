package mtb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f515692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515693b;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f515692a == r101.f515692a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515693b, r101.f515693b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f515692a * 31) + this.f515693b.hashCode();
    }

    public final String toString() {
        return "OfficeNewFriendBadgeModel(badgeCount=" + this.f515692a + ", requestName=" + this.f515693b + ')';
    }

    public /* synthetic */ k(int r100) {
        this(0, "");
    }

    public k(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "requestName");
        this.f515692a = r100;
        this.f515693b = r101;
    }
}
