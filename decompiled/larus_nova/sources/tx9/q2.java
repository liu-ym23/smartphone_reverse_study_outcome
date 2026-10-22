package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class q2 {
    public static void a(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter("setting", "currentPage");
        Intrinsics.checkNotNullParameter(r100, "clickFrom");
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("current_page", "setting");     // Catch: JSONException -> L5
        r101.put("click_from", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_contact_setting");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("NotifySettingsEventHelper", "error in NotifySettingsEventHelper mobClickContactSetting " + e.getLocalizedMessage());
        goto L7
    }

    public static void c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "clickFrom");
        Intrinsics.checkNotNullParameter(r101, "toStatus");
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("click_from", r100);     // Catch: JSONException -> L5
        r102.put("to_status", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_notify_auth_switch");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("NotifySettingsEventHelper", "error in NotifySettingsEventHelper mobClickNotifyAuthSwitch " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "settingType");
        Intrinsics.checkNotNullParameter(r101, "clickFrom");
        Intrinsics.checkNotNullParameter(r102, "toStatus");
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("setting_type", r100);     // Catch: JSONException -> L5
        r103.put("click_from", r101);     // Catch: JSONException -> L5
        r103.put("to_status", r102);     // Catch: JSONException -> L5
    L7:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("click_contact_setting_switch");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("NotifySettingsEventHelper", "error in NotifySettingsEventHelper mobClickContactSettingSwitch " + e.getLocalizedMessage());
        goto L7
    }
}
