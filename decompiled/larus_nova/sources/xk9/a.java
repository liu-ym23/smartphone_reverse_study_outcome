package xk9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("current_page", "minor_mode_setting");     // Catch: JSONException -> L5
        r101.put("click_from", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("password_panel_click");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CaseTraceHelper", "error in CaseTraceHelper mobMinorModePasswordPanelClick " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("current_page", "chat");     // Catch: JSONException -> L5
        r101.put("click_from", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("minor_mode_guide_popup_click");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CaseTraceHelper", "error in CaseTraceHelper mobMinorTipsClick " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r100, boolean r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.put("current_page", "minor_mode_setting");     // Catch: JSONException -> L9
        r104.put("scene", r100);     // Catch: JSONException -> L9
        if (r101 == false) goto L6;
        int r105 = 1;
    L7:
        r104.put("success", r105);     // Catch: JSONException -> L9
        r104.put("to_status", r102);     // Catch: JSONException -> L9
        r104.put("error_reason", r103);     // Catch: JSONException -> L9
    L11:
        TrackParams r106 = new TrackParams().merge(r104);
        by7.a r107 = new by7.a("minor_mode_setting_result");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L6:
        r105 = 0;
    L9:
        e = move-exception;
        FLogger.f375446a.e("CaseTraceHelper", "error in CaseTraceHelper mobMinorModeSettingResult " + e.getLocalizedMessage());
        goto L11
    }
}
