package rw3;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class l implements com.bytedance.applog.log.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f539648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f539649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f539650c;

    @Override // com.bytedance.applog.log.g.b
    public final Object fetch() {
        JSONObject r100 = new JSONObject();
        r100.put("$$APP_ID", this.f539648a);     // Catch: JSONException -> L13
        JSONArray r101 = new JSONArray();     // Catch: JSONException -> L13
        Iterator r102 = this.f539649b.iterator();     // Catch: JSONException -> L13
    L5:
        if (r102.hasNext() == false) goto L7;
        r101.put((Long) r102.next());     // Catch: JSONException -> L13
        goto L5
    L7:
        r100.put("$$EVENT_LOCAL_ID_ARRAY", r101);     // Catch: JSONException -> L13
        if (this.f539650c == false) goto L10;
        String r103 = "success";
    L11:
        r100.put("$$UPLOAD_STATUS", r103);     // Catch: JSONException -> L13
        goto L12
    L10:
        r103 = "failed";
    L12:
        return r100;
    }

    public l(String r100, Set r101, boolean r102) {
        this.f539648a = r100;
        this.f539649b = r101;
        this.f539650c = r102;
    }
}
