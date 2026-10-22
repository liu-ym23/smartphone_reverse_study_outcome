package com.ss.android.ugc.aweme.discover.dynamic.utils;

import com.ss.android.ugc.aweme.search.dynamic.core.DynamicContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ECDynamicContextExtKt {
    public static final Boolean a(DynamicContext r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getNeedMatchWidth");
        r100.getClass();
        Intrinsics.checkNotNullParameter("extra_value_need_match_width", "key");
        Object r101 = ((Map) r100.f452634b.getValue()).get("extra_value_need_match_width");
        if (r101 != null) goto L6;
        r101 = null;
    L6:
        return (Boolean) r101;
    }
}
