package tr3;

import com.bytedance.apm.util.s;
import org.json.JSONObject;
import ps3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static void b(String r2) {
        if (com.bytedance.apm.d.j() == false) goto L6;
        b.a(new String[]{r2, ""});
        return;
    }

    public static JSONObject a(boolean r1, int r2, Exception r3, JSONObject r4) {
        if (r4 != null) goto L11;
        r4 = new JSONObject();
    L11:
        r4.put("success", r1);     // Catch: Exception -> L8
        r4.put("code", r2);     // Catch: Exception -> L8
        if (r3 == null) goto L10;
        r4.put("exception", r3.getMessage() + s.a(r3, 30));     // Catch: Exception -> L8
        r4.put("exception_object", r3);     // Catch: Exception -> L8
    L10:
        return r4;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
