package com.bytedance.ee.bear.middleground.record;

import com.bytedance.ee.bear.contract.d;
import com.larus.avatar.impl.scan.view.ScanCameraBeautyLevel;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static void b(String r100) {
        HashMap r101 = new HashMap();
        r101.put("click", r100);
        if (r100.equals("record") == false) goto L6;
        r101.put(PickerReporterConstants.KEY.TARGET, "ccm_space_docs_details_record_view");
    L9:
        a("ccm_space_docs_details_setting_click", r101);
        return;
    L6:
        if (r100.equals(ScanCameraBeautyLevel.CATEGORY_KEY_BASIC) == false) goto L8;
        r101.put(PickerReporterConstants.KEY.TARGET, "ccm_space_docs_details_view");
        goto L9
    L8:
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        goto L9
    }

    public static void d(String r100) {
        HashMap r101 = new HashMap();
        r101.put("type", r100);
        a("ccm_space_docs_details_record_view", r101);
    }

    public static void a(String r100, Map<String, Object> r101) {
        d r102 = (d) org.koin.java.a.a(d.class);
        HashMap r103 = new HashMap();
        r103.putAll(r102.m("docCommonParams"));
        ((HashMap) r101).putAll(r103);
        tt5.a.b("RecordAnalytic", "reportEvent, event = " + r100 + ", params = " + r101);
        ((d) org.koin.java.a.a(d.class)).u(r100, new JSONObject(r101));
    }

    public static void c(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("click", r100);
        r102.put(PickerReporterConstants.KEY.TARGET, r101);
        a("ccm_space_docs_details_record_click", r102);
    }
}
