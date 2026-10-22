package com.bytedance.android.livesdk.livecommerce.promotionlist;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements ti.j {
    public final /* synthetic */ b a;

    public i(b r1) {
        this.a = r1;
    }

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        b.a(this.a, !r2.optBoolean("show"));
    }
}
