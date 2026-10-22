package qm5;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static void a(boolean r3) {
        HashMap r0 = new HashMap();
        r0.put("click", "close_toolbox");
        r0.put("target", "none");
        if (r3 == false) goto L5;
        String r4 = "drag_to_close";
    L6:
        r0.put("action_type", r4);
        b("ccm_sheet_content_page_click", r0);
        return;
    L5:
        r4 = "other";
        goto L6
    }

    public static void c(String r3) {
        HashMap r0 = new HashMap();
        r0.put("click", "smart_screencapture_click");
        r0.put("target", "none");
        r0.put("sub_click", r3);
        b("ccm_sheet_content_page_click", r0);
    }

    public static void d(String r3) {
        HashMap r0 = new HashMap();
        r0.put("click", "find_value");
        r0.put("target", "none");
        r0.put("find_area", "current_sheet");
        r0.put("action_type", r3);
        b("ccm_sheet_search_replace_click", r0);
    }

    public static void b(String r3, Map<String, Object> r4) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        HashMap r1 = new HashMap();
        r1.putAll(r0.m("docCommonParams"));
        r1.putAll(r0.t("sheetCommonParams"));
        ((HashMap) r4).putAll(r1);
        tt5.a.b("SheetAnalyticV2", "reportEvent, event = " + r3 + ", params = " + r4);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).u(r3, new JSONObject(r4));
    }
}
