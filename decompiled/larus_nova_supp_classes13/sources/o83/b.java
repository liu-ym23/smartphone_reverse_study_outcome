package o83;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int f = 0;
    public JSONObject a;
    public JSONObject b;
    public int c;
    public final boolean d;
    public final String e;

    public static final class a {
        public static JSONObject a(JSONObject r3, boolean r4) {
            if (r3 != null) goto L5;
            return null;
        L5:
            JSONObject r0 = new JSONObject();
            r0.put("id", r3.opt("id"));
            r0.put("address_type", r3.opt("address_type"));
            r0.put("extra", r3.opt("extra"));
            if (r4 == false) goto L8;
            r0.put("log_extra", r3.opt("log_extra"));
        L8:
            return r0;
        }
    }

    static {
    }

    public b(JSONObject r3, boolean r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r4 = false;
    L8:
        this.a = r3;
        this.b = null;
        this.c = 0;
        this.d = r4;
        this.e = r5;
    }
}
