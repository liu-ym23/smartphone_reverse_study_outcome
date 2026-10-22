package com.bytedance.ee.bear.middleground.comment.widget;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 {
    public static final Integer b(v7b.s r1) {
        v7b.x r0 = (v7b.x) CollectionsKt.firstOrNull(r1.j());
        if (r0 != null) goto L5;
        v7b.s r2 = r1.e;
    L7:
        if (r2 == null) goto L13;
        Integer r3 = b(r2);
        if (r3 != null) goto L11;
        r2 = r2.h;
        goto L7
    L11:
        return Integer.valueOf(r3.intValue());
    L13:
        return null;
    L5:
        return Integer.valueOf(r0.a);
    }

    public static final Integer c(v7b.s r1) {
        v7b.x r0 = (v7b.x) CollectionsKt.lastOrNull(r1.j());
        if (r0 != null) goto L5;
        v7b.s r2 = r1.f;
    L7:
        if (r2 == null) goto L13;
        Integer r3 = c(r2);
        if (r3 != null) goto L11;
        r2 = r2.g;
        goto L7
    L11:
        return Integer.valueOf(r3.intValue());
    L13:
        return null;
    L5:
        return Integer.valueOf(r0.a);
    }

    public static final void a(com.ss.android.lark.coremd.base.parse.s r5, v7b.s r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "node");
        v7b.s r0 = r6.g;
        if (r0 == null) goto L9;
        Integer r1 = c(r0);
        if (r1 == null) goto L9;
        int r2 = r1.intValue();
        Integer r7 = b(r6);
        if (r7 == null) goto L9;
        Integer r8 = Integer.valueOf(RangesKt.coerceAtLeast(r7.intValue() - r2, 1));
    L10:
        if (r8 == null) goto L20;
        int r9 = r8.intValue();
        int r3 = r5.length() - 1;
        int r4 = 0;
        int r10 = 0;
    L12:
        if (r3 < 0) goto L16;
        if (Intrinsics.areEqual(r5.c(r3, r3 + 1), "\n") == false) goto L16;
        r10 = r10 + 1;
        r3 = r3 - 1;
    L16:
        int r11 = RangesKt.coerceAtLeast(r9 - r10, 0);
    L17:
        if (r4 >= r11) goto L19;
        r5.b();
        r4 = r4 + 1;
        goto L17
    L19:
        return;
    L20:
        r5.a();
        return;
    L9:
        r8 = null;
        goto L10
    }
}
