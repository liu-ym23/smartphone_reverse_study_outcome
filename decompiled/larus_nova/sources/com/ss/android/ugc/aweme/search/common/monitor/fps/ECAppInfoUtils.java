package com.ss.android.ugc.aweme.search.common.monitor.fps;

import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECAppInfoUtils;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class ECAppInfoUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECAppInfoUtils f451786a = null;

    private ECAppInfoUtils() {
    }

    static {
        f451786a = new ECAppInfoUtils();
    }

    public static long a() {
        ITradeSearchHostService r100 = TradeSearch.c(TradeSearch.f453393a);
        if (r100 == null) goto L7;
        ITradeSearchHostAppInfo r101 = r100.getITradeSearchHostAppInfo();
        if (r101 == null) goto L7;
        long r102 = r101.getAppLaunchTime();
    L8:
        long r103 = System.currentTimeMillis() - r102;
        if (r102 > 0) goto L11;
    L13:
        return -1;
    L11:
        if (r103 <= 0) goto L13;
        return r103;
    L7:
        r102 = 0;
        goto L8
    }
}
