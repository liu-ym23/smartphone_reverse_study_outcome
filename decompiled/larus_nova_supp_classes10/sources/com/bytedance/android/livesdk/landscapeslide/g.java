package com.bytedance.android.livesdk.landscapeslide;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public Integer a;

    public g() {
        this(0);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((g) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "LiveRoomOrientation(value=" + this.a + ")";
    }

    public g(int r1) {
        this.a = null;
    }
}
