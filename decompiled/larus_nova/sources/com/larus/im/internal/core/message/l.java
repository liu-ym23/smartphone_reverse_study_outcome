package com.larus.im.internal.core.message;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, List<Integer>> f347804a = null;

    static {
        f347804a = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, CollectionsKt.listOf(new Integer[]{1, 10})), TuplesKt.to(1, CollectionsKt.listOf(new Integer[]{2, 3})), TuplesKt.to(2, CollectionsKt.listOf(10)), TuplesKt.to(3, CollectionsKt.listOf(1)), TuplesKt.to(10, CollectionsKt.listOf(new Integer[]{12, 11, 13})), TuplesKt.to(11, CollectionsKt.listOf(new Integer[]{13, 14})), TuplesKt.to(12, CollectionsKt.listOf(11)), TuplesKt.to(13, CollectionsKt.listOf(12)), TuplesKt.to(20, CollectionsKt.listOf(new Integer[]{21, 22, 23})), TuplesKt.to(21, CollectionsKt.emptyList()), TuplesKt.to(22, CollectionsKt.listOf(new Integer[]{20, 21, 23})), TuplesKt.to(23, CollectionsKt.emptyList()), TuplesKt.to(24, CollectionsKt.listOf(new Integer[]{24, 13, 22, 20, 21}))});
    }

    public static boolean a(Integer r100, int r101) {
        if (r100 != null) goto L5;
    L15:
        return true;
    L5:
        if (r100.intValue() == (-1)) goto L15;
        if (r100.intValue() != r101) goto L10;
        return true;
    L10:
        List<Integer> r102 = f347804a.get(r100);
        if (r102 != null) goto L16;
        return false;
    L16:
        return r102.contains(Integer.valueOf(r101));
    }

    public static int b(Integer r100, int r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r100.intValue() == (-1)) goto L15;
        List<Integer> r102 = f347804a.get(r100);
        if (r102 == null) goto L9;
        boolean r103 = r102.contains(Integer.valueOf(r101));
    L10:
        if (r103 == true) goto L16;
        com.larus.im.internal.delegate.a.f348188b.i("MessageStatusState", "status changed failed current = " + r100 + ", target = " + r101);
        return r100.intValue();
    L16:
        return r101;
    L9:
        r103 = false;
        goto L10
    L15:
        return r101;
    }
}
