package pc7;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f528555a = 0;

    static {
    }

    public static void a(JSONObject r100, JSONObject r101) {
        r100.put("account_flow", r101.optString("account_flow", ""));
        r100.put("decision_error_code", r101.optInt("error_code", 0));
        r100.put("decision_error_msg", r101.optString("description", ""));
        JSONObject r102 = r101.optJSONObject("event_params");
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length() <= 0) goto L18;
        Iterator<String> r103 = r102.keys();
    L8:
        if (r103.hasNext() == false) goto L19;
        String r104 = r103.next();
        if (TextUtils.isEmpty(r104) == true) goto L8;
        r100.put(r104, r102.opt(r104));
        goto L8
    L19:
        return;
    }

    public static void b(JSONObject r100, int r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L4
        r104.put("error_code", r101);     // Catch: Throwable -> L4
        r104.put("error_msg", r102);     // Catch: Throwable -> L4
        r104.put("verify_way", r103);     // Catch: Throwable -> L4
        a(r104, r100);     // Catch: Throwable -> L4
        com.bytedance.sdk.account.monitor.a.a("uc_verify_client_result", r104);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        tb7.a.e("TwiceVerifyMonitorUtils", "uc_verify_client_result report error, " + th.getMessage());
    }
}
