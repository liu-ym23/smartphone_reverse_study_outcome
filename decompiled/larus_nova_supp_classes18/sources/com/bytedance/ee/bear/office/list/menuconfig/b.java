package com.bytedance.ee.bear.office.list.menuconfig;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.widgets.menuconfig.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final g a;
    public final int b;
    public final String c;
    public final int d;
    public final OfficeSpaceHeaderAction e;
    public final Integer f;
    public final boolean g;
    public final boolean h;
    public final String i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        OfficeSpaceHeaderAction r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        int r8 = 1231;
        if (this.g == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.h == true) goto L18;
        r8 = 1237;
    L18:
        int r11 = (r10 + r8) * 31;
        String r12 = this.i;
        if (r12 == null) goto L23;
        r2 = r12.hashCode();
    L23:
        return r11 + r2;
    L13:
        r9 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeHeaderMenuConfigEntry(configItem=" + this.a + ", menuId=" + this.b + ", text=" + this.c + ", iconRes=" + this.d + ", action=" + this.e + ", endIconRes=" + this.f + ", isListView=" + this.g + ", isGridView=" + this.h + ", subMenuId=" + this.i + ')';
    }

    public b(g r2, int r3, String r4, int r5, OfficeSpaceHeaderAction r6, Integer r7, boolean r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "configItem");
        Intrinsics.checkNotNullParameter(r4, "text");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public /* synthetic */ b(g r14, int r15, String r16, int r17, OfficeSpaceHeaderAction r18, Integer r19, boolean r20, boolean r21, String r22, int r23) {
        if ((r23 & 16) == 0) goto L5;
        OfficeSpaceHeaderAction r8 = null;
    L7:
        if ((r23 & 32) == 0) goto L9;
        Integer r9 = null;
    L11:
        if ((r23 & 64) == 0) goto L13;
        boolean r10 = false;
    L15:
        if ((r23 & 128) == 0) goto L17;
        boolean r11 = false;
    L19:
        if ((r23 & 256) == 0) goto L21;
        String r12 = null;
    L22:
        this(r14, r15, r16, r17, r8, r9, r10, r11, r12);
        return;
    L21:
        r12 = r22;
        goto L22
    L17:
        r11 = r21;
        goto L19
    L13:
        r10 = r20;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r8 = r18;
        goto L7
    }
}
