package com.bytedance.applog;

import com.bytedance.applog.log.g$b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$b implements g$b {
    public final /* synthetic */ String a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ b c;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r0.put("appId", this.c.j);     // Catch: Throwable -> L5
        r1.put(this.a, this.b);     // Catch: Throwable -> L5
        r0.put("config", r1);     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    public b$b(b r1, String r2, Object r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
