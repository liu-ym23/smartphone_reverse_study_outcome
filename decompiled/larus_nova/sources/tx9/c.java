package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c {
    public static void c(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("click_method", r100);
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_logoutall_confirm");
        r103.f21463a.merge(r102);
        r103.b();
    }

    public static void e(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("click_method", r100);
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_setting_logout");
        r103.f21463a.merge(r102);
        r103.b();
    }

    public static void b(Boolean r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != null) goto L14;
    L12:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("add_shortcut_result");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L14:
    L10:
        e = move-exception;
        FLogger.f375446a.e("AddEventHelper", "error in AddEventHelper confirm un add Friend " + e.getLocalizedMessage());
        goto L12
    L5:
        if (r100.booleanValue() == false) goto L7;
        int r104 = 1;
    L8:
        r101.put("success", r104);     // Catch: JSONException -> L10
        goto L12
    L7:
        r104 = 0;
        goto L8
    }

    public static void d(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("click_method", r100);
        r102.put("cancel_logout_page", r101);
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_logout_cancel");
        r104.f21463a.merge(r103);
        r104.b();
    }

    public static void f(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("click_method", r100);
        r102.put("click_logout", r101);
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_logout_confirm");
        r104.f21463a.merge(r103);
        r104.b();
    }

    public static final JSONObject a(String r100, String r101, String r102, Boolean r103, Boolean r104) {
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L20
        if (r100 == null) goto L5;
        r105.put("current_page", r100);     // Catch: JSONException -> L20
    L5:
        if (r101 == null) goto L7;
        r105.put("bot_id", r101);     // Catch: JSONException -> L20
    L7:
        r105.put("chat_type", r102);     // Catch: JSONException -> L20
        int r106 = 0;
        if (r103 != null) goto L10;
    L14:
        if (r104 != null) goto L16;
    L19:
        return r105;
    L16:
        if (r104.booleanValue() == false) goto L18;
        r106 = 1;
    L18:
        r105.put("if_can_upload_pic", r106);     // Catch: JSONException -> L20
        goto L19
    L10:
        if (r103.booleanValue() == false) goto L12;
        int r107 = 1;
    L13:
        r105.put("if_has_voice", r107);     // Catch: JSONException -> L20
        goto L14
    L12:
        r107 = 0;
    L20:
        e = move-exception;
        FLogger.f375446a.e("AddEventHelper", "error in AddEventHelper confirm un add Friend " + e.getLocalizedMessage());
        return null;
    }
}
