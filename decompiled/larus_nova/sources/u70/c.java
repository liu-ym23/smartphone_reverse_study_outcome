package u70;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f549031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f549032b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f549031a == r101.f549031a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f549032b, r101.f549032b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f549031a * 31;
        String r101 = this.f549032b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "PriorityItemInfo(priority=" + this.f549031a + ", identify=" + this.f549032b + ")";
    }

    public c(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "identify");
        this.f549031a = r100;
        this.f549032b = r101;
    }
}
