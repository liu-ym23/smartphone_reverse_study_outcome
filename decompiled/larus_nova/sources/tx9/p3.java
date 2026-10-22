package tx9;

import com.byted.cast.common.auth.AuthConstants;
import com.ixigua.lib.track.TrackParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class p3 {
    public static final void a(String r100, JSONObject r101, by7.e r102) {
        by7.a r103 = new by7.a(r100);
        if (r102 == null) goto L5;
        r103.f21464b = r102;
    L5:
        TrackParams r104 = new TrackParams().merge(r101);
        r103.f21463a.merge(r104);
        r103.b();
    }

    public static void d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("archive_project_confirm", "popupType");
        Intrinsics.checkNotNullParameter(r101, "buttonName");
        Intrinsics.checkNotNullParameter(r102, "projectId");
        if (Intrinsics.areEqual("archive_project_confirm", "archive_project_confirm") == false) goto L5;
        String r103 = "archive_project_confirm_popup_click";
    L6:
        JSONObject r104 = new JSONObject();
        if (r100 == null) goto L9;
        r104.put("current_page", r100);
    L9:
        r104.put("popup_type", "archive_project_confirm");
        r104.put("button_name", r101);
        r104.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r102);
        a(r103, r104, null);
        return;
    L5:
        r103 = "popup_click";
        goto L6
    }

    public static /* synthetic */ void c(String r110, String r111, String r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r114 & 16) == 0) goto L9;
        String r101 = null;
    L10:
        b(r100, r111, null, null, r101, null, r113, null);
        return;
    L9:
        r101 = r112;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }

    public static void i(String r100, String r101, String r102, String r103, by7.e r104) {
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "projectId");
        Intrinsics.checkNotNullParameter(r103, "moveResult");
        Intrinsics.checkNotNullParameter("long_press_panel", "moveMethod");
        JSONObject r105 = new JSONObject();
        if (r100 == null) goto L5;
        r105.put("current_page", r100);
    L5:
        r105.put("conversation_id", r101);
        if (r102.length() != 0) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L11;
        r102 = "-";
    L11:
        r105.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r102);
        r105.put("move_result", r103);
        r105.put("move_method", "long_press_panel");
        a("move_chat_to_project", r105, r104);
        return;
    L8:
        r106 = false;
        goto L9
    }

    public static void e(String r100, String r101, String r102, String r103, by7.e r104, int r105) {
        String r106 = null;
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r101, "popupType");
        if (Intrinsics.areEqual(r101, "archive_chat_toast") == false) goto L18;
        String r107 = "archive_chat_toast_show";
    L21:
        JSONObject r108 = new JSONObject();
        if (r100 == null) goto L24;
        r108.put("current_page", r100);
    L24:
        r108.put("popup_type", r101);
        boolean r109 = false;
        if (r102 != null) goto L27;
    L35:
        if (r103 != null) goto L37;
    L43:
        a(r107, r108, r104);
        return;
    L37:
        if (r103.length() <= 0) goto L39;
        r109 = true;
    L39:
        if (r109 == false) goto L41;
        r106 = r103;
    L41:
        if (r106 == null) goto L43;
        r108.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r106);
        goto L43
    L27:
        if (r102.length() <= 0) goto L29;
        boolean r110 = true;
    L30:
        if (r110 == true) goto L33;
        r102 = null;
    L33:
        if (r102 == null) goto L35;
        r108.put("conversation_id", r102);
        goto L35
    L29:
        r110 = false;
        goto L30
    L18:
        if (Intrinsics.areEqual(r101, "archive_project_confirm") == false) goto L20;
        r107 = "archive_project_confirm_popup_show";
        goto L21
    L20:
        r107 = "popup_show";
        goto L21
    }

    public static void f(String r100, String r101, String r102, String r103, boolean r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r101, "collapseType");
        JSONObject r106 = new JSONObject();
        if (r100 == null) goto L14;
        r106.put("current_page", r100);
    L14:
        boolean r107 = false;
        String r108 = "-";
        if (r102 != null) goto L17;
    L24:
        r102 = "-";
    L25:
        r106.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r102);
        if (r103 != null) goto L28;
    L36:
        r106.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r108);
        r106.put("collapse_type", r101);
        r106.put("is_collapse", r104);
        a("collapse_group", r106, null);
        return;
    L28:
        if (r103.length() <= 0) goto L30;
        r107 = true;
    L30:
        if (r107 == true) goto L33;
        r103 = null;
    L33:
        if (r103 == null) goto L36;
        r108 = r103;
        goto L36
    L17:
        if (r102.length() <= 0) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == true) goto L23;
        r102 = null;
    L23:
        if (r102 != null) goto L25;
    L19:
        r109 = false;
        goto L20
    }

    public static void g(String r100, String r101, boolean r102, String r103, by7.e r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r103, "createResult");
        JSONObject r106 = new JSONObject();
        if (r100 == null) goto L14;
        r106.put("current_page", r100);
    L14:
        if (r101 == null) goto L16;
        r106.put("enter_method", r101);
    L16:
        r106.put("is_bind_folder", r102);
        r106.put("create_result", r103);
        a("create_project", r106, r104);
    }

    public static void h(String r100, String r101, String r102, String r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = null;
    L14:
        Intrinsics.checkNotNullParameter(r101, "settingType");
        JSONObject r106 = new JSONObject();
        if (r100 == null) goto L17;
        r106.put("current_page", r100);
    L17:
        r106.put("setting_type", r101);
        if (r102 != null) goto L20;
        r102 = "-";
    L20:
        r106.put("group_by", r102);
        if (r103 != null) goto L23;
        r103 = "-";
    L23:
        r106.put(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, r103);
        if (r104 == null) goto L26;
        r106.put("to_status", r104);
    L26:
        a("group_panel_click", r106, null);
    }

    public static final void j(String r100, String r101, String r102, String r103, String r104, by7.e r110) {
        Intrinsics.checkNotNullParameter("chat", "objectType");
        Intrinsics.checkNotNullParameter(r104, "clickFrom");
        JSONObject r105 = new JSONObject();
        if (r100 == null) goto L5;
        r105.put("current_page", r100);
    L5:
        r105.put("object_type", "chat");
        boolean r106 = false;
        String r107 = "-";
        if (r101 != null) goto L8;
    L15:
        r101 = "-";
    L16:
        r105.put("conversation_id", r101);
        if (r102 != null) goto L19;
    L26:
        r102 = "-";
    L27:
        r105.put("bot_id", r102);
        if (r103 != null) goto L30;
    L38:
        r105.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r107);
        r105.put("click_from", r104);
        a("unarchive_chat", r105, r110);
        return;
    L30:
        if (r103.length() <= 0) goto L32;
        r106 = true;
    L32:
        if (r106 == true) goto L35;
        r103 = null;
    L35:
        if (r103 == null) goto L38;
        r107 = r103;
        goto L38
    L19:
        if (r102.length() <= 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L25;
        r102 = null;
    L25:
        if (r102 != null) goto L27;
    L21:
        r108 = false;
        goto L22
    L8:
        if (r101.length() <= 0) goto L10;
        boolean r109 = true;
    L11:
        if (r109 == true) goto L14;
        r101 = null;
    L14:
        if (r101 != null) goto L16;
    L10:
        r109 = false;
        goto L11
    }

    public static final void b(String r100, String r101, String r102, String r103, String r104, String r105, String r110, by7.e r111) {
        Intrinsics.checkNotNullParameter(r101, "objectType");
        Intrinsics.checkNotNullParameter(r110, "clickFrom");
        JSONObject r106 = new JSONObject();
        if (r100 == null) goto L5;
        r106.put("current_page", r100);
    L5:
        r106.put("object_type", r101);
        boolean r107 = false;
        String r108 = "-";
        if (r102 != null) goto L8;
    L15:
        r102 = "-";
    L16:
        r106.put("conversation_id", r102);
        if (r103 != null) goto L19;
    L26:
        r103 = "-";
    L27:
        r106.put("bot_id", r103);
        if (r104 != null) goto L30;
    L37:
        r104 = "-";
    L38:
        r106.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r104);
        if (r105 != null) goto L41;
    L49:
        r106.put("chat_type", r108);
        r106.put("click_from", r110);
        a("archive_chat", r106, r111);
        return;
    L41:
        if (r105.length() <= 0) goto L43;
        r107 = true;
    L43:
        if (r107 == true) goto L46;
        r105 = null;
    L46:
        if (r105 == null) goto L49;
        r108 = r105;
        goto L49
    L30:
        if (r104.length() <= 0) goto L32;
        boolean r109 = true;
    L33:
        if (r109 == true) goto L36;
        r104 = null;
    L36:
        if (r104 != null) goto L38;
    L32:
        r109 = false;
        goto L33
    L19:
        if (r103.length() <= 0) goto L21;
        boolean r112 = true;
    L22:
        if (r112 == true) goto L25;
        r103 = null;
    L25:
        if (r103 != null) goto L27;
    L21:
        r112 = false;
        goto L22
    L8:
        if (r102.length() <= 0) goto L10;
        boolean r113 = true;
    L11:
        if (r113 == true) goto L14;
        r102 = null;
    L14:
        if (r102 != null) goto L16;
    L10:
        r113 = false;
        goto L11
    }
}
