package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f215166a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f215167a = null;

        static {
            int[] r100 = new int[BitableProViewModel.ActionPanelListener.Action.values().length];
            r100[BitableProViewModel.ActionPanelListener.Action.HAS_UPGRADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[BitableProViewModel.ActionPanelListener.Action.TO_UPGRADE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[BitableProViewModel.ActionPanelListener.Action.LATER_UPGRADE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f215167a = r100;
        }
    }

    static {
    }

    public static void a(boolean r100) {
        JSONObject r101 = new JSONObject();
        r101.put("click", e1.REPLY_ACTION_APPLY);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        r101.put("is_comment", String.valueOf(r100));
        b("ccm_bitable_premium_permission_application_click", r101);
    }

    public static void c(boolean r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == false) goto L5;
        String r102 = "confirm";
    L6:
        r101.put("click", r102);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        b("ccm_bitable_premium_permission_remove_confirm_click", r101);
        return;
    L5:
        r102 = "cancel";
        goto L6
    }

    public static void b(String r100, JSONObject r101) {
        com.bytedance.ee.bear.contract.d r102 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap<String, Object> r103 = r102.m("docCommonParams");
        HashMap<String, Object> r104 = r102.m("nativePermissionCommonParams");
        HashMap<String, Object> r105 = r102.m("bitableFormPermCommonParams");
        Iterator<T> r106 = r103.entrySet().iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Map.Entry r107 = (Map.Entry) r106.next();
        r101.put((String) r107.getKey(), r107.getValue());
        goto L4
    L6:
        Iterator<T> r108 = r104.entrySet().iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        Map.Entry r109 = (Map.Entry) r108.next();
        r101.put((String) r109.getKey(), r109.getValue());
        goto L8
    L10:
        Iterator<T> r110 = r105.entrySet().iterator();
    L12:
        if (r110.hasNext() == false) goto L14;
        Map.Entry r111 = (Map.Entry) r110.next();
        r101.put((String) r111.getKey(), r111.getValue());
        goto L12
    L14:
        r102.u(r100, r101);
        tt5.a.b("BitableProAnalytic", "eventName = " + r100 + ", params = " + r101);
    }

    public static void d(String r100, Boolean r101) {
        JSONObject r102 = new JSONObject();
        r102.put("click", "add_collaborator");
        r102.put(PickerReporterConstants.KEY.TARGET, "ccm_permission_add_collaborator_view");
        r102.put("is_template", "false");
        if (r100 == null) goto L5;
        r102.put("role_id", r100);
    L5:
        if (r101 == null) goto L7;
        r102.put("is_success", r101.toString());
    L7:
        b("ccm_bitable_premium_permission_setting_click", r102);
    }

    public static void e(Boolean r100, String r101, Boolean r102) {
        JSONObject r103 = new JSONObject();
        r103.put("click", "back");
        r103.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r100 == null) goto L5;
        r103.put("is_template", r100.toString());
    L5:
        if (r101 == null) goto L7;
        r103.put("role_id", r101);
    L7:
        if (r102 == null) goto L9;
        r103.put("is_default_role_visit_allow", r102.toString());
    L9:
        b("ccm_bitable_premium_permission_setting_click", r103);
    }
}
