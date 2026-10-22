package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class i2 {
    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("enter_method", r100);     // Catch: JSONException -> L5
        r102.put("to_status", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("my_info_tab_click");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("MyEventHelper", "error in MyEventHelper myInfoTabClick " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r100, String r101, String r102, Integer r103, String r104, Integer r105, String r106, String r107, String r110, int r111) {
        JSONObject r108 = null;
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r111 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r111 & 512) == 0) goto L32;
        r108 = new JSONObject();
    L32:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L57;
    L37:
        if (r101 == null) goto L39;
        r108.put("position_name", r101);     // Catch: JSONException -> L35
    L39:
        if (r102 == null) goto L41;
        r108.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r102);     // Catch: JSONException -> L35
    L41:
        if (r103 == null) goto L43;
        r108.put("position", r103.toString());     // Catch: JSONException -> L35
    L43:
        if (r104 == null) goto L45;
        r108.put("collect_id", r104);     // Catch: JSONException -> L35
    L45:
        if (r105 == null) goto L47;
        r108.put("collection_type_id", r105.intValue());     // Catch: JSONException -> L35
    L47:
        if (r106 == null) goto L49;
        r108.put("conversation_id", r106);     // Catch: JSONException -> L35
    L49:
        if (r107 == null) goto L51;
        r108.put("bot_id", r107);     // Catch: JSONException -> L35
    L51:
        if (r110 == null) goto L55;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r110);     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        FLogger.f375446a.e("MyEventHelper", "error in MyEventHelper myInfoTabElementShow " + e.getLocalizedMessage());
    L55:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r112 = new by7.a("my_info_tab_element_show");
        r112.f21463a.merge(r109);
        r112.b();
        return;
    L57:
        r108.put("current_page", r100);     // Catch: JSONException -> L35
        goto L37
    }
}
