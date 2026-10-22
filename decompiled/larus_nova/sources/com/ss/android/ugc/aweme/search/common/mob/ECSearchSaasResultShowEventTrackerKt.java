package com.ss.android.ugc.aweme.search.common.mob;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.common.result.optimize.ECSearchParamHelper;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ECSearchSaasResultShowEventTrackerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchResultSceneKey f451756a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchSaasResultShowEvent f451757b = null;

    static {
        ECSearchResultSceneKey r100 = new ECSearchResultSceneKey(0);
        f451756a = r100;
        f451757b = new ECSearchSaasResultShowEvent(r100);
    }

    public static final void a(ECSearchSaasResultShowEvent r100, ECSearchParam r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$passThroughFromECSearchParam");
        if (r101 == null) goto L44;
        LinkedHashMap r102 = new LinkedHashMap();
        String r103 = r101.getKeyword();
        String r104 = "";
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r102.put("keyword", r103);
        ECSearchParamHelper.f451865a.getClass();
        SearchResultParam r105 = r101.getSearchResultParam();
        String r106 = null;
        if (r105 == null) goto L10;
        String r107 = r105.getEnterMethod();
    L11:
        if (r107 != null) goto L13;
    L16:
        boolean r108 = true;
    L18:
        if (r108 == true) goto L26;
        StringBuilder r109 = new StringBuilder("getSearchFrom return enterMethod = ");
        SearchResultParam r110 = r101.getSearchResultParam();
        if (r110 == null) goto L22;
        String r111 = r110.getEnterMethod();
    L23:
        r109.append(r111);
        Logger.a("ParamDebug", r109.toString());
        SearchResultParam r112 = r101.getSearchResultParam();
        if (r112 == null) goto L33;
        r106 = r112.getEnterMethod();
    L33:
        if (r106 != null) goto L35;
        r106 = "";
    L35:
        r102.put("search_from", r106);
        String r113 = r101.getEnterFrom();
        if (r113 != null) goto L38;
        r113 = "";
    L38:
        r102.put("search_enter_from", r113);
        String r114 = r101.getEnterFromSecond();
        if (r114 == null) goto L42;
        r104 = r114;
    L42:
        r102.put(ECFindSimilarConfig.ENTER_FROM_SECOND, r104);
        Unit r115 = Unit.INSTANCE;
        r100.g(r102);
        return;
    L22:
        r111 = null;
        goto L23
    L26:
        StringBuilder r116 = new StringBuilder("getSearchFrom return searchFrom = ");
        SearchResultParam r117 = r101.getSearchResultParam();
        if (r117 == null) goto L29;
        String r118 = r117.getSearchFrom();
    L30:
        r116.append(r118);
        Logger.a("ParamDebug", r116.toString());
        SearchResultParam r119 = r101.getSearchResultParam();
        if (r119 == null) goto L33;
        r106 = r119.getSearchFrom();
        goto L33
    L29:
        r118 = null;
        goto L30
    L13:
        if (r107.length() == 0) goto L16;
        r108 = false;
        goto L18
    L10:
        r107 = null;
        goto L11
    }

    public static final void b(ECSearchSaasResultShowEvent r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$passThroughTabName");
        Intrinsics.checkNotNullParameter(r101, "tabType");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("tab_label_name", r101);
        switch(r101.hashCode()) {
            case -401894300: goto L18;
            case 3529462: goto L15;
            case 98539350: goto L12;
            case 1515551823: goto L9;
            case 1875479094: goto L6;
            default: goto L20;
        };
    L20:
        int r103 = -1;
    L21:
        r102.put("tabType", Integer.valueOf(r103));
        Unit r104 = Unit.INSTANCE;
        r100.g(r102);
        return;
    L6:
        if (r101.equals("ecom_content") == false) goto L20;
    L19:
        r103 = 20;
        goto L21
    L9:
        if (r101.equals("ecom_live") == false) goto L20;
    L12:
        if (r101.equals("goods") == false) goto L20;
    L15:
        if (r101.equals("shop") == false) goto L20;
        r103 = 8;
        goto L21
    L18:
        if (r101.equals("ecom_on_sale") == false) goto L20;
        goto L19
    }
}
