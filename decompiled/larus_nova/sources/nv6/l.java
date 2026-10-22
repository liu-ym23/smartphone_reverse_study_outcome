package nv6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f520901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520902b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f520901a == r101.f520901a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520902b, r101.f520902b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f520901a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f520902b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "GoodsShelfShowTrackerInfo(needReport=" + this.f520901a + ", cacheType=" + this.f520902b + ')';
    }

    public l(String r100) {
        this.f520901a = true;
        this.f520902b = r100;
    }
}
