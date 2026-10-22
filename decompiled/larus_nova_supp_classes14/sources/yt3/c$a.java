package yt3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c$a {
    public String a;
    public long b;
    public float c;
    public boolean d;
    public String e;
    public List<c$a> f;
    public final /* synthetic */ c g;

    public final String a() {
        String r0 = this.a;
        String r1 = c.a(this.g, r0);
        if (r1 == null) goto L6;
        r0 = r1;
    L6:
        if (r0.contains(this.g.a) == false) goto L9;
        return r0.replace(this.g.a, "internal");
    L9:
        if (r0.contains(this.g.c) == true) goto L11;
        return r0;
    L11:
        return r0.replace(this.g.c, "external");
    }

    public final JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("path", a());     // Catch: JSONException -> L11
        r0.put("size", this.b);     // Catch: JSONException -> L11
        r0.put("size_rate", this.c);     // Catch: JSONException -> L11
        r0.put("is_folder", this.d);     // Catch: JSONException -> L11
        r0.put("report_type", this.e);     // Catch: JSONException -> L11
        if (((ArrayList) this.f).isEmpty() == true) goto L13;
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L11
        Iterator r2 = ((ArrayList) this.f).iterator();     // Catch: JSONException -> L11
    L7:
        if (r2.hasNext() == false) goto L9;
        r1.put(((c$a) r2.next()).b());     // Catch: JSONException -> L11
        goto L7
    L9:
        r0.put("next_disk", r1);     // Catch: JSONException -> L11
    L13:
        return r0;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public c$a(c r1) {
        this.g = r1;
        this.e = "normal";
        this.f = new ArrayList();
    }
}
