package yw3;

import com.bytedance.applog.isolate.DataIsolateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static String a(DataIsolateKey r1, JSONObject r2) {
        if (r2 == null) goto L9;
        if (r1 != null) goto L6;
        return "";
    L6:
        if (r1 == DataIsolateKey.USER_ID) goto L8;
        return "";
    L8:
        return r2.optString("user_id", "0");
    L9:
        return "";
    }
}
