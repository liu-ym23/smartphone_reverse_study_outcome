package com.bytedance.rts.kmp.foundation;

import java.util.Arrays;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {
    @RTSHiddenFromObjC
    public static final <T> Set<T> a(T... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        return SetsKt.mutableSetOf(Arrays.copyOf(r1, r1.length));
    }

    @RTSHiddenFromObjC
    public static final <T> boolean delete(Set<T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.remove(r2);
    }
}
