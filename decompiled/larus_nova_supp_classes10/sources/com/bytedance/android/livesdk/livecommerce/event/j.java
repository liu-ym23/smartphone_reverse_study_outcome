package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    public final JSONObject a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof j) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((j) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        JSONObject r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ECAutoApplyCouponEvent(couponApply=" + this.a + ")";
    }

    public j(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "couponApply");
        this.a = r2;
    }
}
