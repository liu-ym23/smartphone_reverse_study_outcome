package com.bytedance.ee.bear.imageviewer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t3 {
    public final int a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t3) == true) goto L8;
        return false;
    L8:
        t3 r6 = (t3) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "PolicyParams(type=" + this.a + ", token=" + this.b + ", operate=" + this.c + ')';
    }

    public final int getType() {
        return this.a;
    }

    public t3(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r4, "operate");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
