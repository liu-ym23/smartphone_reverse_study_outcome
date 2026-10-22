package com.bytedance.android.shopping.sku.outer.business.buynow;

import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<V> implements Callable {
    public final /* synthetic */ SkuOuterBuyNowOpenHelper a;
    public final /* synthetic */ String b;

    public d(SkuOuterBuyNowOpenHelper r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        JSONObject r0 = z1.g(UriProtector.getQueryParameter(UriProtector.parse(this.b), "entrance_info"));
        if (r0 == null) goto L5;
        String r1 = r0.optString("product_source_page");
    L7:
        if (Intrinsics.areEqual(r1, "product_flow_page") == false) goto L12;
        int r2 = ECSdk.a;
        o r3 = (o) ECSdk.a(o.class);
        if (r3 == null) goto L13;
        r3.a(this.a.b, "inflow_feed_place_order", this.b, null, VmSdkSetting.a().i());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
