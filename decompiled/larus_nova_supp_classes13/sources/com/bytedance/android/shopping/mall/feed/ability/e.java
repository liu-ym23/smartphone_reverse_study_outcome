package com.bytedance.android.shopping.mall.feed.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final String a;
    public final boolean b;
    public final boolean c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L12;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
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
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.b;
        ?? r4 = 1;
        ?? r5 = r3;
        if (r3 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r2 + r5) * 31;
        boolean r7 = this.c;
        if (r7 == true) goto L14;
        r4 = r7;
    L14:
        return r6 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "MallOpenParams(schema=" + this.a + ", halfPopup=" + this.b + ", delayOnPauseLogic=" + this.c + ")";
    }

    public e(String r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
