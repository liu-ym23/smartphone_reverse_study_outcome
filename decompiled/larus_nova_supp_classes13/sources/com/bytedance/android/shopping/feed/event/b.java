package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.android.ec.core.event.a {
    public final JSONObject a;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        String r0 = this.a.optString("cid");
        String r2 = this.a.optString("log_extra");
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r4 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("cid", r0, r4);
        appendParam("value", r0, r4);
        appendParam("log_extra", r2, r4);
        appendParam("is_ad_event", "1", r4);
        appendParam("category", "umeng", r4);
        appendParam("nt", "4", r4);
        appendParam("tag", "draw_ad", r4);
    }

    public b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "enterInfo");
        super("otherclick");
        this.a = r2;
    }
}
