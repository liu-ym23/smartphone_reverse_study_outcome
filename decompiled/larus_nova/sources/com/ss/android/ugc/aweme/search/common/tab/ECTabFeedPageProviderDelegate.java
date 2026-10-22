package com.ss.android.ugc.aweme.search.common.tab;

import com.ss.android.ugc.aweme.search.common.tab.cache.HashMapCache;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/tab/ECTabFeedPageProviderDelegate;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabFeedPageProviderDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMapCache f452203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, IECSearchTabFeed> f452204b;

    public ECTabFeedPageProviderDelegate() {
        this.f452203a = new HashMapCache();
        this.f452204b = new ConcurrentHashMap();
    }
}
