package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Map<String, Object> k;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L28;
        g r4 = (g) r3;
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
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (this.j == r4.j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((((((r3 + r5) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        boolean r7 = this.f;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (r6 + r9) * 31;
        boolean r11 = this.g;
        ?? r12 = r11;
        if (r11 == false) goto L16;
        r12 = 1;
    L16:
        int r13 = (r10 + r12) * 31;
        boolean r14 = this.h;
        ?? r15 = r14;
        if (r14 == false) goto L19;
        r15 = 1;
    L19:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.i;
        ?? r18 = r17;
        if (r17 == false) goto L22;
        r18 = 1;
    L22:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.j;
        if (r20 == true) goto L26;
        r8 = r20;
    L26:
        int r21 = (r19 + r8) * 31;
        Map<String, Object> r22 = this.k;
        if (r22 == null) goto L30;
        r1 = r22.hashCode();
    L30:
        return r21 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderListTabItemInfo(tabName=" + this.a + ", count=" + this.b + ", leftTabId=" + this.c + ", tabId=" + this.d + ", rightTabId=" + this.e + ", isSelected=" + this.f + ", isFirst=" + this.g + ", isLast=" + this.h + ", isFixed=" + this.i + ", muteTabTextHorizontalPadding=" + this.j + ", originProps=" + this.k + ")";
    }

    public g(String r2, String r3, int r4, int r5, int r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r2, "tabName");
        Intrinsics.checkNotNullParameter(r12, "originProps");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
