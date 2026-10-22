package com.bytedance.applog.log;

import jx3.a;
import nx3.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class m$a implements g$b {
    public final /* synthetic */ Object a;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = ((a) this.a).o();
        JSONObject r1 = new JSONObject();
        f.b(r0, r1);
        r1.put("$$APP_ID", ((a) this.a).m);     // Catch: JSONException -> L5
        r1.put("$$EVENT_TYPE", m.a((a) this.a));     // Catch: JSONException -> L5
        r1.put("$$PRIORITY", ((a) this.a).o);     // Catch: JSONException -> L5
        r1.put("$$EVENT_LOCAL_ID", ((a) this.a).q);     // Catch: JSONException -> L5
    L4:
        return r1;
    }

    public m$a(Object r1) {
        this.a = r1;
    }
}
