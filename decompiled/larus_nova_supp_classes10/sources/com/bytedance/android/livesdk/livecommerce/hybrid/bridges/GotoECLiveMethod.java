package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.router.ECLiveSchemaBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/GotoECLiveMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GotoECLiveMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public GotoECLiveMethod() {
        this.e = "gotoECLive";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r5, ECBaseBridgeMethod.a r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "iReturn");
        boolean r0 = r5.optBoolean("open");
        String r1 = r5.optString("base_schema");
        String r2 = r5.optString("query");
        String r7 = r5.optString("ecom_live_params");
        ECLiveSchemaBuilder r3 = new ECLiveSchemaBuilder();
        r3.a(r1);
        r3.c(z1.f(r7));
        r3.d(z1.f(r2));
        if (r0 == false) goto L8;
        Context r8 = getContext();
        if (r8 == null) goto L7;
        String r9 = r3.i(r8);
    L9:
        JSONObject r4 = new JSONObject();
        r4.put("schema", r9);
        Unit r10 = Unit.INSTANCE;
        r6.onSuccess(r4);
        return;
    L7:
        r9 = "";
        goto L9
    L8:
        r9 = r3.build();
        goto L9
    }
}
