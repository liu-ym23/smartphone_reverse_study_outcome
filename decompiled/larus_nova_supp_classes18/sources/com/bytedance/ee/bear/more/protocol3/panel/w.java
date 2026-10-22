package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w {
    public final ItemUIStyle a;
    public final List<m> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "MorePanelConfig(hostStyle=" + this.a + ", groups=" + this.b + ')';
    }

    public w(ItemUIStyle r2, List<m> r3) {
        Intrinsics.checkNotNullParameter(r2, "hostStyle");
        Intrinsics.checkNotNullParameter(r3, "groups");
        this.a = r2;
        this.b = r3;
    }
}
