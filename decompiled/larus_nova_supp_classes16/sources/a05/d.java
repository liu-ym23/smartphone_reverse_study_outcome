package a05;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static void b(String r5) {
        Object r2 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).f("ccm_battery_extra", "ccm_battery_jsb_extra");     // Catch: Exception -> L12
        if ((r2 instanceof HashMap) == true) goto L6;
        return;
    L6:
        if ("".equals(((HashMap) r2).get("jsb_state")) == false) goto L8;
        return;
    L8:
        if ("".equals(((HashMap) r2).get("jsb_webview_id")) == true) goto L17;
        ((HashMap) r2).put("jsb_state", r5);     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    public static void a(String r3, String r4, String r5) {
        if (r3 == null) goto L13;
        if (r5 == null) goto L15;
        Object r6 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).f("ccm_battery_extra", "ccm_battery_extra".concat(r3));     // Catch: Exception -> L10
        if ((r6 instanceof JSONObject) == false) goto L14;
        ((JSONObject) r6).put(r4, r5);     // Catch: Exception -> L10
        return;
    L14:
        return;
    L16:
        return;
    L15:
        return;
    }
}
