package com.bytedance.applog.params.extract;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final a a;

    public b() {
        this.a = new a();
    }

    public final void a(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "cpId");
        Intrinsics.checkNotNullParameter(r5, "json");
        ParamsExtractDao.a r0 = new ParamsExtractDao.a(r4, r5, System.currentTimeMillis());
        this.a.put(r4, r0);
    }
}
