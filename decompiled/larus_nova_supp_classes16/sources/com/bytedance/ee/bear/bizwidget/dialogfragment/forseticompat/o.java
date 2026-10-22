package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;

    public static final class a {
        public boolean a;
        public boolean b;
        public boolean c;
        public int d;

        public final o a() {
            return new o(this.a, this.b, this.c, this.d);
        }

        public a() {
            this.a = true;
            this.b = true;
            this.c = true;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == true) goto L15;
        r1 = 1237;
    L15:
        return ((((r4 + r1) * 31) + this.d) * 31) + this.e;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "InsetsConfig(consumeStatusBar=" + this.a + ", consumeNavBar=" + this.b + ", consumeIme=" + this.c + ", statusBarColor=" + this.d + ", navBarColor=" + this.e + ')';
    }

    public o(boolean r1, boolean r2, boolean r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = 0;
        this.e = r4;
    }
}
