package js3;

import com.bytedance.apm.constant.UploadTypeInf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements hs3.c {
    public final String a;
    public final String b;
    public final float c;

    public final boolean b() {
        return false;
    }

    public final String d() {
        return UploadTypeInf.TIMER;
    }

    public final String e() {
        return UploadTypeInf.TIMER;
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("type", this.a);     // Catch: JSONException -> L5
        r0.put("key", this.b);     // Catch: JSONException -> L5
        r0.put("value", this.c);     // Catch: JSONException -> L5
        return r0;
    L5:
        return null;
    }

    public final boolean c(JSONObject r2) {
        String r3 = this.a;
        return zs3.c.a.c(r3);
    }

    public d(String r1, String r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
