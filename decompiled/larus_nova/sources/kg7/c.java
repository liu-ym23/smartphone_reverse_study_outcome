package kg7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {
    public static Map<String, String> a(String r100) {
        HashMap r101 = new HashMap();
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L9
        Iterator<String> r103 = r102.keys();     // Catch: Exception -> L9
    L5:
        if (r103.hasNext() == false) goto L8;
        String r104 = r103.next();     // Catch: Exception -> L9
        r101.put(r104, r102.optString(r104));     // Catch: Exception -> L9
    L8:
        return r101;
    }
}
