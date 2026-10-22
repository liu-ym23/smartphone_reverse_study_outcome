package u70;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f549029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f549030b;

    public final String toString() {
        return "MutexPair(identify1=" + this.f549029a + ", identify2=" + this.f549030b + ")";
    }

    public a() {
        Intrinsics.checkNotNullParameter("LiveHotSpotWidget", "identify1");
        Intrinsics.checkNotNullParameter("VerticalRankEntranceWidget", "identify2");
        this.f549029a = "LiveHotSpotWidget";
        this.f549030b = "VerticalRankEntranceWidget";
    }

    public final int hashCode() {
        return (this.f549029a.hashCode() * 31) + this.f549030b.hashCode();
    }

    public final boolean equals(Object r100) {
        a r101 = (a) r100;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r101.f549029a, this.f549029a) == false) goto L9;
        if (Intrinsics.areEqual(r101.f549030b, this.f549030b) == false) goto L9;
    L12:
        return true;
    L9:
        if (Intrinsics.areEqual(r101.f549029a, this.f549030b) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.f549030b, this.f549029a) == true) goto L12;
        return false;
    }
}
