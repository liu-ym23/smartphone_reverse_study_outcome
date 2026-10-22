package com.bytedance.ee.bear.middleground.permission.apply;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j1 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public j1() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r6 = (j1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "PermissionForbidUiConfig(layoutRes=" + this.a + ", noPreviewIconRes=" + this.b + ", noAccessIconRes=" + this.c + ", negativeLoadFailedIconRes=" + this.d + ')';
    }

    public /* synthetic */ j1(int r4) {
        this(2131564182, 2131232553, 2131232545, 2131232542);
    }

    public j1(int r1, int r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
