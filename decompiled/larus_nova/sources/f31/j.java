package f31;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f475346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f475347b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (this.f475346a == r101.f475346a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f475347b, r101.f475347b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f475346a * 31;
        String r101 = this.f475347b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "MultiLinkStatus(anchorConnectionStatus=" + this.f475346a + ", source=" + this.f475347b + ")";
    }

    public j(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f475346a = r100;
        this.f475347b = r101;
    }
}
