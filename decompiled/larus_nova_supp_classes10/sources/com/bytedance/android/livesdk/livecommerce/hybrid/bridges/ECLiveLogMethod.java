package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECLiveLogMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveLogMethod extends ECBaseBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "ecLiveLog";
    }

    public ECLiveLogMethod() {
    }

    public final void c(JSONObject r2, ECBaseBridgeMethod.a r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "iReturn");
        if (r2.optString("msg", null) != null) goto L5;
        r2.optString("log");
    L5:
        String r4 = r2.optString("level", null);
        if (r4 != null) goto L8;
        r4 = r2.optString("label");
    L8:
        if (r4 == null) goto L31;
        int r5 = r4.hashCode();
        if (r5 != 100) goto L13;
        r4.equals("d");
        return;
    L13:
        if (r5 != 101) goto L15;
        r4.equals("e");
        return;
    L15:
        if (r5 != 105) goto L17;
        r4.equals("i");
        return;
    L17:
        if (r5 != 118) goto L19;
        r4.equals("v");
        return;
    L19:
        if (r5 != 119) goto L32;
        r4.equals("w");
        return;
    L32:
        return;
    }
}
