package com.bytedance.kmp.performance.platform;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import md6.d1;

/* JADX INFO: loaded from: classes19.dex */
public final class t {
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.kmp.performance.platform.q, java.lang.Object] */
    public static final h a(final d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "metrics");
        int r101 = a0.f252770a;
        final ?? r102 = new q(r100);
        Intrinsics.checkNotNullParameter(r102, "callback");
        AutoCloseable r103 = g.f252785b.b(new z(r102));
        AutoCloseable r104 = n.f252801b.b(new r(r100));
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r104, "other");
        boolean r105 = r103 instanceof h;
        if (r105 == true) goto L5;
    L7:
        if (r105 == false) goto L10;
        return new h(CollectionsKt.plus(((h) r103).f252786a, r104));
    L10:
        if ((r104 instanceof h) == false) goto L13;
        return new h(CollectionsKt.plus(CollectionsKt.listOf(r103), ((h) r104).f252786a));
    L13:
        return new h(CollectionsKt.listOf(new AutoCloseable[]{r103, r104}));
    L5:
        if ((r104 instanceof h) == false) goto L7;
        return new h(CollectionsKt.plus(((h) r103).f252786a, ((h) r104).f252786a));
    }
}
