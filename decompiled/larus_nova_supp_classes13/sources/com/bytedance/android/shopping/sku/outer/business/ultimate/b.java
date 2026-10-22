package com.bytedance.android.shopping.sku.outer.business.ultimate;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final SkuParams a;

    public b(SkuParams r2) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        this.a = r2;
    }

    public final void a(Map<String, String> r5) {
        String r0 = this.a.getTransmissibleJson();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L25;
        JSONObject r2 = new JSONObject(r0);     // Catch: Exception -> L17
        Iterator<String> r3 = r2.keys();     // Catch: Exception -> L17
    L14:
        if (r3.hasNext() == false) goto L26;
        String r4 = r3.next();     // Catch: Exception -> L17
        r5.put(r4, r2.optString(r4));     // Catch: Exception -> L17
        goto L14
    L26:
        return;
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L25:
        return;
    L7:
        r1 = false;
        goto L8
    }
}
