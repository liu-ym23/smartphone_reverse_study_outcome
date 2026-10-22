package com.bytedance.android.shopping.prepurchase.business.pdp;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.prepurchase.arch.container.state.h {
    public final boolean a;
    public int b;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<Float> c;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<Boolean> d;

    public a() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.b) * 31;
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Float> r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Boolean> r7 = this.d;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "ContainerState(inSplitScreen=" + this.a + ", initialHeight=" + this.b + ", draggableOffset=" + this.c + ", bottomSheetExpended=" + this.d + ")";
    }

    public a(boolean r4) {
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Float> r0 = new com.bytedance.android.shopping.prepurchase.arch.container.state.d(Float.valueOf(0.0f));
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Boolean> r1 = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        Intrinsics.checkNotNullParameter(r0, "draggableOffset");
        Intrinsics.checkNotNullParameter(r1, "bottomSheetExpended");
        this.a = r4;
        this.b = 0;
        this.c = r0;
        this.d = r1;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
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
}
