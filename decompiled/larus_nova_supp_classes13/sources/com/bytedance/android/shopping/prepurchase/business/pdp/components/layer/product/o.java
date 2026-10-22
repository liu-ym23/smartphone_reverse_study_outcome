package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vg3.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements ti.j {
    public final /* synthetic */ PdpPendantHandler a;

    public o(PdpPendantHandler r1) {
        this.a = r1;
    }

    public final void a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        String r5 = r4.optString("containerID");
        this.a.c("receive close event, id=" + r5 + " cachedId=" + this.a.a);
        if (Intrinsics.areEqual(r5, this.a.a) == false) goto L8;
        vg3.u r6 = (vg3.u) this.a.e.getService(vg3.u.class);
        if (r6 == null) goto L9;
        r6.v0(new k0(false, false, 7));
        return;
    L9:
        return;
    }
}
