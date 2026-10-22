package com.bytedance.revenue.platform.api.core;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {
    public static final <E> List<E> a(E... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return CollectionsKt.emptyList();
    L10:
        return ArraysKt.toList(r100);
    L5:
        r101 = false;
        goto L6
    }
}
