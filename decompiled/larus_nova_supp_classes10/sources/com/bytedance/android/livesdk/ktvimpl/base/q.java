package com.bytedance.android.livesdk.ktvimpl.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q {
    public final String a;
    public final double b;
    public final boolean c;

    public /* synthetic */ q() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof q) == false) goto L12;
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Double.compare(this.b, r6.b) == 0) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = Double.doubleToLongBits(this.b);
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        boolean r4 = this.c;
        ?? r5 = r4;
        if (r4 == false) goto L10;
        r5 = 1;
    L10:
        return r3 + r5;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "ScoreItem(label=" + this.a + ", value=" + this.b + ", isHighlight=" + this.c + ")";
    }

    public q(String r2, double r3, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "label");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
