package com.bytedance.ee.bear.lark.dependency;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final Integer e;
    public final boolean f;
    public final Integer g;
    public final Integer h;

    public a() {
        this(0, 0, null, false, null, null, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        Integer r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        if (this.f == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        Integer r7 = this.g;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.h;
        if (r10 == null) goto L19;
        r2 = r10.hashCode();
    L19:
        return r9 + r2;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiItemViewConfig(paddingStartPx=" + this.a + ", paddingTopPx=" + this.b + ", paddingEndPx=" + this.c + ", paddingBottomPx=" + this.d + ", iconSizePx=" + this.e + ", useDefaultAiAvatar=" + this.f + ", defaultAvatarDrawableRes=" + this.g + ", defaultAiAvatarTint=" + this.h + ')';
    }

    public a(int r4, int r5, Integer r6, boolean r7, Integer r8, Integer r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r10 & 16) == 0) goto L12;
        r6 = null;
    L12:
        if ((r10 & 32) == 0) goto L15;
        r7 = true;
    L15:
        if ((r10 & 64) == 0) goto L18;
        r8 = null;
    L18:
        if ((r10 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L20;
        r9 = null;
    L20:
        this.a = r4;
        this.b = 0;
        this.c = r5;
        this.d = 0;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
