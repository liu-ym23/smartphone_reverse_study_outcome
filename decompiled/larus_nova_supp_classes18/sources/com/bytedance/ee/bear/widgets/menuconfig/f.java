package com.bytedance.ee.bear.widgets.menuconfig;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public final String a;
    public final boolean b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.c;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeSpaceMenuGroup(groupId=" + this.a + ", visible=" + this.b + ", order=" + this.c + ')';
    }

    public f(String r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "groupId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
