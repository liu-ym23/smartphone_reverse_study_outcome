package com.bytedance.android.shopping.store.restore;

import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public final n a;
    public final long b;
    public final long c;
    public final u d;
    public final v e;
    public final com.bytedance.android.shopping.store.home.entity.n f;
    public final ECStoreTabAreaVO g;
    public final Map<Integer, l> h;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof s) == false) goto L24;
        s r7 = (s) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(null, null) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        n r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.c;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        u r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        v r10 = this.e;
        if (r10 == null) goto L13;
        int r11 = r10.hashCode();
    L14:
        int r12 = (r9 + r11) * 31;
        com.bytedance.android.shopping.store.home.entity.n r13 = this.f;
        if (r13 == null) goto L17;
        int r14 = r13.hashCode();
    L18:
        int r15 = (r12 + r14) * 31;
        ECStoreTabAreaVO r16 = this.g;
        if (r16 == null) goto L21;
        int r17 = r16.hashCode();
    L22:
        int r18 = (((r15 + r17) * 31) + 0) * 31;
        Map<Integer, l> r19 = this.h;
        if (r19 == null) goto L26;
        r1 = r19.hashCode();
    L26:
        return r18 + r1;
    L21:
        r17 = 0;
        goto L22
    L17:
        r14 = 0;
        goto L18
    L13:
        r11 = 0;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopPageState(key=" + this.a + ", createdAtMs=" + this.b + ", ttlMs=" + this.c + ", ui=" + this.d + ", sign=" + this.e + ", headerArea=" + this.f + ", tabArea=" + this.g + ", tabKit=null, productTabs=" + this.h + ")";
    }

    public s(n r2, long r3, u r5, v r6, com.bytedance.android.shopping.store.home.entity.n r7, ECStoreTabAreaVO r8, Map r9) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r9, "productTabs");
        this.a = r2;
        this.b = r3;
        this.c = 43200000;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
