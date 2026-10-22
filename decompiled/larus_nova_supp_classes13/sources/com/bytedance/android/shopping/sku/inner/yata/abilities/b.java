package com.bytedance.android.shopping.sku.inner.yata.abilities;

import com.bytedance.android.ec.core.utils.g0;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.sku.inner.container.h0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v96.j;
import v96.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements v96.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public b(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final j a(m r6) {
        Intrinsics.checkNotNullParameter(r6, "info");
        com.bytedance.android.shopping.sku.inner.container.b r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "fragment");
        h0 r1 = r0.qn().getStaticState();
        Pair[] r2 = new Pair[6];
        r2[0] = TuplesKt.to("uplink_version", Long.valueOf(r0.dq().b()));
        r2[1] = TuplesKt.to("selected_car", r1.b);
        ProductSelectPoiInfo r3 = r1.c;
        if (r3 == null) goto L5;
        Map r4 = r3.getParamsObj();
    L6:
        r2[2] = TuplesKt.to("selected_poi_store", r4);
        int r5 = g0.a;
        ECAppInfoService r7 = ECAppInfoService.e;
        r2[3] = TuplesKt.to("gps_on", Integer.valueOf(g0.a(r7.getApplicationContext()) ? 1 : 0));
        r2[4] = TuplesKt.to("is_auth", Boolean.valueOf(g0.a(r7.getApplicationContext())));
        r2[5] = TuplesKt.to("biz_identifier", r0.qn().getSkuParams().getBizIdentifier());
        return new j("aweme/v2/sku/yata/update", MapsKt.mapOf(r2));
    L5:
        r4 = null;
        goto L6
    }
}
