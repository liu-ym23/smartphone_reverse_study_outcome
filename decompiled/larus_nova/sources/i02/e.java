package i02;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f487869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f487870b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f487869a, r101.f487869a) == true) goto L8;
        return false;
    L8:
        if (this.f487870b == r101.f487870b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<Integer> r100 = this.f487869a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f487870b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return this.f487869a.toString() + "count is " + this.f487870b;
    }

    public e(List<Integer> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "assetIdList");
        this.f487869a = r100;
        this.f487870b = r101;
    }
}
