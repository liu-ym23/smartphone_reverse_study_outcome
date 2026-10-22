package vg3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n0 {
    public final int a;
    public final String b;
    public final boolean c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n0) == false) goto L12;
        n0 r4 = (n0) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = (r0 + r2) * 31;
        boolean r4 = this.c;
        ?? r5 = r4;
        if (r4 == false) goto L10;
        r5 = 1;
    L10:
        return r3 + r5;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TabSelectInfo(targetIndex=" + this.a + ", targetGroupId=" + this.b + ", fromUserClick=" + this.c + ")";
    }

    public n0(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "targetGroupId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
