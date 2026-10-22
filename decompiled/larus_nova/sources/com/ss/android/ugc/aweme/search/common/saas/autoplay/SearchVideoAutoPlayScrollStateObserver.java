package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/SearchVideoAutoPlayScrollStateObserver;", "Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/SearchAutoPlayScrollStateObserver;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SearchVideoAutoPlayScrollStateObserver extends SearchAutoPlayScrollStateObserver {
    public SearchVideoAutoPlayScrollStateObserver(View r100, Function2<? super String, ? super JSONObject, Unit> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "sendAction");
        super(r100, r101, r102);
    }
}
