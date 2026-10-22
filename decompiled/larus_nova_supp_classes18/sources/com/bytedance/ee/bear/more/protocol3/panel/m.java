package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public final MoreGroup a;
    public final List<o> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        return "MoreGroupConfig(group=" + this.a + ", items=" + this.b + ')';
    }

    public m(MoreGroup r2, List<o> r3) {
        Intrinsics.checkNotNullParameter(r2, "group");
        Intrinsics.checkNotNullParameter(r3, "items");
        this.a = r2;
        this.b = r3;
    }
}
