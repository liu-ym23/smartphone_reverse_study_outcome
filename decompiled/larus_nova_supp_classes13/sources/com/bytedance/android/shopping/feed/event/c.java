package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.ec.model.InnerFlowAdData;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.ec.core.event.a {
    public final InnerFlowAdRawData a;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        InnerFlowAdData r0 = this.a.getAdData();
        String r1 = null;
        if (r0 == null) goto L7;
        Long r2 = r0.getCreativeId();
        if (r2 == null) goto L7;
        String r3 = String.valueOf(r2.longValue());
    L8:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r4 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("cid", r3, r4);
        InnerFlowAdData r5 = this.a.getAdData();
        if (r5 == null) goto L13;
        Long r6 = r5.getCreativeId();
        if (r6 == null) goto L13;
        r1 = String.valueOf(r6.longValue());
    L13:
        appendParam("value", r1, r4);
        appendParam("log_extra", this.a.getLogExtra(), r4);
        appendParam("is_ad_event", "1", r4);
        appendParam("tag", "embeded_ad", r4);
        appendParam("category", "umeng", r4);
        appendParam("nt", "4", r4);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public c(InnerFlowAdRawData r2) {
        Intrinsics.checkNotNullParameter(r2, "logExtra");
        super("realtime_click");
        this.a = r2;
    }
}
