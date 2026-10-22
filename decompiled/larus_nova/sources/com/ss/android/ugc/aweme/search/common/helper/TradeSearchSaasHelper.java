package com.ss.android.ugc.aweme.search.common.helper;

import android.content.Context;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/helper/TradeSearchSaasHelper;", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class TradeSearchSaasHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f451623a = 0;

    static {
        new TradeSearchSaasHelper();
    }

    private TradeSearchSaasHelper() {
    }

    @JvmStatic
    public static final Context a() {
        ITradeSearchHostService r100 = TradeSearch.c(TradeSearch.f453393a);
        if (r100 == null) goto L5;
        ITradeSearchHostAppInfo r101 = r100.getITradeSearchHostAppInfo();
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getApplicationContext();
    L5:
        r101 = null;
        goto L6
    }
}
