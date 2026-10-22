package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 {
    public final OfficeSpaceItem a;
    public final Document b;
    public final oj5.c c;
    public final boolean d;
    public final nj5.e e;
    public final Function0<Boolean> f;
    public final OfficeSpaceEventSource g;
    public final OfficeSpaceTab h;
    public final boolean i;
    public final OfficeListSortFilterScene j;
    public final Integer k;
    public final boolean l;
    public final boolean m;
    public final v n;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        nj5.e r4 = this.e;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r3 + r6) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        if (this.i == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        OfficeListSortFilterScene r10 = this.j;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.k;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.l == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        if (this.m == true) goto L30;
        r2 = 1237;
    L30:
        int r18 = (r17 + r2) * 31;
        v r19 = this.n;
        if (r19 == null) goto L35;
        r5 = r19.hashCode();
    L35:
        return r18 + r5;
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeLongPressMenuContext(item=" + this.a + ", document=" + this.b + ", moreInfo=" + this.c + ", enableCopyLink=" + this.d + ", copyLinkUrlTransformer=" + this.e + ", isNetworkConnected=" + this.f + ", source=" + this.g + ", tab=" + this.h + ", canMultiSelect=" + this.i + ", scene=" + this.j + ", recentDeleteTitleRes=" + this.k + ", canShowRecentRealDelete=" + this.l + ", isRestrictedWikiHomePage=" + this.m + ", actionSession=" + this.n + ')';
    }

    public a0(OfficeSpaceItem r2, Document r3, oj5.c r4, boolean r5, a r6, Function0 r7, OfficeSpaceEventSource r8, OfficeSpaceTab r9, boolean r10, OfficeListSortFilterScene r11, Integer r12, boolean r13, boolean r14, v r15) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "document");
        Intrinsics.checkNotNullParameter(r4, "moreInfo");
        Intrinsics.checkNotNullParameter(r7, "isNetworkConnected");
        Intrinsics.checkNotNullParameter(r8, "source");
        Intrinsics.checkNotNullParameter(r9, "tab");
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
        this.m = r14;
        this.n = r15;
    }
}
