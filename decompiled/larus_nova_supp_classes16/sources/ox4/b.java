package ox4;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    static {
    }

    public static HashMap a(JSONObject r4) {
        HashMap r0 = new HashMap();
        if (r4 != null) goto L14;
    L13:
        return r0;
    L14:
        Iterator<String> r1 = r4.keys();     // Catch: Exception -> L11
    L6:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();     // Catch: Exception -> L11
        String r3 = r4.optString(r2);     // Catch: Exception -> L11
        if (r3 == null) goto L6;
        r0.put(r2, r3);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        tt5.a.f("JsonToMapUtil", e, false);
        goto L13
    }
}
