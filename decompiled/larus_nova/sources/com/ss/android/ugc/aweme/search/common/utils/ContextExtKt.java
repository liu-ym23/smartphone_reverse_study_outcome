package com.ss.android.ugc.aweme.search.common.utils;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAbility;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"getActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "trade-search-impl_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
public final class ContextExtKt {
    public static final Activity getActivity(Context r100) {
        if ((r100 instanceof Activity) == false) goto L6;
        return (Activity) r100;
    L6:
        if ((r100 instanceof ContextThemeWrapper) == false) goto L10;
        ContextThemeWrapper r101 = (ContextThemeWrapper) r100;
        if ((r101.getBaseContext() instanceof Activity) == false) goto L10;
        Context r102 = r101.getBaseContext();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) r102;
    L10:
        ITradeSearchHostService r103 = TradeSearch.c(TradeSearch.f453393a);
        if (r103 == null) goto L15;
        ITradeSearchHostAbility r104 = r103.getITradeSearchHostAbility();
        if (r104 == null) goto L15;
        return r104.getCurrentActivity();
    L15:
        return null;
    }
}
