package com.bytedance.ee.bear.middleground.comment.widget;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class e0 {
    public static final Integer b(v7b.s r100) {
        v7b.x r101 = (v7b.x) CollectionsKt.firstOrNull(r100.j());
        if (r101 != null) goto L5;
        v7b.s r102 = r100.f553569e;
    L7:
        if (r102 == null) goto L13;
        Integer r103 = b(r102);
        if (r103 != null) goto L11;
        r102 = r102.f553572h;
        goto L7
    L11:
        return Integer.valueOf(r103.intValue());
    L13:
        return null;
    L5:
        return Integer.valueOf(r101.f553578a);
    }

    public static final Integer c(v7b.s r100) {
        v7b.x r101 = (v7b.x) CollectionsKt.lastOrNull(r100.j());
        if (r101 != null) goto L5;
        v7b.s r102 = r100.f553570f;
    L7:
        if (r102 == null) goto L13;
        Integer r103 = c(r102);
        if (r103 != null) goto L11;
        r102 = r102.f553571g;
        goto L7
    L11:
        return Integer.valueOf(r103.intValue());
    L13:
        return null;
    L5:
        return Integer.valueOf(r101.f553578a);
    }

    public static final void a(com.ss.android.lark.coremd.base.parse.s r100, v7b.s r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "node");
        v7b.s r102 = r101.f553571g;
        if (r102 == null) goto L9;
        Integer r103 = c(r102);
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
        Integer r105 = b(r101);
        if (r105 == null) goto L9;
        Integer r106 = Integer.valueOf(RangesKt.coerceAtLeast(r105.intValue() - r104, 1));
    L10:
        if (r106 == null) goto L20;
        int r107 = r106.intValue();
        int r108 = r100.length() - 1;
        int r109 = 0;
        int r110 = 0;
    L12:
        if (r108 < 0) goto L16;
        if (Intrinsics.areEqual(r100.c(r108, r108 + 1), "\n") == false) goto L16;
        r110 = r110 + 1;
        r108 = r108 - 1;
    L16:
        int r111 = RangesKt.coerceAtLeast(r107 - r110, 0);
    L17:
        if (r109 >= r111) goto L19;
        r100.b();
        r109 = r109 + 1;
        goto L17
    L19:
        return;
    L20:
        r100.a();
        return;
    L9:
        r106 = null;
        goto L10
    }
}
