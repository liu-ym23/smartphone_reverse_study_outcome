package yw3;

import com.bytedance.applog.isolate.DataIsolateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static String a(DataIsolateKey r100, JSONObject r101) {
        if (r101 == null) goto L9;
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100 == DataIsolateKey.USER_ID) goto L8;
        return "";
    L8:
        return r101.optString("user_id", "0");
    L9:
        return "";
    }
}
