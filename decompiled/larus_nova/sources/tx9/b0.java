package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class b0 {
    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, long r112, JSONObject r113, int r114) {
        if ((r114 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r114 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r114 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r114 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r114 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r114 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r114 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r114 & 128) == 0) goto L27;
        r110 = null;
    L27:
        if ((r114 & 256) == 0) goto L30;
        r111 = null;
    L30:
        if ((r114 & 512) == 0) goto L33;
        r112 = 0;
    L33:
        if ((r114 & 1024) == 0) goto L35;
        r113 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r113, "params");
        if (r100 != null) goto L63;
    L40:
        if (r101 == null) goto L42;
        r113.put("current_page", r101);     // Catch: JSONException -> L38
    L42:
        if (r102 == null) goto L44;
        r113.put("click_from", r102);     // Catch: JSONException -> L38
    L44:
        if (r103 == null) goto L46;
        r113.put(MusicAppletPage.KEY_MESSAGE_ID, r103);     // Catch: JSONException -> L38
    L46:
        if (r104 == null) goto L48;
        r113.put("section_id", r104);     // Catch: JSONException -> L38
    L48:
        if (r105 == null) goto L50;
        r113.put("bot_id", r105);     // Catch: JSONException -> L38
    L50:
        if (r106 == null) goto L52;
        r113.put("conversation_id", r106);     // Catch: JSONException -> L38
    L52:
        if (r110 == null) goto L54;
        r113.put("chat_type", r110);     // Catch: JSONException -> L38
    L54:
        if (r111 == null) goto L57;
        r113.put("is_immersive_background", r111);     // Catch: JSONException -> L38
    L57:
        if (r112 < 0) goto L61;
        r113.put("duration", r112);     // Catch: JSONException -> L38
    L38:
        e = move-exception;
        FLogger.f375446a.e("ClickButtonEventHelper", "error in ClickButtonEventHelper " + e.getLocalizedMessage());
    L61:
        TrackParams r107 = new TrackParams().merge(r113);
        by7.a r108 = new by7.a(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L63:
        r113.put("button_name", r100);     // Catch: JSONException -> L38
        goto L40
    }
}
