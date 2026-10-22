package i59;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f488343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f488344b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f488343a, r101.f488343a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f488344b, r101.f488344b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f488343a.hashCode() * 31) + this.f488344b.hashCode();
    }

    public final String toString() {
        return "DeviceParams(wDid=" + this.f488343a + ", productId=" + this.f488344b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "wDid");
        Intrinsics.checkNotNullParameter(r101, "productId");
        this.f488343a = r100;
        this.f488344b = r101;
    }
}
