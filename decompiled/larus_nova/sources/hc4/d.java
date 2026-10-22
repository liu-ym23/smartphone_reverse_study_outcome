package hc4;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class d {
    public static Map<String, String> a(JSONObject r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if (r104 == null) goto L11;
        String r105 = r104.toString();
    L13:
        if (TextUtils.isEmpty(r105) == true) goto L7;
        r101.put(r103, r105);
        goto L7
    L11:
        r105 = "";
        goto L13
    L15:
        return r101;
    }

    public static void b(JSONObject r100, String r101, Object r102) {
        if (r100 == null) goto L10;
        r100.put(r101, r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
