package com.bytedance.ee.bear.middleground.record;

import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static void b(String r3) {
        HashMap r0 = new HashMap();
        r0.put("click", r3);
        if (r3.equals("record") == false) goto L6;
        r0.put("target", "ccm_space_docs_details_record_view");
    L9:
        a("ccm_space_docs_details_setting_click", r0);
        return;
    L6:
        if (r3.equals("basic") == false) goto L8;
        r0.put("target", "ccm_space_docs_details_view");
        goto L9
    L8:
        r0.put("target", "none");
        goto L9
    }

    public static void d(String r2) {
        HashMap r0 = new HashMap();
        r0.put(ResourceData.KEY_TYPE, r2);
        a("ccm_space_docs_details_record_view", r0);
    }

    public static void a(String r3, Map<String, Object> r4) {
        d r0 = (d) org.koin.java.a.a(d.class);
        HashMap r1 = new HashMap();
        r1.putAll(r0.m("docCommonParams"));
        ((HashMap) r4).putAll(r1);
        tt5.a.b("RecordAnalytic", "reportEvent, event = " + r3 + ", params = " + r4);
        ((d) org.koin.java.a.a(d.class)).u(r3, new JSONObject(r4));
    }

    public static void c(String r2, String r3) {
        HashMap r0 = new HashMap();
        r0.put("click", r2);
        r0.put("target", r3);
        a("ccm_space_docs_details_record_click", r0);
    }
}
