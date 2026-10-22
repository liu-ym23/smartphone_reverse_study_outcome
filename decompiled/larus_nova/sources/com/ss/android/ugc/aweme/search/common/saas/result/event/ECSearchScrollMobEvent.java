package com.ss.android.ugc.aweme.search.common.saas.result.event;

import com.ss.android.ugc.aweme.search.common.base.BaseMetricsEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/result/event/ECSearchScrollMobEvent;", "Lcom/ss/android/ugc/aweme/search/common/base/BaseMetricsEvent;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchScrollMobEvent extends BaseMetricsEvent<ECSearchScrollMobEvent> {
    public ECSearchScrollMobEvent() {
        Intrinsics.checkNotNullParameter("search_result_page_draw", "event");
        super("search_result_page_draw");
    }
}
