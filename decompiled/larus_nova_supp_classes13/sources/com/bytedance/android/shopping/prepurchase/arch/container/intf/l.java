package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l<T> {
    public final k a;
    public final T b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L10;
        l r4 = (l) r3;
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
        k r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        T r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ResponseState(state=" + this.a + ", response=" + this.b + ")";
    }

    public l(k r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a = r2;
        this.b = r3;
    }

    public static l a(l r1, k r2, T r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = r1.b;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "state");
        return new l(r2, r3);
    }
}
