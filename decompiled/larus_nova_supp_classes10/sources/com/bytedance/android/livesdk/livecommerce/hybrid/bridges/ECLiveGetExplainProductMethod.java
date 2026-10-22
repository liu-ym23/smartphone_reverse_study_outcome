package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.live.datacontext.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECLiveGetExplainProductMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveGetExplainProductMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECLiveGetExplainProductMethod() {
        this.e = "getExplainProduct";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r4, ECBaseBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "iReturn");
        JSONObject r6 = new JSONObject();
        int r0 = RoomContextController.h;
        ECContext r1 = RoomContextController.a.a().r();
        String r2 = null;
        if (r1 == null) goto L7;
        n<ECUIPromotion> r3 = r1.getExplainPromotion();
        if (r3 == null) goto L7;
        ECUIPromotion r7 = (ECUIPromotion) r3.getValue();
    L8:
        if (r7 == null) goto L10;
        int r8 = 1;
    L11:
        r6.putOpt("status", Integer.valueOf(r8));
        ECContext r9 = RoomContextController.a.a().r();
        if (r9 == null) goto L18;
        n<ECUIPromotion> r10 = r9.getExplainPromotion();
        if (r10 == null) goto L18;
        ECUIPromotion r11 = (ECUIPromotion) r10.getValue();
        if (r11 == null) goto L18;
        r2 = r11.getProductId();
    L18:
        r6.putOpt("promotion_id", r2);
        Unit r12 = Unit.INSTANCE;
        r5.onSuccess(r6);
        return;
    L10:
        r8 = 0;
    L7:
        r7 = null;
        goto L8
    }
}
