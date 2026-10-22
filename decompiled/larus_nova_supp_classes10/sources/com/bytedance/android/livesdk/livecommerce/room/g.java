package com.bytedance.android.livesdk.livecommerce.room;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public String a;
    public Bundle b;

    public g() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L10;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Bundle r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "EnterRoomInfo(clickFrom=" + this.a + ", businessArg=" + this.b + ")";
    }

    public g(int r3) {
        Bundle r4 = new Bundle();
        Intrinsics.checkNotNullParameter("UNKNOW", "clickFrom");
        Intrinsics.checkNotNullParameter(r4, "businessArg");
        this.a = "UNKNOW";
        this.b = r4;
    }
}
