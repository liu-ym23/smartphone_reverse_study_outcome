package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n0 {
    public final List<f> a;
    public final com.bytedance.android.window.shop.c b;
    public final com.bytedance.android.ec.hybrid.list.entity.k c;
    public final com.bytedance.android.ec.hybrid.list.entity.k d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n0) == false) goto L14;
        n0 r4 = (n0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<f> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        com.bytedance.android.window.shop.c r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        com.bytedance.android.ec.hybrid.list.entity.k r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        com.bytedance.android.ec.hybrid.list.entity.k r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "WindowVOWrapper(list=" + this.a + ", type=" + this.b + ", hybridList=" + this.c + ", topHybridList=" + this.d + ")";
    }

    public final com.bytedance.android.window.shop.c getType() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n0(List<? extends f> r2, com.bytedance.android.window.shop.c r3, com.bytedance.android.ec.hybrid.list.entity.k r4, com.bytedance.android.ec.hybrid.list.entity.k r5) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ n0(List r2, com.bytedance.android.window.shop.c r3, com.bytedance.android.ec.hybrid.list.entity.k r4, int r5) {
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        this(r2, r3, r4, null);
    }
}
