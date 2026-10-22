package jx3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements com.bytedance.applog.log.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f500803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONArray f500804b;

    @Override // com.bytedance.applog.log.g.b
    public final Object fetch() {
        JSONObject r100 = new JSONObject();
        r100.put("$$APP_ID", this.f500803a);     // Catch: JSONException -> L5
        r100.put("$$EVENT_LOCAL_ID_ARRAY", this.f500804b);     // Catch: JSONException -> L5
    L4:
        return r100;
    }

    public h(String r100, JSONArray r101) {
        this.f500803a = r100;
        this.f500804b = r101;
    }
}
