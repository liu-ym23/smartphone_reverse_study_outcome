package com.ss.android.ugc.aweme.search.dynamic.core.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"trade-search-impl_release"}, k = 2, mv = {1, 4, 3})
public final class DynamicDataKt {
    public static final <T> T a(DynamicData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        T r101 = (T) r100.f452673b.getBusinessData();
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101;
    }

    public static final <T> T b(DynamicData r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Map<String, ? extends Object> r102 = r100.f452676e;
        if (r102 == null) goto L5;
        Object r103 = r102.get(r101);
    L6:
        if (r103 != null) goto L9;
        return null;
    L9:
        return (T) r103;
    L5:
        r103 = null;
        goto L6
    }
}
