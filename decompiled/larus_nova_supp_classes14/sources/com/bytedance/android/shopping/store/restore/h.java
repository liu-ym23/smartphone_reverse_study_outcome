package com.bytedance.android.shopping.store.restore;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public final ej3.f a;
    public final List<com.bytedance.android.ec.store.repository.vo.r> b;
    public final com.bytedance.android.ec.store.repository.vo.n c;
    public final Boolean d;
    public final List<com.bytedance.android.ec.store.repository.dto.c> e;
    public final List<com.bytedance.android.ec.store.repository.dto.c> f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L18;
        h r4 = (h) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ej3.f r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<com.bytedance.android.ec.store.repository.vo.r> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        com.bytedance.android.ec.store.repository.vo.n r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<com.bytedance.android.ec.store.repository.dto.c> r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<com.bytedance.android.ec.store.repository.dto.c> r16 = this.f;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductFilterSortState(sortsVO=" + this.a + ", sortTypes=" + this.b + ", discountButton=" + this.c + ", bigSaleMoveToTop=" + this.d + ", selectButtons=" + this.e + ", filterSelectButtons=" + this.f + ")";
    }

    public h(ej3.f r1, List<com.bytedance.android.ec.store.repository.vo.r> r2, com.bytedance.android.ec.store.repository.vo.n r3, Boolean r4, List<com.bytedance.android.ec.store.repository.dto.c> r5, List<com.bytedance.android.ec.store.repository.dto.c> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
