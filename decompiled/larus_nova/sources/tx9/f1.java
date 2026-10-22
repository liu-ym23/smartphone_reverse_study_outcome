package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class f1 {
    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L12;
    L7:
        r102.put("to_status", r101);     // Catch: JSONException -> L5
    L10:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_dark_mode_button");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("FontAndThemeEventHelper", "error in FontAndThemeEventHelper mobClickDarkModeButton " + e.getLocalizedMessage());
        goto L10
    L12:
        r102.put("current_page", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L12;
    L7:
        r103.put("dark_mode_setting", r101);     // Catch: JSONException -> L5
        r103.put("text_size_setting", r102);     // Catch: JSONException -> L5
    L10:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("confirm_background_setting");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("FontAndThemeEventHelper", "error in FontAndThemeEventHelper mobConfirmBackgroundSetting " + e.getLocalizedMessage());
        goto L10
    L12:
        r103.put("current_page", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
