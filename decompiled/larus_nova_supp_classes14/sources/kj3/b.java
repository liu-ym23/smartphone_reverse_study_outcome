package kj3;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements com.bytedance.android.ec.core.arch.event.d {
    public final Map<String, Object> a;
    public final Map<String, Object> b;
    public final Integer c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopRefreshFilterEvent(filterParams=" + this.a + ", clientState=" + this.b + ", tabId=" + this.c + ")";
    }

    public b(Map<String, ? extends Object> r1, Map<String, ? extends Object> r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
