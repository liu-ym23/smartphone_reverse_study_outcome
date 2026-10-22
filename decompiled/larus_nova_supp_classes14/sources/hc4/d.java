package hc4;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static Map<String, String> a(JSONObject r5) {
        HashMap r0 = new HashMap();
        if (r5 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r1 = r5.keys();
    L7:
        if (r1.hasNext() == false) goto L15;
        String r2 = r1.next();
        Object r3 = r5.opt(r2);
        if (r3 == null) goto L11;
        String r4 = r3.toString();
    L13:
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r0.put(r2, r4);
        goto L7
    L11:
        r4 = "";
        goto L13
    L15:
        return r0;
    }

    public static void b(JSONObject r0, String r1, Object r2) {
        if (r0 == null) goto L10;
        r0.put(r1, r2);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
