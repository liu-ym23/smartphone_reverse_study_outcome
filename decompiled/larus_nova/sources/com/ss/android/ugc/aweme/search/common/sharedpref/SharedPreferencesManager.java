package com.ss.android.ugc.aweme.search.common.sharedpref;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class SharedPreferencesManager {
    public static SharedPreferencesWrapper a() {
        TradeSearch.f453393a.getClass();
        if (TradeSearch.b(0) != null) goto L5;
    L9:
        return null;
    L5:
        if (TradeSearch.b(0).getITradeSearchHostAppInfo() == null) goto L9;
        Context r100 = TradeSearch.b(0).getITradeSearchHostAppInfo().getApplicationContext();
        HashMap<String, SharedPreferencesWrapper> r101 = SharedPreferencesImpl.f452180a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("search", "spName");
        HashMap<String, SharedPreferencesWrapper> r102 = SharedPreferencesImpl.f452180a;
        SharedPreferencesWrapper r103 = r102.get("search");
        if (r103 != null) goto L11;
        SharedPreferencesWrapper r104 = new SharedPreferencesWrapper(r100.getApplicationContext());
        r102.put("search", r104);
        return r104;
    L11:
        return r103;
    }
}
