package com.ss.android.lark.compose.foundation.widget;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f417684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f417685b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f417684a == r101.f417684a) goto L12;
        return false;
    L12:
        if (this.f417685b == r101.f417685b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f417684a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f417685b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowSwitchState(checked=" + this.f417684a + ", loading=" + this.f417685b + ')';
    }

    public a(boolean r100, boolean r101) {
        this.f417684a = r100;
        this.f417685b = r101;
    }

    public static a a(a r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f417684a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f417685b;
    L8:
        r100.getClass();
        return new a(r101, r102);
    }
}
