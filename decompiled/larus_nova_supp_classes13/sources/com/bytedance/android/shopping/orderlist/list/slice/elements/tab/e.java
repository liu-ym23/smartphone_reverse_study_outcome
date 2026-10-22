package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final int a;
    public final boolean b;
    public final String c;
    public final Long d;
    public final Boolean e;
    public final int f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L18;
        e r4 = (e) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public final int hashCode() {
        int r0 = this.a * 31;
        boolean r1 = this.b;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (r0 + r2) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        Long r8 = this.d;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.e;
        if (r11 == null) goto L17;
        r5 = r11.hashCode();
    L17:
        return ((r10 + r5) * 31) + this.f;
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "OrderListTabBubbleEvent(tabId=" + this.a + ", visible=" + this.b + ", text=" + this.c + ", autoCloseTimeMs=" + this.d + ", clickToClose=" + this.e + ", backgroundColor=" + this.f + ")";
    }

    public e(int r1, boolean r2, String r3, Long r4, Boolean r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
