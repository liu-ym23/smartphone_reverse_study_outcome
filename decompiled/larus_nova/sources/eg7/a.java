package eg7;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static void a(JSONObject r100, String r101, int r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(JSONObject r100, String r101, long r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void c(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
