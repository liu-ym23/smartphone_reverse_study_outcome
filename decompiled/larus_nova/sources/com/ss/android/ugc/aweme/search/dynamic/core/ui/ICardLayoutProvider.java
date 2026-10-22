package com.ss.android.ugc.aweme.search.dynamic.core.ui;

import com.ss.android.ugc.aweme.search.dynamic.core.DynamicCardContext;
import com.ss.android.ugc.aweme.search.dynamic.core.data.DynamicData;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/ui/ICardLayoutProvider;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public interface ICardLayoutProvider {
    GenericViewHierarchy a(DynamicCardContext r100);

    Pair<Integer, Integer> b(DynamicCardContext r100, DynamicData r101);

    int c(DynamicCardContext r100);
}
