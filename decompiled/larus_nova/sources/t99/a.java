package t99;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != null) goto L10;
    L8:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("complete_dislike_reason");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L10:
        r101.put("scene", r100);     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        FLogger.f375446a.e("FlowFeedbackTracer", "error in mobCompleteDislikeReason " + e.getLocalizedMessage());
        goto L8
    }

    public static void c(String r100, String r101, String r102, JSONObject r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new JSONObject();
    L14:
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L27;
    L19:
        if (r101 == null) goto L21;
        r103.put("call_id", r101);     // Catch: JSONException -> L17
    L21:
        if (r102 == null) goto L25;
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r102);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        FLogger.f375446a.e("FlowFeedbackTracer", "error in mobFeedbackPopupShow " + e.getLocalizedMessage());
    L25:
        TrackParams r105 = new TrackParams().merge(r103);
        by7.a r106 = new by7.a("feedback_popup_show");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L27:
        r103.put("scene", r100);     // Catch: JSONException -> L17
        goto L19
    }

    public static void b(String r100, String r101, String r102, String r103, JSONObject r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r103 != null) goto L32;
    L22:
        if (r100 == null) goto L24;
        r104.put("scene", r100);     // Catch: JSONException -> L20
    L24:
        if (r101 == null) goto L26;
        r104.put("call_id", r101);     // Catch: JSONException -> L20
    L26:
        if (r102 == null) goto L30;
        r104.put(MusicAppletPage.KEY_MESSAGE_ID, r102);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("FlowFeedbackTracer", "error in mobFeedbackPopupClick " + e.getLocalizedMessage());
    L30:
        TrackParams r106 = new TrackParams().merge(r104);
        by7.a r107 = new by7.a("feedback_popup_click");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L32:
        r104.put("click_from", r103);     // Catch: JSONException -> L20
        goto L22
    }
}
