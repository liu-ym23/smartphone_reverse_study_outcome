package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BitableProViewModel.ActionPanelListener.Action.values().length];
            r0[BitableProViewModel.ActionPanelListener.Action.HAS_UPGRADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BitableProViewModel.ActionPanelListener.Action.TO_UPGRADE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BitableProViewModel.ActionPanelListener.Action.LATER_UPGRADE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static void a(boolean r3) {
        JSONObject r0 = new JSONObject();
        r0.put("click", "apply");
        r0.put("target", "none");
        r0.put("is_comment", String.valueOf(r3));
        b("ccm_bitable_premium_permission_application_click", r0);
    }

    public static void c(boolean r2) {
        JSONObject r0 = new JSONObject();
        if (r2 == false) goto L5;
        String r3 = TipCallBackData.CONFIRM;
    L6:
        r0.put("click", r3);
        r0.put("target", "none");
        b("ccm_bitable_premium_permission_remove_confirm_click", r0);
        return;
    L5:
        r3 = "cancel";
        goto L6
    }

    public static void b(String r6, JSONObject r7) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap<String, Object> r1 = r0.m("docCommonParams");
        HashMap<String, Object> r2 = r0.m("nativePermissionCommonParams");
        HashMap<String, Object> r3 = r0.m("bitableFormPermCommonParams");
        Iterator<T> r4 = r1.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r5 = (Map.Entry) r4.next();
        r7.put((String) r5.getKey(), r5.getValue());
        goto L4
    L6:
        Iterator<T> r8 = r2.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.put((String) r9.getKey(), r9.getValue());
        goto L8
    L10:
        Iterator<T> r10 = r3.entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r11 = (Map.Entry) r10.next();
        r7.put((String) r11.getKey(), r11.getValue());
        goto L12
    L14:
        r0.u(r6, r7);
        tt5.a.b("BitableProAnalytic", "eventName = " + r6 + ", params = " + r7);
    }

    public static void d(String r3, Boolean r4) {
        JSONObject r0 = new JSONObject();
        r0.put("click", "add_collaborator");
        r0.put("target", "ccm_permission_add_collaborator_view");
        r0.put("is_template", "false");
        if (r3 == null) goto L5;
        r0.put("role_id", r3);
    L5:
        if (r4 == null) goto L7;
        r0.put("is_success", r4.toString());
    L7:
        b("ccm_bitable_premium_permission_setting_click", r0);
    }

    public static void e(Boolean r3, String r4, Boolean r5) {
        JSONObject r0 = new JSONObject();
        r0.put("click", "back");
        r0.put("target", "none");
        if (r3 == null) goto L5;
        r0.put("is_template", r3.toString());
    L5:
        if (r4 == null) goto L7;
        r0.put("role_id", r4);
    L7:
        if (r5 == null) goto L9;
        r0.put("is_default_role_visit_allow", r5.toString());
    L9:
        b("ccm_bitable_premium_permission_setting_click", r0);
    }
}
