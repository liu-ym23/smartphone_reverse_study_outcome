package nx3;

import com.bytedance.applog.log.n;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static boolean a(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static void b(JSONObject r3, JSONObject r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = r3.keys();
    L12:
    L9:
        e = move-exception;
        n.w().s(Collections.singletonList("JsonUtils"), "Merge json interrupted.", e, new Object[0]);
        return;
    L6:
        if (r0.hasNext() == false) goto L16;
        String r1 = r0.next();     // Catch: JSONException -> L9
        r4.put(r1, r3.opt(r1));     // Catch: JSONException -> L9
        goto L12
    }
}
