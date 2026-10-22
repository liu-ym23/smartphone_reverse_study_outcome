package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECGetRecommendProductInfoMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGetRecommendProductInfoMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECGetRecommendProductInfoMethod() {
        this.e = "ecGetRecommendProductInfo";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r4, ECBaseBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "iReturn");
        int r6 = RoomContextController.h;
        d r7 = RoomContextController.a.a().d;
        r7.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("click_info", u0.d(r7.a));
        r0.put("show_info", u0.d(r7.c));
        r0.put("last_explain_product_id", r7.d);
        r5.onSuccess(r0);
    }
}
