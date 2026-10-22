package jx3;

import com.bytedance.applog.log.g$b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements g$b {
    public final /* synthetic */ String a;
    public final /* synthetic */ JSONArray b;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        r0.put("$$APP_ID", this.a);     // Catch: JSONException -> L5
        r0.put("$$EVENT_LOCAL_ID_ARRAY", this.b);     // Catch: JSONException -> L5
    L4:
        return r0;
    }

    public h(String r1, JSONArray r2) {
        this.a = r1;
        this.b = r2;
    }
}
