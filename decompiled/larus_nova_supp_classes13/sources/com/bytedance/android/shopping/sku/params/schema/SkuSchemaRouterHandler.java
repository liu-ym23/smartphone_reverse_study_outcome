package com.bytedance.android.shopping.sku.params.schema;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.core.utils.n;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuSchemaRouterHandler {
    public final Uri a;
    public final ea3.b b;

    public SkuSchemaRouterHandler(Uri r2, ea3.b r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        this.a = r2;
        this.b = r3;
    }

    public final void b(final Context r4, boolean r5) {
        if (r4 != null) goto L4;
        r4 = ECAppInfoService.e.getCurrentActivity();
    L4:
        if (r4 != null) goto L7;
        SkuCommonLog.c("SkuSchemaHandler", "context is null");
        return;
    L7:
        n.b(r4, r5, null, new SkuSchemaRouterHandler$startFromSchema$1(this, r4), SkuSchemaRouterHandler$startFromSchema$2.INSTANCE);
    }

    public static void a(String r20, String r21, SkuParams r22, SkuSchemaParams r23) {
        boolean r3 = true;
        if (r20 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L54;
        if (r21 != null) goto L12;
    L15:
        if (r3 == true) goto L57;
        if (r20 != null) goto L20;
    L48:
        HashMap r1 = j.a;
        if (j.e(r20) == false) goto L55;
        List<String> r2 = r23.getPassThroughToKeys();
        if (r2.contains(r20) == true) goto L56;
        r2.add(r20);
        return;
    L56:
        return;
    L55:
        return;
    L20:
        switch(r20.hashCode()) {
            case -2098840255: goto L41;
            case -1793220942: goto L38;
            case -917030386: goto L35;
            case -613803836: goto L32;
            case 54623351: goto L29;
            case 1278258638: goto L26;
            case 1953935791: goto L23;
            default: goto L48;
        };
    L23:
        if (r20.equals("api.add.extra") == false) goto L48;
        r22.setTrackExtra(r21);
        goto L48
    L26:
        if (r20.equals("track.client") == false) goto L48;
        Map r4 = MapsKt.toMutableMap(r22.getEventParams());
        r4.putAll(z1.j(z1.f(r21)));
        Unit r6 = Unit.INSTANCE;
        r22.setEventParams(r4);
        goto L48
    L29:
        if (r20.equals("track.client.entrance_info") == false) goto L48;
        Map r7 = MapsKt.toMutableMap(r22.getEventParams());
        r7.put("entrance_info", r21);
        Unit r8 = Unit.INSTANCE;
        r22.setEventParams(r7);
        goto L48
    L32:
        if (r20.equals("url.order.log_data") == false) goto L48;
        r22.setLogData(r21);
        goto L48
    L35:
        if (r20.equals("url.coupon.log_data") == false) goto L48;
        r22.setCouponLogData(z1.g(r21));
        goto L48
    L38:
        if (r20.equals("api.sku.entrance_info") == false) goto L48;
        r22.setEntranceInfo(r21);
        goto L48
    L41:
        if (r20.equals("track.add_cart") == false) goto L48;
        if (r22.getSkuExtraData() == null) goto L47;
        SkuExtraData r9 = r22.getSkuExtraData();
        if (r9 == null) goto L48;
        r9.setAddCartTrackMeta(z1.j(z1.f(r21)));
        goto L48
    L47:
        r22.setSkuExtraData(new SkuExtraData(null, null, false, null, null, null, null, null, null, null, null, null, z1.j(z1.f(r21)), 4095, null));
        goto L48
    L57:
        return;
    L12:
        if (StringsKt.isBlank(r21) == true) goto L15;
        r3 = false;
        goto L15
    L54:
        return;
    L5:
        if (StringsKt.isBlank(r20) == true) goto L8;
        r5 = false;
        goto L9
    }
}
