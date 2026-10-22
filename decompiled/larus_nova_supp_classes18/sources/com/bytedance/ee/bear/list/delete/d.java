package com.bytedance.ee.bear.list.delete;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final String a;
    public final int b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
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
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "DeleteItem(objToken=" + this.a + ", objType=" + this.b + ", isOwner=" + this.c + ')';
    }

    public d(String r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "objToken");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
