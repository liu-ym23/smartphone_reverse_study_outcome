package rw3;

import com.bytedance.applog.log.g$b;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements g$b {
    public final /* synthetic */ String a;
    public final /* synthetic */ Set b;
    public final /* synthetic */ boolean c;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        r0.put("$$APP_ID", this.a);     // Catch: JSONException -> L13
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L13
        Iterator r2 = this.b.iterator();     // Catch: JSONException -> L13
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.put((Long) r2.next());     // Catch: JSONException -> L13
        goto L5
    L7:
        r0.put("$$EVENT_LOCAL_ID_ARRAY", r1);     // Catch: JSONException -> L13
        if (this.c == false) goto L10;
        String r3 = "success";
    L11:
        r0.put("$$UPLOAD_STATUS", r3);     // Catch: JSONException -> L13
        goto L12
    L10:
        r3 = "failed";
    L12:
        return r0;
    }

    public l(String r1, Set r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
