package com.ss.android.ugc.aweme.search.vision.model.repo;

import com.ss.android.ugc.aweme.discover.commodity.api.v3.ECSearchCommodityResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/repo/OnRequestListener;", "R", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OnRequestListener<R> {
    void a(ECSearchCommodityResponse r100);

    void b(ECSearchCommodityResponse r100);

    void onException(Throwable r100);
}
