package sh0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zj0.c f541911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f541912b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g0) == false) goto L10;
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f541911a, r101.f541911a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f541912b, r101.f541912b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        zj0.c r100 = this.f541911a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.f541912b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateLinkWindowLayoutConfigInfo(switchType=" + this.f541911a + ", playModes=" + this.f541912b + ")";
    }

    public g0(zj0.c.b r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "switchType");
        this.f541911a = r100;
        this.f541912b = r101;
    }
}
