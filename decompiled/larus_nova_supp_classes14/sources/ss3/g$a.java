package ss3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class g$a {
    public String a;
    public long b;
    public float c;
    public boolean d;
    public String e;
    public List<g$a> f;

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        String r2 = this.a;     // Catch: JSONException -> L17
        if (r2.contains(g.B) == false) goto L7;
        r2 = r2.replace(g.B, "internal");     // Catch: JSONException -> L17
    L9:
        r0.put("path", r2);     // Catch: JSONException -> L17
        r0.put("size", this.b);     // Catch: JSONException -> L17
        r0.put("size_rate", this.c);     // Catch: JSONException -> L17
        r0.put("is_folder", this.d);     // Catch: JSONException -> L17
        r0.put("report_type", this.e);     // Catch: JSONException -> L17
        if (((ArrayList) this.f).isEmpty() == true) goto L19;
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L17
        Iterator r3 = ((ArrayList) this.f).iterator();     // Catch: JSONException -> L17
    L13:
        if (r3.hasNext() == false) goto L15;
        r1.put(((g$a) r3.next()).a());     // Catch: JSONException -> L17
        goto L13
    L15:
        r0.put("next_disk", r1);     // Catch: JSONException -> L17
    L19:
        return r0;
    L7:
        if (r2.contains(g.C) == false) goto L9;
        r2 = r2.replace(g.C, "external");     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public g$a() {
        this.e = "normal";
        this.f = new ArrayList();
    }
}
