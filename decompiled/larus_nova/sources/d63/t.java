package d63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f467191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f467192b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L10;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f467191a, r101.f467191a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f467192b, r101.f467192b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f467191a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f467192b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopIconInfoVO(name=" + this.f467191a + ", urlSchema=" + this.f467192b + ")";
    }

    public t(String r100, String r101) {
        this.f467191a = r100;
        this.f467192b = r101;
    }
}
