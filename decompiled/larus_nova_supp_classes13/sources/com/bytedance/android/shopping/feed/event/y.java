package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y {
    public final String a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof y) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((y) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "CloseProductFeedPageEvent(closeMethod=" + this.a + ")";
    }

    public y(String r2) {
        Intrinsics.checkNotNullParameter(r2, "closeMethod");
        this.a = r2;
    }
}
