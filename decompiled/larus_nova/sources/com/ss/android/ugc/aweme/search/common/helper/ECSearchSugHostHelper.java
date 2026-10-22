package com.ss.android.ugc.aweme.search.common.helper;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/helper/ECSearchSugHostHelper;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSugHostHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchSugHostHelper f451622a = null;

    private ECSearchSugHostHelper() {
    }

    static {
        f451622a = new ECSearchSugHostHelper();
    }

    public static boolean b() {
        ITradeSearchHostService r100 = TradeSearch.c(TradeSearch.f453393a);
        if (r100 == null) goto L5;
        ITradeSearchHostAppInfo r101 = r100.getITradeSearchHostAppInfo();
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.isInHouse();
    L5:
        r101 = null;
        goto L6
    }

    public static Object a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        if (r101 == null) goto L5;
        ITradeSearchAwemeHostService r102 = r101.getITradeSearchAwemeHostService();
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getValueByConfig(r100);
    L5:
        r102 = null;
        goto L6
    }

    public static void c(ECSearchSugHostHelper r100, Context r101, String r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r103, "map");
        ITradeSearchHostService r104 = TradeSearch.c(TradeSearch.f453393a);
        if (r104 == null) goto L5;
        ITradeSearchAwemeHostService r105 = r104.getITradeSearchAwemeHostService();
    L6:
        if (r105 == null) goto L9;
        r105.openRoute(r101, r102, r103);
        return;
    L9:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
