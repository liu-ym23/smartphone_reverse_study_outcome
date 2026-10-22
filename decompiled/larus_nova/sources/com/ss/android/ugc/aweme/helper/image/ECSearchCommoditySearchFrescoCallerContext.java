package com.ss.android.ugc.aweme.helper.image;

import com.optimize.statistics.FrescoMonitorConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/helper/image/ECSearchCommoditySearchFrescoCallerContext;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECSearchCommoditySearchFrescoCallerContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f450875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f450876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f450877c;

    public final String toString() {
        Map r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("biz_tag", this.f450876b), TuplesKt.to(FrescoMonitorConst.SCENE_TAG, this.f450877c)});
        r100.putAll(this.f450875a);
        return "CommoditySearchFrescoCallerContext " + r100;
    }

    public ECSearchCommoditySearchFrescoCallerContext(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bizTag");
        Intrinsics.checkNotNullParameter(r101, "sceneTag");
        this.f450876b = r100;
        this.f450877c = r101;
        this.f450875a = new LinkedHashMap();
    }
}
