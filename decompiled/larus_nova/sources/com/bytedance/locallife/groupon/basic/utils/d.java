package com.bytedance.locallife.groupon.basic.utils;

import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<NearbyPageType, String> f258791a = null;

    static {
        NearbyPageType r100 = NearbyPageType.TAB_NEARBY;
        NearbyPageType r101 = NearbyPageType.PAGE_GROUP_BUY;
        NearbyPageType r102 = NearbyPageType.TAB_GROUP_BUY;
        MapsKt.hashMapOf(new Pair[]{TuplesKt.to("homepage_fresh", r100), TuplesKt.to("life_dual_idpt", r101), TuplesKt.to("homepage_life", r102)});
        f258791a = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r100, "homepage_fresh"), TuplesKt.to(r102, "homepage_life"), TuplesKt.to(r101, "life_dual_idpt")});
    }

    public static final NearbyPageType a(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        return null;
    L15:
        if (r100.intValue() != 0) goto L17;
        return NearbyPageType.TAB_NEARBY;
    L10:
        if (r100.intValue() != 2) goto L12;
        return NearbyPageType.PAGE_GROUP_BUY;
    L5:
        if (r100.intValue() != 1) goto L7;
        return NearbyPageType.TAB_GROUP_BUY;
    }

    public static final String b(NearbyPageType r100) {
        if (r100 != null) goto L5;
        return "nearby_error";
    L5:
        String r101 = f258791a.get(r100);
        if (r101 != null) goto L9;
        return "nearby_error";
    L9:
        return r101;
    }
}
