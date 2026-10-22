package com.bytedance.android.shopping.buynow.starter;

import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final String a;
    public final YataPageInfo b;
    public WeakReference<Object> c;
    public boolean d;
    public boolean e;

    public c() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L16;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        YataPageInfo r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        WeakReference<Object> r7 = this.c;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.d;
        ?? r10 = 1;
        ?? r11 = r9;
        if (r9 == false) goto L16;
        r11 = 1;
    L16:
        int r12 = (r8 + r11) * 31;
        boolean r13 = this.e;
        if (r13 == true) goto L21;
        r10 = r13;
    L21:
        return r12 + r10;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "BuyNowPageInfo(sessionId=" + this.a + ", pageInfo=" + this.b + ", btmNodeRef=" + this.c + ", isSplitScreen=" + this.d + ", splitScreenOpened=" + this.e + ")";
    }

    public c(String r2, YataPageInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "pageInfo");
        this.a = r2;
        this.b = r3;
        this.c = null;
        this.d = false;
        this.e = false;
    }
}
