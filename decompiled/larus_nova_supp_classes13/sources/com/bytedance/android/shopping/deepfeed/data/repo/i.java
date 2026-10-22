package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public final String a;
    public final InFeedProductV2 b;
    public final List<InFeedProductV2> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L12;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        InFeedProductV2 r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<InFeedProductV2> r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedCouponWaistRefreshResult(sessionId=" + this.a + ", packCard=" + this.b + ", feedCards=" + this.c + ")";
    }

    public i(String r2, InFeedProductV2 r3, List<InFeedProductV2> r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "feedCards");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
