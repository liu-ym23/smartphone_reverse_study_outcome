package com.ss.android.ugc.aweme.search.dynamic.core.supplier;

import android.content.Context;
import com.lynx.tasm.TemplateData;
import com.ss.android.ugc.aweme.search.dynamic.core.DynamicCardContext;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicData;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/supplier/IDynamicDataProvider;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public interface IDynamicDataProvider {
    Map<String, Object> a(DynamicCardContext r100, DynamicData r101);

    TemplateData b(Context r100, DynamicData r101);

    Map<String, Object> c(Context r100, DynamicData r101);
}
