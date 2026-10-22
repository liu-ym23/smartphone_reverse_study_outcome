package fi3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f477356a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f477356a, ((z) r100).f477356a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.f477356a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "PDPRecommendGoodsScrollParams(slideParams=" + this.f477356a + ")";
    }

    public z(Map<String, ? extends Object> r100) {
        this.f477356a = r100;
    }
}
