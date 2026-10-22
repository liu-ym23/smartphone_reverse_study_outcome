package kc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f502376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f502377b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L10;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f502376a, r101.f502376a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f502377b, r101.f502377b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        a r100 = this.f502376a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.f502377b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RevGameStickerInfo(stickerInfo=" + this.f502376a + ", playerInfo=" + this.f502377b + ")";
    }

    public u(a r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "stickerInfo");
        Intrinsics.checkNotNullParameter(r101, "playerInfo");
        this.f502376a = r100;
        this.f502377b = r101;
    }
}
