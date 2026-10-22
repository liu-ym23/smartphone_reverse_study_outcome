package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j0 {
    public final String a;
    public final Map<String, Object> b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j0) == false) goto L10;
        j0 r4 = (j0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "QueryCacheInfo(renderNodeKey=" + this.a + ", fields=" + this.b + ")";
    }

    public j0(String r1, Map<String, ? extends Object> r2) {
        this.a = r1;
        this.b = r2;
    }
}
