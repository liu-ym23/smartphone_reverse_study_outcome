package js3;

import com.bytedance.apm.constant.UploadTypeInf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements hs3.c {
    public final String a;
    public final String b;
    public final JSONObject c;
    public JSONObject d;

    public final boolean b() {
        return true;
    }

    public final String d() {
        return UploadTypeInf.UI_ACTION;
    }

    public final String e() {
        return UploadTypeInf.UI_ACTION;
    }

    public final JSONObject a() {
    L7:
        return null;
    L3:
        if (this.d != null) goto L5;
        this.d = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.d.put("log_type", UploadTypeInf.UI_ACTION);     // Catch: JSONException -> L7
        this.d.put("action", this.a);     // Catch: JSONException -> L7
        this.d.put("page", this.b);     // Catch: JSONException -> L7
        this.d.put("context", this.c);     // Catch: JSONException -> L7
        return this.d;
    }

    public final boolean c(JSONObject r1) {
        return zs3.c.a("ui");
    }

    public f(String r1, String r2, JSONObject r3, JSONObject r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
