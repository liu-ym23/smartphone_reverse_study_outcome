package hu;

import com.bytedance.common.utility.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public class a {
    public a() {
    }

    public static void a(JSONObject r100, String r101, int r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e("BaseMonitor", "", e);
    }

    public static void b(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Logger.e("BaseMonitor", "", e);
    }
}
