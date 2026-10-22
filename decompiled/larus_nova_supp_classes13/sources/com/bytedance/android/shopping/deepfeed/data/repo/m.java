package com.bytedance.android.shopping.deepfeed.data.repo;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m {
    public final Boolean a;
    public final List<InFeedProductV2> b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final com.bytedance.android.shopping.deepfeed.data.a f;

    public m() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L18;
        m r4 = (m) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Boolean r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<InFeedProductV2> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (r6 + r9) * 31;
        boolean r11 = this.d;
        if (r11 == true) goto L17;
        r8 = r11;
    L17:
        int r12 = (((r10 + r8) * 31) + this.e) * 31;
        com.bytedance.android.shopping.deepfeed.data.a r13 = this.f;
        if (r13 == null) goto L21;
        r1 = r13.hashCode();
    L21:
        return r12 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedProductResponseState(success=" + this.a + ", inFeedProductList=" + this.b + ", hasMore=" + this.c + ", isLoading=" + this.d + ", netType=" + this.e + ", cardUpdateState=" + this.f + ")";
    }

    public m(Boolean r3, List r4, boolean r5, boolean r6, com.bytedance.android.shopping.deepfeed.data.a r7, int r8) {
        if ((r8 & 16) == 0) goto L5;
        int r0 = -1;
    L7:
        if ((r8 & 32) == 0) goto L9;
        r7 = new com.bytedance.android.shopping.deepfeed.data.a(false, 0, false, 7);
    L9:
        Intrinsics.checkNotNullParameter(r7, "cardUpdateState");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r0;
        this.f = r7;
        return;
    L5:
        r0 = 0;
        goto L7
    }
}
