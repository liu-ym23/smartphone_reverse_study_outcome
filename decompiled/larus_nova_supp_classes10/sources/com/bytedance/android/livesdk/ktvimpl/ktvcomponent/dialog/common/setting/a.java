package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final CloseChallengeType a;
    public final boolean b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        CloseChallengeType r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.b;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return r2 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "CloseChallengeEvent(closeChallengeType=" + this.a + ", isCloseSuccess=" + this.b + ")";
    }

    public a() {
        this(CloseChallengeType.UNKNOWN, false);
    }

    public a(CloseChallengeType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "closeChallengeType");
        this.a = r2;
        this.b = r3;
    }
}
