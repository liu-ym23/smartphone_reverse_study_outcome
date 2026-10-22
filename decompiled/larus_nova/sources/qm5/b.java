package qm5;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    public static void a(boolean r100) {
        HashMap r101 = new HashMap();
        r101.put("click", "close_toolbox");
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r100 == false) goto L5;
        String r102 = "drag_to_close";
    L6:
        r101.put("action_type", r102);
        b("ccm_sheet_content_page_click", r101);
        return;
    L5:
        r102 = "other";
        goto L6
    }

    public static void c(String r100) {
        HashMap r101 = new HashMap();
        r101.put("click", "smart_screencapture_click");
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        r101.put("sub_click", r100);
        b("ccm_sheet_content_page_click", r101);
    }

    public static void d(String r100) {
        HashMap r101 = new HashMap();
        r101.put("click", "find_value");
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        r101.put("find_area", "current_sheet");
        r101.put("action_type", r100);
        b("ccm_sheet_search_replace_click", r101);
    }

    public static void b(String r100, Map<String, Object> r101) {
        com.bytedance.ee.bear.contract.d r102 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        HashMap r103 = new HashMap();
        r103.putAll(r102.m("docCommonParams"));
        r103.putAll(r102.t("sheetCommonParams"));
        ((HashMap) r101).putAll(r103);
        tt5.a.b("SheetAnalyticV2", "reportEvent, event = " + r100 + ", params = " + r101);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).u(r100, new JSONObject(r101));
    }
}
