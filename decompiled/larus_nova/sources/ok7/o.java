package ok7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class o {
    static {
    }

    public static ArrayList a(JSONArray r100) {
        if (r100.length() > 0) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L23;
        Object r104 = r100.get(r103);     // Catch: JSONException -> L20
        if (r104 == null) goto L10;
        String r105 = r104.toString();     // Catch: JSONException -> L20
    L11:
        if (r105 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == true) goto L22;
        r101.add(r105);     // Catch: JSONException -> L20
    L22:
        r103 = r103 + 1;
        goto L6
    L13:
        if (r105.length() == 0) goto L16;
        r106 = false;
        goto L17
    L10:
        r105 = null;
    L20:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyDogGetBatchSettingsInfoModule", e.getLocalizedMessage());
        goto L22
    L23:
        return r101;
    }

    public static JSONObject b(String r100, ArrayList r110) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        Iterator r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L13;
        String r103 = (String) r111.next();
        List r104 = StringsKt.split$default(r103, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L8
        r102.put(r103, b.c(r100, (String) CollectionsKt.getOrNull(r104, 0), (String) CollectionsKt.getOrNull(r104, 1), (String) CollectionsKt.getOrNull(r104, 2)));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyDogGetBatchSettingsInfoModule", th.getLocalizedMessage());
        goto L4
    L13:
        r101.put("settings", r102);     // Catch: JSONException -> L12
    L11:
        return r101;
    }
}
