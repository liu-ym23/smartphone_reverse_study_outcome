package com.ss.android.ugc.aweme.discover.commodity.utils;

import com.google.gson.JsonSyntaxException;
import com.ss.android.ugc.aweme.search.common.SearchJsonTypeAdapter;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class SearchJsonObjectExtKt {
    public static final void a(SearchEnterParam r100, Function1<? super Map<String, Object>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        new SearchJsonTypeAdapter();     // Catch: JsonSyntaxException -> L15
        if (r100 == null) goto L7;
        String r102 = r100.getExtra();     // Catch: JsonSyntaxException -> L15
        if (r102 == null) goto L7;
    L8:
        Map r103 = SearchJsonTypeAdapter.b(r102);     // Catch: JsonSyntaxException -> L15
        if (r103 != null) goto L11;
        r103 = MapsKt.emptyMap();     // Catch: JsonSyntaxException -> L15
    L11:
        java.util.Objects.toString(r103);     // Catch: JsonSyntaxException -> L15
        r101.invoke(MapsKt.toMutableMap(r103));     // Catch: JsonSyntaxException -> L15
        java.util.Objects.toString(r103);     // Catch: JsonSyntaxException -> L15
        if (r100 == null) goto L20;
        r100.setExtra(com.ss.android.ugc.aweme.search.utils.GsonUtil.b(r103));     // Catch: JsonSyntaxException -> L15
        return;
    L20:
        return;
    L7:
        r102 = "";
    L15:
        e = move-exception;
        Logger.a("SEARCH_LOG_TAG", "mergeDataIntoSearchEnterExtra error, " + e);
    }
}
