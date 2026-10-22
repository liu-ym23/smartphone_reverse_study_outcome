package com.ss.android.ugc.aweme.search.common.result.sug;

import com.ss.android.ugc.aweme.search.common.helper.ECSearchSugHostHelper;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchAwemeHostService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/ECSearchSugSessionManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSugSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ECSearchSugSession f451915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchSugSessionManager f451916b = null;

    private ECSearchSugSessionManager() {
    }

    static {
        f451916b = new ECSearchSugSessionManager();
    }

    public static void a(boolean r100, SearchEnterParam r101) {
        Intrinsics.checkNotNullParameter(r101, "enterParam");
        ECSearchSugHostHelper.f451622a.getClass();
        Intrinsics.checkNotNullParameter(r101, "enterParam");
        ITradeSearchHostService r102 = TradeSearch.c(TradeSearch.f453393a);
        List r103 = null;
        if (r102 == null) goto L5;
        ITradeSearchAwemeHostService r104 = r102.getITradeSearchAwemeHostService();
    L6:
        if (r104 == null) goto L8;
        List<Pair<String, String>> r105 = r104.getSearchHistoryForSugSession(r101);
    L9:
        if (r105 == null) goto L14;
        List<Pair<String, String>> r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L12:
        if (r108.hasNext() == false) goto L15;
        Pair r109 = (Pair) r108.next();
        r107.add(new Query((String) r109.getFirst(), (String) r109.getSecond()));
    L15:
        String r110 = String.valueOf(System.currentTimeMillis());
        if (r107 == null) goto L18;
        r103 = CollectionsKt.toMutableList(r107);
    L18:
        f451915a = new ECSearchSugSession(r110, r100 ? 1 : 0, r103);
        return;
    L14:
        r107 = null;
        goto L15
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
