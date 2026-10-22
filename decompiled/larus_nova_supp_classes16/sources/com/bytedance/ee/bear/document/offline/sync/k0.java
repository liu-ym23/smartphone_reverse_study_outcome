package com.bytedance.ee.bear.document.offline.sync;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k0 {
    public final String a;
    public final r b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r6 = (k0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.b.hashCode()) * 31) + this.c;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "PreloadStrategyJSONObjParams(type=" + this.a + ", data=" + this.b + ", version=" + this.c + ')';
    }

    public final String getType() {
        return this.a;
    }

    public k0(String r2, r r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a = r2;
        this.b = r3;
        this.c = 2;
    }
}
