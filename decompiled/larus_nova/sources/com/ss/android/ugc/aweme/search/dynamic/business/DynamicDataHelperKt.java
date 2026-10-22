package com.ss.android.ugc.aweme.search.dynamic.business;

import com.ss.android.ugc.aweme.search.dynamic.base.model.DynamicCardData;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicData;
import com.ss.android.ugc.aweme.search.model.SearchDynamicPatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"trade-search-impl_release"}, k = 2, mv = {1, 4, 3})
public final class DynamicDataHelperKt {
    public static final SearchDynamicPatch a(DynamicData r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.f452673b.getBusinessData();
        if ((r101 instanceof DynamicCardData) == false) goto L5;
        DynamicCardData r102 = (DynamicCardData) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getDynamicPatch();
    L5:
        r102 = null;
        goto L6
    }
}
