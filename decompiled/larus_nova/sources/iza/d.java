package iza;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f496726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f496727b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f496726a, r101.f496726a) == true) goto L12;
        return false;
    L12:
        if (this.f496727b == r101.f496727b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f496726a.hashCode() * 31;
        if (this.f496727b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeSidebarHumanListPage(items=" + this.f496726a + ", hasMore=" + this.f496727b + ')';
    }

    public d(List<c> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f496726a = r100;
        this.f496727b = r101;
    }
}
