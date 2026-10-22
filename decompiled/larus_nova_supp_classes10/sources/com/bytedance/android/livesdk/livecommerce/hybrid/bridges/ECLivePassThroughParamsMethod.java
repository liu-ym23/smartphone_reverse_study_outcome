package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.ExtraController;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECLivePassThroughParamsMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLivePassThroughParamsMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "ecLivePassThroughParams";
    }

    public ECLivePassThroughParamsMethod() {
    }

    public final void c(JSONObject r7, ECBaseBridgeMethod.a r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "iReturn");
        JSONObject r9 = z1.g(r7.optString("passThroughJson", ""));
        if (r9 == null) goto L10;
        Lazy r1 = ExtraController.l;
        ExtraController r2 = ControllerCenter.c(null, null).u;
        Objects.toString(r2);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "inputJson");
        Iterator<String> r3 = r9.keys();
    L6:
        if (r3.hasNext() == false) goto L10;
        String r4 = r3.next();
        r2.H();
        JSONObject r5 = r2.k;
        if (r5 == null) goto L6;
        r5.put(r4, r9.get(r4));
    L10:
        r8.onSuccess(null);
    }
}
