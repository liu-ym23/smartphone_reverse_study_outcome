package ox4;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    static {
    }

    public static HashMap a(JSONObject r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L14;
    L13:
        return r101;
    L14:
        Iterator<String> r102 = r100.keys();     // Catch: Exception -> L11
    L6:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();     // Catch: Exception -> L11
        String r104 = r100.optString(r103);     // Catch: Exception -> L11
        if (r104 == null) goto L6;
        r101.put(r103, r104);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        tt5.a.f("JsonToMapUtil", e, false);
        goto L13
    }
}
