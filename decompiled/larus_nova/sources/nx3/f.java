package nx3;

import com.bytedance.applog.log.n;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class f {
    public static boolean a(JSONArray r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static void b(JSONObject r100, JSONObject r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<String> r102 = r100.keys();
    L12:
    L9:
        e = move-exception;
        n.w().s(Collections.singletonList("JsonUtils"), "Merge json interrupted.", e, new Object[0]);
        return;
    L6:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();     // Catch: JSONException -> L9
        r101.put(r103, r100.opt(r103));     // Catch: JSONException -> L9
        goto L12
    }
}
