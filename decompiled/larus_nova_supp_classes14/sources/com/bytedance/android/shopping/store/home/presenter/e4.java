package com.bytedance.android.shopping.store.home.presenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e4 {
    public final boolean a;
    public final int b;
    public final int c;
    public final boolean d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e4) == false) goto L14;
        e4 r4 = (e4) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        boolean r4 = this.d;
        if (r4 == true) goto L10;
        r1 = r4;
    L10:
        return r3 + r1;
    }

    public final String toString() {
        return "ShopFrameConfig(isDraggable=" + this.a + ", peekHeight=" + this.b + ", bottomSheetInitState=" + this.c + ", skipHideabled=" + this.d + ")";
    }

    public e4(boolean r1, int r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
