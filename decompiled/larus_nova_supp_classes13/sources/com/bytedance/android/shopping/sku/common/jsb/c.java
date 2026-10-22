package com.bytedance.android.shopping.sku.common.jsb;

import com.bytedance.android.shopping.extensions.k;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements j {
    public final /* synthetic */ Function1 a;

    public c(Function1 r1) {
        this.a = r1;
    }

    public final void a(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        String r0 = r6.optString("fields");
        JSONObject r1 = k.u(r6.optString("session_params"));
        String r2 = r1.optString("session_id", "none");
        String r7 = r6.optString("type", "");
        String r3 = r1.optString("node_id", "");
        Function1 r4 = this.a;
        Map<String, Object> r5 = k.z(r0);
        if (r5 == null) goto L5;
        Map r8 = MapsKt.toMap(r5);
    L6:
        r4.invoke(new b(r2, r3, r7, r8));
        return;
    L5:
        r8 = null;
        goto L6
    }
}
