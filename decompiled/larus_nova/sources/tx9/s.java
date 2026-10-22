package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class s {
    public static void c(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("authorize_result", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("calendar_system_authorize_result");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CalendarEventHelper", "error in CalendarEventHelper showButton " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("popup_type", r100);     // Catch: JSONException -> L5
        r102.put("action", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("calendar_popup_show");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CalendarEventHelper", "error in CalendarEventHelper showButton " + e.getLocalizedMessage());
        goto L7
    }

    public static void a(String r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("popup_type", r100);     // Catch: JSONException -> L8
        if (r101 == null) goto L6;
        r103.put("action", r101);     // Catch: JSONException -> L8
    L6:
        r103.put(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON, r102);     // Catch: JSONException -> L8
    L10:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("calendar_popup_click");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("CalendarEventHelper", "error in CalendarEventHelper showButton " + e.getLocalizedMessage());
        goto L10
    }
}
