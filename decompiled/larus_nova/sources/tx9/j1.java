package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class j1 {
    public static void c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L12;
    L7:
        r102.put("button_name", r101);     // Catch: JSONException -> L5
    L10:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("health_dialog_click");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("HealthBotEventHelper", "error in HealthBotEventHelper mobHealthDialogClick " + e.getLocalizedMessage());
        goto L10
    L12:
        r102.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L14;
    L7:
        if (r101 == null) goto L9;
        r103.put("notice_name", r101);     // Catch: JSONException -> L5
    L9:
        r103.put("current_page", r102);     // Catch: JSONException -> L5
    L12:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("health_agreement_and_notice_click");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("HealthBotEventHelper", "error in HealthBotEventHelper mobHealthAgreementAndNoticeClick " + e.getLocalizedMessage());
        goto L12
    L14:
        r103.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L14;
    L7:
        if (r101 == null) goto L9;
        r103.put("notice_name", r101);     // Catch: JSONException -> L5
    L9:
        r103.put("show_from", r102);     // Catch: JSONException -> L5
    L12:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("health_agreement_and_notice_h5_page_show");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("HealthBotEventHelper", "error in HealthBotEventHelper mobHealthAgreementAndNoticeH5PageShow " + e.getLocalizedMessage());
        goto L12
    L14:
        r103.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
