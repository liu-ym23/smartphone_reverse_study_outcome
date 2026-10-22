package mt0;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b<TYPE, BEAN> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<TYPE, BEAN>> f515592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TYPE> f515593b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f515592a, r101.f515592a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f515593b, r101.f515593b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<a<TYPE, BEAN>> r100 = this.f515592a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<TYPE> r104 = this.f515593b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CompareResult(willLoadItem=" + this.f515592a + ", remove=" + this.f515593b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<a<TYPE, BEAN>> r100, List<? extends TYPE> r101) {
        Intrinsics.checkNotNullParameter(r100, "willLoadItem");
        Intrinsics.checkNotNullParameter(r101, "remove");
        this.f515592a = r100;
        this.f515593b = r101;
    }
}
