package com.bytedance.ee.bear.office.list.menuconfig;

import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuAction;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuItemState;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final String a;
    public final OfficeLongPressMenuAction b;
    public final String c;
    public final int d;
    public final OfficeLongPressMenuItemState e;
    public final String f;
    public final Integer g;
    public final Integer h;
    public final boolean i;
    public final OfficeLongPressDisabledDispatchReason j;
    public final Map<String, String> k;
    public final List<a> l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        OfficeLongPressMenuAction r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
        String r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.h;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        if (this.i == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r13 + r14) * 31;
        OfficeLongPressDisabledDispatchReason r16 = this.j;
        if (r16 == null) goto L27;
        r2 = r16.hashCode();
    L27:
        return ((((r15 + r2) * 31) + this.k.hashCode()) * 31) + this.l.hashCode();
    L21:
        r14 = 1237;
        goto L22
    L17:
        r12 = r11.hashCode();
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
        return "OfficeConfiguredLongPressMenuItem(id=" + this.a + ", action=" + this.b + ", title=" + this.c + ", iconRes=" + this.d + ", state=" + this.e + ", disabledTips=" + this.f + ", textColor=" + this.g + ", endIconRes=" + this.h + ", dispatchWhenDisabled=" + this.i + ", disabledDispatchReason=" + this.j + ", payload=" + this.k + ", children=" + this.l + ')';
    }

    public a(String r2, OfficeLongPressMenuAction r3, String r4, int r5, OfficeLongPressMenuItemState r6, String r7, Integer r8, Integer r9, boolean r10, OfficeLongPressDisabledDispatchReason r11, Map<String, String> r12, List<a> r13) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r6, "state");
        Intrinsics.checkNotNullParameter(r12, "payload");
        Intrinsics.checkNotNullParameter(r13, "children");
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
        this.k = r12;
        this.l = r13;
    }
}
