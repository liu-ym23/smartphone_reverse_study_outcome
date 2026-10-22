package com.bytedance.android.shopping.api.mall.feed;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedStickyConfig {
    public final Function0<Boolean> a;
    public final Function0<Unit> b;
    public final Function0<Integer> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECMallFeedStickyConfig) == false) goto L12;
        ECMallFeedStickyConfig r4 = (ECMallFeedStickyConfig) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Function0<Boolean> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Function0<Unit> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Function0<Integer> r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECMallFeedStickyConfig(needSticky=" + this.a + ", doSticky=" + this.b + ", getOffSet=" + this.c + ")";
    }

    public /* synthetic */ ECMallFeedStickyConfig(Function0 r2, Function0 r3) {
        this(r2, r3, AnonymousClass1.INSTANCE);
    }

    public ECMallFeedStickyConfig(Function0<Boolean> r2, Function0<Unit> r3, Function0<Integer> r4) {
        Intrinsics.checkNotNullParameter(r2, "needSticky");
        Intrinsics.checkNotNullParameter(r3, "doSticky");
        Intrinsics.checkNotNullParameter(r4, "getOffSet");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
