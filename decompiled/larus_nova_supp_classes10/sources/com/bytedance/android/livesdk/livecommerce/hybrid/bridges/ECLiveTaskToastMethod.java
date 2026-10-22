package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.utils.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECLiveTaskToastMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveTaskToastMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "ecLiveTaskToast";
    }

    public ECLiveTaskToastMethod() {
    }

    public final void c(JSONObject r4, ECBaseBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "iReturn");
        String r0 = r4.optString("title", "");
        String r6 = r4.optString("subTitle", "");
        Context r1 = getContext();
        if (r1 == null) goto L5;
        v.a(r1, r0, r6);
    L5:
        r5.onSuccess(null);
    }
}
