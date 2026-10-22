package rd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f537252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f537253b;

    public b() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f537252a, r101.f537252a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f537253b, r101.f537253b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f537252a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f537253b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AppointModel(isAppoint=" + this.f537252a + ", productId=" + this.f537253b + ")";
    }

    public b(Boolean r100, String r101) {
        this.f537252a = r100;
        this.f537253b = r101;
    }
}
