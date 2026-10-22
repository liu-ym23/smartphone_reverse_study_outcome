package v4a;

import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.animax.util.AnimaXLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static String a(String r100) {
        if (r100 == null) goto L13;
    L7:
        e = move-exception;
        AnimaXLog.a("AnimaXMonitor", "clearUrlQuery failed, error: " + e.toString());
        return "unknown";
    L4:
        if (r100.isEmpty() == true) goto L14;
        return UriProtector.parse(r100).buildUpon().clearQuery().build().toString();
    L14:
        return "unknown";
    L13:
        return "unknown";
    }

    public static JSONObject b(Map<String, Object> r100) {
        JSONObject r101 = new JSONObject();
        Iterator r102 = ((HashMap) r100).entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: JSONException -> L8
        r101.put((String) r103.getKey(), r103.getValue());     // Catch: JSONException -> L8
    L10:
        return r101;
    L8:
        e = move-exception;
        AnimaXLog.a("AnimaXMonitor", "Converting hashMap to JSON failed, error: " + e.toString());
        goto L10
    }
}
