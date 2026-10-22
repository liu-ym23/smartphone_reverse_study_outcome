package ac4;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public String a;
    public String b;
    public String c;
    public final b d;

    public final void a(String r2) throws JSONException {
        JSONObject r0 = new JSONObject(r2);
        JSONObjectProtectorUtils.getInt(r0, "JSSDK");
        this.a = JSONObjectProtectorUtils.getString(r0, "func");
        this.b = JSONObjectProtectorUtils.getString(r0, "params");
        JSONObjectProtectorUtils.getString(r0, "__msg_type");
        this.c = JSONObjectProtectorUtils.getString(r0, "__callback_id");
    }

    public c(b r2, String r3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = r2;
        a(r3);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        int r4 = n.a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    public final void d(int r2, JSONObject r3) {
        b r0 = this.d;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.a(c(r2, r3, this).toString());     // Catch: JSONException -> L7
        return;
    }

    public static String b(String r4, JSONObject r5, String r6) {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L5
        r1.put("code", 1);     // Catch: JSONException -> L5
        r1.put("func", r4);     // Catch: JSONException -> L5
        r1.put("__msg_type", "call");     // Catch: JSONException -> L5
        r1.put("data", r5);     // Catch: JSONException -> L5
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L5
        r7.put("__params", r1);     // Catch: JSONException -> L5
        r7.put("__callback_id", r6);     // Catch: JSONException -> L5
        return r7.toString();
    L5:
        e = move-exception;
        int r8 = n.a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return null;
    }

    public static JSONObject c(int r2, JSONObject r3, c r4) throws JSONException {
        JSONObject r0 = new JSONObject();
        r0.put("code", r2);
        r0.put("func", r4.a);
        r0.put("__msg_type", "callback");
        Object r5 = r3;
        if (r3 != null) goto L5;
        r5 = "{}";
    L5:
        r0.put("data", r5);
        JSONObject r6 = new JSONObject();
        r6.put("__params", r0);
        r6.put("__callback_id", r4.c);
        return r6;
    }
}
