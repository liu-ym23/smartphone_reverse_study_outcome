package com.bytedance.ee.bear.office.common.screenmenu;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u {
    public static final u d = null;
    public static final u e = null;
    public static final u f = null;
    public final ScreenMenuBackgroundMode a;
    public final boolean b;
    public final boolean c;

    public static final class a {
    }

    public u() {
        this(null, false, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScreenMenuPresentation(backgroundMode=" + this.a + ", showAnchorFocus=" + this.b + ", closeOnBackgroundTouch=" + this.c + ')';
    }

    static {
        d = new u(null, false, 7);
        e = new u(ScreenMenuBackgroundMode.BLUR_DIM, true, 4);
        f = new u(ScreenMenuBackgroundMode.NONE, false, 4);
    }

    public u(ScreenMenuBackgroundMode r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        r3 = ScreenMenuBackgroundMode.DIM;
    L5:
        boolean r1 = true;
        if ((r5 & 2) == 0) goto L9;
        r4 = true;
    L9:
        if ((r5 & 4) != 0) goto L12;
        r1 = false;
    L12:
        Intrinsics.checkNotNullParameter(r3, "backgroundMode");
        this.a = r3;
        this.b = r4;
        this.c = r1;
    }
}
