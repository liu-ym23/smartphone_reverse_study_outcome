package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i0 extends f {
    public static final /* synthetic */ int m = 0;
    public int j;
    public final WindowProductCategoryVODeprecated k;
    public final String l;

    public static final class a {
        public static i0 a(List r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "categoryDtoList");
            int r0 = WindowProductCategoryVODeprecated.k;
            WindowProductCategoryVODeprecated r3 = WindowProductCategoryVODeprecated.b.a(r1);
            if (r3 != null) goto L5;
            return null;
        L5:
            if (r2 != null) goto L11;
            WindowProductCategoryVODeprecated.a r4 = (WindowProductCategoryVODeprecated.a) CollectionsKt.firstOrNull(r3.j);
            if (r4 == null) goto L9;
            r2 = r4.a;
            goto L11
        L9:
            r2 = null;
        L11:
            return new i0(r3, r2);
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i0) == false) goto L10;
        i0 r4 = (i0) r3;
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        WindowProductCategoryVODeprecated r0 = this.k;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.l;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowSubCategoryVO(subCategoryVO=" + this.k + ", selectCategoryId=" + this.l + ")";
    }

    public i0(WindowProductCategoryVODeprecated r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "subCategoryVO");
        super(2510);
        this.k = r3;
        this.l = r4;
        if (r4 == null) goto L17;
        Iterator<WindowProductCategoryVODeprecated.a> r5 = r3.j.iterator();
        int r0 = 0;
    L6:
        if (r5.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r5.next().a, r4) == true) goto L12;
        r0 = r0 + 1;
    L12:
        if (r0 < 0) goto L18;
        this.j = r0;
        return;
    L18:
        return;
    L11:
        r0 = -1;
        goto L12
    }
}
