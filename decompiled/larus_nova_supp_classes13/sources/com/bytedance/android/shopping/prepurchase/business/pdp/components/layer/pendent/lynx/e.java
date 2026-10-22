package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.lynx;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
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

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "ProtectArea(leftMargin=" + this.a + ", topMargin=" + this.b + ", rightMargin=" + this.c + ", bottomMargin=" + this.d + ")";
    }

    public e(int r2) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = r2;
    }
}
