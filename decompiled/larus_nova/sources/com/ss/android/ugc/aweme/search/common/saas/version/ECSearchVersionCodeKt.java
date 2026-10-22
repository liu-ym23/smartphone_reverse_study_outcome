package com.ss.android.ugc.aweme.search.common.saas.version;

import android.app.Activity;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAbility;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ECSearchVersionCodeKt {
    public static final int a() {
        ITradeSearchHostService r100 = TradeSearch.c(TradeSearch.f453393a);     // Catch: Exception -> L11
        if (r100 == null) goto L16;
        ITradeSearchHostAbility r101 = r100.getITradeSearchHostAbility();     // Catch: Exception -> L11
        if (r101 == null) goto L17;
        Activity r102 = r101.getCurrentActivity();     // Catch: Exception -> L11
        if (r102 == null) goto L18;
        return r102.getPackageManager().getApplicationInfo(r102.getPackageName(), 128).metaData.getInt("ECSEARCH_VERSIONCODE", 44700);
    L18:
        return 44700;
    L17:
        return 44700;
    L16:
        return 44700;
    L11:
        e = move-exception;
        Logger.b("ECSearch", "ECSEARCH_VERSIONCODE error: " + e.getMessage());
        return 44700;
    }
}
