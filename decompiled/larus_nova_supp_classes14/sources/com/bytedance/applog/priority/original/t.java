package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t {
    public static final /* synthetic */ int c = 0;
    public final int a;
    public final JSONArray b;

    public static final class a {
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("version", this.a);
        JSONArray r1 = this.b;
        if (r1 == null) goto L5;
        r0.put("config_ids", r1);
    L5:
        return r0;
    }

    public final JSONObject b(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        JSONObject r1 = new JSONObject();
        r1.put("version", this.a);
        r1.put("value", r5);
        JSONArray r6 = this.b;
        if (r6 == null) goto L5;
        r1.put("config_ids", r6);
    L5:
        return r1;
    }

    public t(int r1, JSONArray r2) {
        this.a = r1;
        this.b = r2;
    }
}
