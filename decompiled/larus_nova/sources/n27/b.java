package n27;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static void a(String r100, String... r101) {
        JSONObject r102 = new JSONObject();
        r102.putOpt("tag", r100);     // Catch: JSONException -> L8
        int r103 = 0;
    L5:
        if (r103 >= r101.length) goto L10;
        r102.putOpt("msg" + r103, r101[r103]);     // Catch: JSONException -> L8
        r103 = r103 + 1;
    L10:
        MonitorUtils.monitorCommonLog("morpheus_log", r102);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
