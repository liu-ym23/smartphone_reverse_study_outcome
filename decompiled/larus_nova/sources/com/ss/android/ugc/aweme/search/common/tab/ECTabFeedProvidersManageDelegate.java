package com.ss.android.ugc.aweme.search.common.tab;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/tab/ECTabFeedProvidersManageDelegate;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabFeedProvidersManageDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, IECSearchTabFeedProvider> f452205a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECTabFeedProvidersManageDelegate f452206b = null;

    private ECTabFeedProvidersManageDelegate() {
    }

    static {
        f452206b = new ECTabFeedProvidersManageDelegate();
        f452205a = new ConcurrentHashMap();
    }
}
