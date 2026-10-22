package tx9;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class t1 {
    public static void a(String r110, Long r111, String r210, String r211, String r212, Boolean r213, JSONObject r214, by7.e r215, String r216, String r217, Integer r218, String r219, String r310, Boolean r311, String r312, Map r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r314 & 64) == 0) goto L25;
        Boolean r105 = null;
    L27:
        if ((r314 & 128) == 0) goto L29;
        JSONObject r106 = new JSONObject();
    L31:
        if ((r314 & 256) == 0) goto L33;
        by7.e r107 = null;
    L35:
        if ((r314 & 512) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r314 & 1024) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r314 & 2048) == 0) goto L45;
        Integer r114 = null;
    L47:
        if ((r314 & 4096) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r314 & 8192) == 0) goto L53;
        String r116 = null;
    L55:
        if ((r314 & 16384) == 0) goto L57;
        Boolean r117 = null;
    L59:
        if ((r314 & 32768) == 0) goto L61;
        String r108 = "text";
    L63:
        if ((r314 & 65536) == 0) goto L65;
        Map r118 = null;
    L66:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r118 != null) goto L120;
    L76:
        by7.e r119 = r107;
        r106.putOpt("content_type", r108);     // Catch: JSONException -> L111
        if (r100 == null) goto L79;
        r106.put("bot_id", r100);     // Catch: JSONException -> L111
    L79:
        if (r101 == null) goto L81;
        r106.put("conversation_id", r101.longValue());     // Catch: JSONException -> L111
    L81:
        if (r102 == null) goto L83;
        r106.put("current_page", r102);     // Catch: JSONException -> L111
    L83:
        if (r103 == null) goto L85;
        r106.put(AppConstants.KEY_MESSAGE_FROM, r103);     // Catch: JSONException -> L111
    L85:
        if (r104 == null) goto L87;
        r106.put(MusicAppletPage.KEY_MESSAGE_ID, r104);     // Catch: JSONException -> L111
    L87:
        if (r112 == null) goto L89;
        r106.put("agent_id", r112);     // Catch: JSONException -> L111
    L89:
        if (r113 == null) goto L91;
        r106.put("chat_type", r113);     // Catch: JSONException -> L111
    L91:
        if (r114 == null) goto L93;
        r106.put("bot_type", r114.intValue());     // Catch: JSONException -> L111
    L93:
        if (r115 == null) goto L95;
        r106.put("group_type", r115);     // Catch: JSONException -> L111
    L95:
        String r109 = "1";
        if (r105 != null) goto L98;
    L102:
        if (r116 == null) goto L104;
        r106.put("click_module", r116);     // Catch: JSONException -> L111
    L104:
        if (r117 != null) goto L106;
    L113:
        TrackParams r120 = new TrackParams().merge(r106);
        by7.a r121 = new by7.a("long_press_message");
        if (r119 == null) goto L116;
        r121.f21464b = r119;
    L116:
        r121.f21463a.merge(r120);
        r121.b();
        return;
    L106:
        if (r117.booleanValue() == true) goto L109;
        r109 = "0";
    L109:
        r106.put("is_thinking_generating", r109);     // Catch: JSONException -> L111
    L111:
        e = e;
    L112:
        FLogger.f375446a.e("LongEventHelper", "error in LongEventHelper longPressMessage " + e.getLocalizedMessage());
        goto L113
    L98:
        if (r105.booleanValue() == false) goto L100;
        Object r122 = "1";
    L101:
        r106.put("is_message_generating", r122);     // Catch: JSONException -> L111
        goto L102
    L100:
        r122 = "0";
        goto L101
    L120:
        Iterator r123 = r118.entrySet().iterator();     // Catch: JSONException -> L74
    L70:
        if (r123.hasNext() == false) goto L76;
        Map.Entry r124 = (Map.Entry) r123.next();     // Catch: JSONException -> L74
        Iterator r125 = r123;
        r119 = r107;
        r106.put((String) r124.getKey(), r124.getValue());     // Catch: JSONException -> L111
        r123 = r125;
        r107 = r119;
    L74:
        e = e;
        r119 = r107;
        goto L112
    L65:
        r118 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
