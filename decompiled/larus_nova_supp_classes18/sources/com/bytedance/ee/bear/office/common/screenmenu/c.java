package com.bytedance.ee.bear.office.common.screenmenu;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements fk5.a {
    public final int a;
    public final int b;
    public final int c;
    public final Drawable d;
    public final int e;
    public final int f;
    public final boolean g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        Drawable r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((((r0 + r2) * 31) + this.e) * 31) + this.f) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuDivider(id=" + this.a + ", backgroundColor=" + this.b + ", backgroundDrawableRes=" + this.c + ", backgroundDrawable=" + this.d + ", height=" + this.e + ", width=" + this.f + ", removeAroundDivider=" + this.g + ')';
    }

    @Override // fk5.a
    public final boolean a() {
        return this.g;
    }

    @Override // fk5.a
    public final int getId() {
        return this.a;
    }

    public c(int r3, int r4, int r5, int r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r7 & 16) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 32) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r7 & 64) == 0) goto L14;
        boolean r8 = true;
    L15:
        this.a = r3;
        this.b = 0;
        this.c = r4;
        this.d = null;
        this.e = r5;
        this.f = r6;
        this.g = r8;
        return;
    L14:
        r8 = false;
        goto L15
    }
}
