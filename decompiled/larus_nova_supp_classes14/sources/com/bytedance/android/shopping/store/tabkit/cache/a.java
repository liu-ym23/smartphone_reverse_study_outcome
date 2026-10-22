package com.bytedance.android.shopping.store.tabkit.cache;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final String a;
    public final int b;

    public a() {
        this(null, 0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "TabKitPrefetchMatchResult(requestId=" + this.a + ", matchStatus=" + this.b + ")";
    }

    public a(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
