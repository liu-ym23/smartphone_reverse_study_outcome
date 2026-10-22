package com.bytedance.android.shopping.store.viewmodel;

import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public final int a;
    public final ECStoreTabAreaVO b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k) == false) goto L10;
        k r4 = (k) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        ECStoreTabAreaVO r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "TabDataWrapper(statusCode=" + this.a + ", tabAreaVO=" + this.b + ")";
    }

    public k(int r1, ECStoreTabAreaVO r2) {
        this.a = r1;
        this.b = r2;
    }
}
