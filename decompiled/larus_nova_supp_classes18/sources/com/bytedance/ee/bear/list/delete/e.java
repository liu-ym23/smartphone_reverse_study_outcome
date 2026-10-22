package com.bytedance.ee.bear.list.delete;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final boolean a;
    public final Map<String, Integer> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "DeleteResult(allSuccess=" + this.a + ", failedTokenToCode=" + this.b + ')';
    }

    public e(boolean r2, Map<String, Integer> r3) {
        Intrinsics.checkNotNullParameter(r3, "failedTokenToCode");
        this.a = r2;
        this.b = r3;
    }
}
