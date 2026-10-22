package com.bytedance.rts.foundation;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Arrays;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q {
    public static final <T> Set<T> b(T... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        return SetsKt.mutableSetOf(Arrays.copyOf(r100, r100.length));
    }

    public static final <T> boolean a(Set<? extends T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.contains(r101);
    }

    public static final <T> boolean delete(Set<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.remove(r101);
    }
}
