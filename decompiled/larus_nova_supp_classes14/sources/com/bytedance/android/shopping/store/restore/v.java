package com.bytedance.android.shopping.store.restore;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v {
    public final Boolean a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof v) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((v) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "StoreSignState(headerAreaStartScrollTag=" + this.a + ")";
    }

    public v(Boolean r1) {
        this.a = r1;
    }
}
