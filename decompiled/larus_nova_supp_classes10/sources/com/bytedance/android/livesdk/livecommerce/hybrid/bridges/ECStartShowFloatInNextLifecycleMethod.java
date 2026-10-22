package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.app.Activity;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.plugin.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECStartShowFloatInNextLifecycleMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStartShowFloatInNextLifecycleMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECStartShowFloatInNextLifecycleMethod() {
        this.e = "ecStartShowFloatInNextLifecycle";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r5, ECBaseBridgeMethod.a r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "iReturn");
        String r7 = r5.optString("request_page");
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L7;
        j r2 = r1.getLiveWindowService();
        if (r2 == null) goto L7;
        Activity r3 = e.getActivity(getContext());
        com.bytedance.android.ec.adapter.api.a r4 = new com.bytedance.android.ec.adapter.api.a();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r4.a = r7;
        Unit r8 = Unit.INSTANCE;
        r2.e(r3, r4);
    L7:
        r6.onSuccess(null);
    }
}
