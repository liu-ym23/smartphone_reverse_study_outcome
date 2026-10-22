package p63;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f527879b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f527878a, r101.f527878a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527879b, r101.f527879b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f527878a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<e> r104 = this.f527879b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CombinationSkusVO(combinationId=" + this.f527878a + ", skuInfoList=" + this.f527879b + ")";
    }

    public a(String r100, List<e> r101) {
        this.f527878a = r100;
        this.f527879b = r101;
    }
}
