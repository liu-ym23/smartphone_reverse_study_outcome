package com.bytedance.android.shopping.store.slicecard.view;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public final List<h> a;
    public final float b;
    public final List<h> c;
    public final float d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L14;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.d, r4.d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<h> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Float.floatToIntBits(this.b)) * 31;
        List<h> r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + Float.floatToIntBits(this.d);
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ResolvedTrustFloatBar(segments=" + this.a + ", totalWidthPx=" + this.b + ", trailingSegments=" + this.c + ", trailingWidthPx=" + this.d + ")";
    }

    public /* synthetic */ f(List r3, float r4) {
        this(r3, r4, CollectionsKt.emptyList(), 0.0f);
    }

    public static f a(f r2, List r3, float r4) {
        List<h> r0 = r2.a;
        float r5 = r2.b;
        Intrinsics.checkNotNullParameter(r0, "segments");
        Intrinsics.checkNotNullParameter(r3, "trailingSegments");
        return new f(r0, r5, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends h> r2, float r3, List<? extends h> r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, "segments");
        Intrinsics.checkNotNullParameter(r4, "trailingSegments");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
