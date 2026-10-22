package xh0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f563852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f563853b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (this.f563852a == r101.f563852a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f563853b, r101.f563853b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f563852a * 31;
        String r101 = this.f563853b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "PlayModeInfo(key=" + this.f563852a + ", playModeName=" + this.f563853b + ")";
    }

    public h(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "playModeName");
        this.f563852a = r100;
        this.f563853b = r101;
    }
}
