package com.ss.android.ugc.aweme.helper.image;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/image/ECSearchImageCallerContextRegistry;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchImageCallerContextRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchCommoditySearchFrescoCallerContext f450880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f450881b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ECSearchImageCallerContextRegistry f450882c = null;

    private ECSearchImageCallerContextRegistry() {
    }

    static {
        f450882c = new ECSearchImageCallerContextRegistry();
        f450880a = new ECSearchCommoditySearchFrescoCallerContext("commodity_search_default", "unknown");
        f450881b = new ConcurrentHashMap();
    }
}
