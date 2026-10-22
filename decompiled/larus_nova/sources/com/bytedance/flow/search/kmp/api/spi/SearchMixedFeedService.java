package com.bytedance.flow.search.kmp.api.spi;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import pd6.a;
import zv5.l;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/spi/SearchMixedFeedService;", "Lcom/bytedance/kmp/spi/IKmpService;", "isMixedFeedEnabled", "", "requestMixedFeed", "Lcom/bytedance/flow/search/kmp/api/spi/SearchMixedFeedResult;", EffectConfiguration.KEY_CURSOR, "", "count", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SearchMixedFeedService extends a {
    boolean i3();

    Object r2(String r100, int r101, Continuation<? super l> r102);
}
