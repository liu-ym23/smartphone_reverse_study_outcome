package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 {
    public final OfficeLongPressMenuAction a;
    public final int b;
    public final String c;
    public final int d;
    public final OfficeLongPressMenuItemState e;
    public final String f;
    public final Integer g;
    public final Integer h;
    public final boolean i;
    public final OfficeLongPressDisabledDispatchReason j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r6 = (b0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.h;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.i == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        OfficeLongPressDisabledDispatchReason r13 = this.j;
        if (r13 == null) goto L23;
        r2 = r13.hashCode();
    L23:
        return r12 + r2;
    L17:
        r11 = 1237;
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeLongPressMenuItemSpec(action=" + this.a + ", menuId=" + this.b + ", title=" + this.c + ", iconRes=" + this.d + ", state=" + this.e + ", disabledTips=" + this.f + ", endIconRes=" + this.g + ", textColor=" + this.h + ", dispatchWhenDisabled=" + this.i + ", disabledDispatchReason=" + this.j + ')';
    }

    public b0(OfficeLongPressMenuAction r2, int r3, String r4, int r5, OfficeLongPressMenuItemState r6, String r7, Integer r8, Integer r9, boolean r10, OfficeLongPressDisabledDispatchReason r11) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r6, "state");
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
    }

    public /* synthetic */ b0(OfficeLongPressMenuAction r14, int r15, String r16, int r17, OfficeLongPressMenuItemState r18, String r19, Integer r20, Integer r21, boolean r22, OfficeLongPressDisabledDispatchReason r23, int r24) {
        if ((r24 & 16) == 0) goto L5;
        OfficeLongPressMenuItemState r7 = OfficeLongPressMenuItemState.VISIBLE;
    L7:
        if ((r24 & 32) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r24 & 64) == 0) goto L13;
        Integer r9 = null;
    L15:
        if ((r24 & 128) == 0) goto L17;
        Integer r10 = null;
    L19:
        if ((r24 & 256) == 0) goto L21;
        boolean r11 = false;
    L23:
        if ((r24 & 512) == 0) goto L25;
        OfficeLongPressDisabledDispatchReason r12 = null;
    L26:
        this(r14, r15, r16, r17, r7, r8, r9, r10, r11, r12);
        return;
    L25:
        r12 = r23;
        goto L26
    L21:
        r11 = r22;
        goto L23
    L17:
        r10 = r21;
        goto L19
    L13:
        r9 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }
}
