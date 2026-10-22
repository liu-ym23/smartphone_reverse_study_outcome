package com.bytedance.android.shopping.buynow.yata.abilities;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements v96.a {
    public final BuyNowViewModel a;

    public e(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final v96.j a(v96.m r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        if (this.a.getStaticState().c() == false) goto L6;
        String r5 = "/order/component/confirmOrderEdit/";
    L9:
        StringBuilder r1 = new StringBuilder();
        r1.append(r5);
        r1.append("?buy_render_shape=");
        r1.append(ja3.a.a(this.a.getStaticState().a));
        r1.append("&webcast_appid=");
        int r6 = ECSdk.a;
        IAdapterService r7 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r7 == null) goto L12;
        String r8 = r7.getWebcastAppId();
    L13:
        r1.append(r8);
        return new v96.j(r1.toString(), MapsKt.mapOf(TuplesKt.to("uplink_version", Long.valueOf(this.a.getSkuService().b()))));
    L12:
        r8 = null;
        goto L13
    L6:
        if (this.a.getStaticState().b() == false) goto L8;
        r5 = "/order/yata/getPayMethodEdit";
        goto L9
    L8:
        r5 = "/order/yata/confirmOrderEdit";
        goto L9
    }
}
