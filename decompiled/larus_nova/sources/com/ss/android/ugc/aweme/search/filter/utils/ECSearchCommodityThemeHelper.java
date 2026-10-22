package com.ss.android.ugc.aweme.search.filter.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.saas.ECSearchSaaSDepsHelper;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAbility;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/utils/ECSearchCommodityThemeHelper;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchCommodityThemeHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Context, HashMap<Integer, Context>> f452964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchCommodityThemeHelper f452965b = null;

    private ECSearchCommodityThemeHelper() {
    }

    static {
        f452965b = new ECSearchCommodityThemeHelper();
        f452964a = new WeakHashMap();
    }

    public static Context a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$createTargetUiModeContext");
        ITradeSearchHostService r102 = TradeSearch.c(TradeSearch.f453393a);
        Configuration r103 = null;
        if (r102 == null) goto L7;
        ITradeSearchHostAbility r104 = r102.getITradeSearchHostAbility();
        if (r104 == null) goto L7;
        Boolean r105 = r104.disableResContext();
    L9:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L11;
        return r100;
    L11:
        WeakHashMap<Context, HashMap<Integer, Context>> r106 = f452964a;
        if (r106.get(r100) == null) goto L17;
        HashMap<Integer, Context> r107 = r106.get(r100);
        Intrinsics.checkNotNull(r107);
        if (r107.get(Integer.valueOf(r101)) == null) goto L17;
        HashMap<Integer, Context> r108 = r106.get(r100);
        Intrinsics.checkNotNull(r108);
        Context r109 = r108.get(Integer.valueOf(r101));
        Intrinsics.checkNotNull(r109);
        return r109;
    L17:
        ITradeSearchHostService r110 = TradeSearch.b(0);
        if (r110 == null) goto L24;
        ITradeSearchHostAppInfo r111 = r110.getITradeSearchHostAppInfo();
        if (r111 == null) goto L24;
        Context r112 = r111.getApplicationContext();
        if (r112 == null) goto L24;
        Resources r113 = r112.getResources();
    L25:
        Configuration r114 = new Configuration();
        if (r113 == null) goto L28;
        r103 = r113.getConfiguration();
    L28:
        r114.setTo(r103);
        r114.uiMode = (r114.uiMode & (-49)) | r101;
        Context r115 = r100.getApplicationContext().createConfigurationContext(r114);
        NewMiraResourcesManager.getInstance().install(r115);
        ECSearchSaaSDepsHelper r116 = ECSearchSaaSDepsHelper.f451981a;
        AssetManager r117 = r115.getResources().getAssets();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "supportAssetManager");
        ITradeSearchHostService r118 = TradeSearch.b(0);
        if (r118 == null) goto L34;
        ITradeSearchHostAbility r119 = r118.getITradeSearchHostAbility();
        if (r119 == null) goto L34;
        r119.supportAssetManager(r117);
    L34:
        if (r106.get(r100) != null) goto L36;
        HashMap<Integer, Context> r120 = new HashMap();
        r120.put(Integer.valueOf(r101), r115);
        Unit r121 = Unit.INSTANCE;
        r106.put(r100, r120);
    L39:
        return r115;
    L36:
        HashMap<Integer, Context> r122 = r106.get(r100);
        if (r122 == null) goto L39;
        r122.put(Integer.valueOf(r101), r115);
    L24:
        r113 = null;
    L7:
        r105 = null;
        goto L9
    }

    public static Drawable c(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ContextCompat.getDrawable(a(r100, r102), r101);
    }

    public static int b(ECSearchCommodityThemeHelper r100, Context r101, int r102, int r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r103 != 16) goto L5;
        char r104 = 1;
    L6:
        Map<Integer, Integer> r105 = SearchResourceHelper.f452980a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r104 != 0) goto L9;
        Integer r106 = Integer.valueOf(ContextCompat.getColor(r101, r102));
    L24:
        if (r106 == null) goto L27;
        return r106.intValue();
    L27:
        return ContextCompat.getColor(a(r101, r103), r102);
    L9:
        if (r104 == 1) goto L20;
        if (r104 == 2) goto L19;
        ITradeSearchHostService r107 = TradeSearch.c(TradeSearch.f453393a);
        if (r107 == null) goto L18;
        ITradeSearchHostAppInfo r108 = r107.getITradeSearchHostAppInfo();
        if (r108 == null) goto L18;
        if (r108.isNightMode() != true) goto L18;
        Map<Integer, Integer> r109 = SearchResourceHelper.f452980a;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        Integer r111 = (Integer) r110.get(Integer.valueOf(r102));
    L21:
        if (r111 == null) goto L23;
        r106 = Integer.valueOf(ContextCompat.getColor(r101, r111.intValue()));
        goto L24
    L23:
        r106 = null;
    L18:
        Map<Integer, Integer> r112 = SearchResourceHelper.f452981b;
        LinkedHashMap r113 = (LinkedHashMap) r112;
        r111 = (Integer) r113.get(Integer.valueOf(r102));
        goto L21
    L19:
        Map<Integer, Integer> r114 = SearchResourceHelper.f452980a;
        LinkedHashMap r115 = (LinkedHashMap) r114;
        r111 = (Integer) r115.get(Integer.valueOf(r102));
        goto L21
    L20:
        Map<Integer, Integer> r116 = SearchResourceHelper.f452981b;
        LinkedHashMap r117 = (LinkedHashMap) r116;
        r111 = (Integer) r117.get(Integer.valueOf(r102));
        goto L21
    L5:
        r104 = 2;
        goto L6
    }
}
