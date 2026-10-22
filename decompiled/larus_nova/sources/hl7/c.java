package hl7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.bytedance.ug.sdk.luckydog.api.log.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("source", r101);     // Catch: JSONException -> L5
        r102.put("reason", r100);     // Catch: JSONException -> L5
        e.a("luckydog_get_time_error", r102, null);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Uri r103 = UriProtector.parse(r100);
        JSONObject r104 = new JSONObject();
        r104.put("host", r103.getHost()).put("path", r103.getPath()).put("environment", r101).put(CronetDataStorageAccess.LOGID, r102);     // Catch: JSONException -> L8
        e.a("luckydog_calibrator_no_time", r104, null);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
