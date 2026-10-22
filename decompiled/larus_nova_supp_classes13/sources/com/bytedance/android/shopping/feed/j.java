package com.bytedance.android.shopping.feed;

import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public PromotionPackResponse a;
    public final String b;
    public long c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof j) == false) goto L12;
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        PromotionPackResponse r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        long r6 = this.c;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionResponseCacheStruct(curResponse=" + this.a + ", awemeId=" + this.b + ", timeStamp=" + this.c + ")";
    }

    public j(PromotionPackResponse r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "curResponse");
        Intrinsics.checkNotNullParameter(r3, "awemeId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
