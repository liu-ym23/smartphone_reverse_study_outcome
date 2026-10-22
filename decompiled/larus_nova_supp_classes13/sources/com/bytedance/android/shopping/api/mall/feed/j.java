package com.bytedance.android.shopping.api.mall.feed;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public final String a;
    public final boolean b;
    public final JSONObject c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L12;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r3 + r5) * 31;
        JSONObject r7 = this.c;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        return r6 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MallSaasPrefetchParams(pageName=" + this.a + ", generateReqId=" + this.b + ", globalProps=" + this.c + ")";
    }

    public j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        this.a = r2;
        this.b = true;
        this.c = null;
    }
}
