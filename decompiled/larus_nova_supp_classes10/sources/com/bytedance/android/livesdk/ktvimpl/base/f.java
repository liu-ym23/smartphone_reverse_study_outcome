package com.bytedance.android.livesdk.ktvimpl.base;

import com.bytedance.android.livesdk.ktvapi.KtvConflictScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public final KtvConflictScene a;
    public final int b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L10;
        f r4 = (f) r3;
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

    public final int hashCode() {
        KtvConflictScene r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "KtvConflictTip(conflictScene=" + this.a + ", conflictTipRes=" + this.b + ")";
    }

    public f(KtvConflictScene r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "conflictScene");
        this.a = r2;
        this.b = r3;
    }
}
