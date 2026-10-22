package com.bytedance.ee.bear.office.list.selectpanel;

import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final OfficeSelectPanelAction a;
    public final String b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final OfficeLongPressMenuAction g;
    public final boolean h;
    public final boolean i;
    public final OfficeLongPressDisabledDispatchReason j;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
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
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.f.hashCode()) * 31;
        OfficeLongPressMenuAction r6 = this.g;
        int r7 = 0;
        if (r6 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r5 + r8) * 31;
        if (this.h == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.i == true) goto L22;
        r2 = 1237;
    L22:
        int r12 = (r11 + r2) * 31;
        OfficeLongPressDisabledDispatchReason r13 = this.j;
        if (r13 == null) goto L27;
        r7 = r13.hashCode();
    L27:
        return r12 + r7;
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeSelectPanelItemSpec(action=" + this.a + ", title=" + this.b + ", iconRes=" + this.c + ", enabled=" + this.d + ", danger=" + this.e + ", disabledTips=" + this.f + ", longPressAction=" + this.g + ", blockedWhileLoading=" + this.h + ", dispatchWhenDisabled=" + this.i + ", disabledDispatchReason=" + this.j + ')';
    }

    public d(OfficeSelectPanelAction r15, String r16, int r17, String r18, int r19) {
        if ((r19 & 8) == 0) goto L5;
        boolean r7 = true;
    L7:
        if ((r19 & 16) == 0) goto L9;
        boolean r8 = false;
    L11:
        if ((r19 & 32) == 0) goto L13;
        String r9 = com.bytedance.ee.bear.more.office.f.c();
    L14:
        this(r15, r16, r17, r7, r8, r9, null, false, false, null);
        return;
    L13:
        r9 = r18;
        goto L14
    L9:
        r8 = true;
        goto L11
    L5:
        r7 = false;
        goto L7
    }

    public d(OfficeSelectPanelAction r2, String r3, int r4, boolean r5, boolean r6, String r7, OfficeLongPressMenuAction r8, boolean r9, boolean r10, OfficeLongPressDisabledDispatchReason r11) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r7, "disabledTips");
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
}
