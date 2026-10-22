package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public final int a;
    public final int b;

    public p(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "json");
        this.a = r3.optInt("backoff_ratio", 0);
        this.b = r3.optInt("max_request_frequency", 10);
    }
}
