package fi3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z {
    public final Map<String, Object> a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof z) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((z) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "PDPRecommendGoodsScrollParams(slideParams=" + this.a + ")";
    }

    public z(Map<String, ? extends Object> r1) {
        this.a = r1;
    }
}
