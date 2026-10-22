package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class z1 {
    public static void a(String r100, String r101, String r102, Boolean r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r100 != null) goto L20;
    L7:
        if (r101 == null) goto L9;
        r104.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L5
    L9:
        if (r103 != null) goto L11;
    L15:
        r104.put("action", r102);     // Catch: JSONException -> L5
    L18:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("dev_message_negative_report");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("MessageEventHelper", "error in MessageEventHelper mobDevMessageReportResult " + e.getLocalizedMessage());
        goto L18
    L11:
        if (r103.booleanValue() == false) goto L13;
        int r107 = 1;
    L14:
        r104.put("success", r107);     // Catch: JSONException -> L5
        goto L15
    L13:
        r107 = 0;
        goto L14
    L20:
        r104.put("conversation_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void b(String r110, Integer r111, String r112, String r113, String r210, Long r211, String r212, String r213, String r214, Long r215, String r216, String r217, Map r218, JSONObject r219, int r310) {
        Map r100 = null;
        if ((r310 & 1) == 0) goto L5;
        Object r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Object r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Object r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Object r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Long r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        Object r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Object r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        Object r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        Long r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Object r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Object r117 = null;
    L51:
        if ((r310 & 4096) != 0) goto L55;
        r100 = r218;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        JSONObject r118 = new JSONObject();
    L58:
        Intrinsics.checkNotNullParameter(r118, "params");
        if (r100 != null) goto L94;
    L66:
        if (r101 == null) goto L68;
        r118.put("bot_id", r101);     // Catch: JSONException -> L64
    L68:
        if (r102 == null) goto L70;
        r118.put("bot_type", r102.intValue());     // Catch: JSONException -> L64
    L70:
        if (r103 == null) goto L72;
        r118.put("click_from", r103);     // Catch: JSONException -> L64
    L72:
        if (r104 == null) goto L74;
        r118.put("conversation_id", r104);     // Catch: JSONException -> L64
    L74:
        if (r105 == null) goto L76;
        r118.put("is_onboarding", r105);     // Catch: JSONException -> L64
    L76:
        if (r106 == null) goto L78;
        r118.put("is_read", r106.longValue());     // Catch: JSONException -> L64
    L78:
        if (r107 == null) goto L80;
        r118.put(MusicAppletPage.KEY_MESSAGE_ID, r107);     // Catch: JSONException -> L64
    L80:
        if (r108 == null) goto L82;
        r118.put("message_type", r108);     // Catch: JSONException -> L64
    L82:
        if (r114 == null) goto L84;
        r118.put("user_type", r114);     // Catch: JSONException -> L64
    L84:
        if (r115 == null) goto L86;
        r118.put("voice_id", r115.longValue());     // Catch: JSONException -> L64
    L86:
        if (r116 == null) goto L88;
        r118.put("speaker_id", r116);     // Catch: JSONException -> L64
    L88:
        if (r117 == null) goto L92;
        r118.put("speaker_name", r117);     // Catch: JSONException -> L64
    L64:
        e = move-exception;
        FLogger.f375446a.e("MessageEventHelper", "error in MessageEventHelper messageDelete " + e.getLocalizedMessage());
    L92:
        TrackParams r109 = new TrackParams().merge(r118);
        by7.a r119 = new by7.a("message_delete");
        r119.f21463a.merge(r109);
        r119.b();
        return;
    L94:
        Iterator r120 = r100.entrySet().iterator();     // Catch: JSONException -> L64
    L62:
        if (r120.hasNext() == false) goto L66;
        Map.Entry r121 = (Map.Entry) r120.next();     // Catch: JSONException -> L64
        r118.put((String) r121.getKey(), r121.getValue());     // Catch: JSONException -> L64
        goto L62
    L57:
        r118 = r219;
        goto L58
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static void c(String r110, Integer r111, String r210, String r211, String r212, String r213, Long r214, String r215, String r216, String r217, String r218, Long r219, String r310, String r311, Map r312, JSONObject r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        Integer r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Object r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Object r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        Object r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        Long r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Object r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        Object r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Object r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Object r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        Long r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        Object r116 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        Object r117 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        Map r118 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        JSONObject r108 = new JSONObject();
    L66:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r118 != null) goto L107;
    L74:
        Object r119 = r117;
        if (r100 == null) goto L77;
        r108.put("bot_id", r100);     // Catch: JSONException -> L72
    L77:
        if (r101 == null) goto L79;
        r108.put("bot_type", r101.intValue());     // Catch: JSONException -> L72
    L79:
        if (r102 == null) goto L81;
        r108.put("click_from", r102);     // Catch: JSONException -> L72
    L81:
        if (r103 == null) goto L83;
        r108.put("conversation_id", r103);     // Catch: JSONException -> L72
    L83:
        if (r104 == null) goto L85;
        r108.put("error", r104);     // Catch: JSONException -> L72
    L85:
        if (r105 == null) goto L87;
        r108.put("is_onboarding", r105);     // Catch: JSONException -> L72
    L87:
        if (r106 == null) goto L89;
        r108.put("is_read", r106.longValue());     // Catch: JSONException -> L72
    L89:
        if (r107 == null) goto L91;
        r108.put("is_success", r107);     // Catch: JSONException -> L72
    L91:
        if (r112 == null) goto L93;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r112);     // Catch: JSONException -> L72
    L93:
        if (r113 == null) goto L95;
        r108.put("message_type", r113);     // Catch: JSONException -> L72
    L95:
        if (r114 == null) goto L97;
        r108.put("user_type", r114);     // Catch: JSONException -> L72
    L97:
        if (r115 == null) goto L99;
        r108.put("voice_id", r115.longValue());     // Catch: JSONException -> L72
    L99:
        if (r116 == null) goto L101;
        r108.put("speaker_id", r116);     // Catch: JSONException -> L72
    L101:
        if (r119 == null) goto L105;
        r108.put("speaker_name", r119);     // Catch: JSONException -> L72
    L72:
        e = move-exception;
        FLogger.f375446a.e("MessageEventHelper", "error in MessageEventHelper messageDeleteResult " + e.getLocalizedMessage());
    L105:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r120 = new by7.a("message_delete_result");
        r120.f21463a.merge(r109);
        r120.b();
        return;
    L107:
        Iterator r121 = r118.entrySet().iterator();     // Catch: JSONException -> L72
    L70:
        if (r121.hasNext() == false) goto L74;
        Map.Entry r122 = (Map.Entry) r121.next();     // Catch: JSONException -> L72
        r108.put((String) r122.getKey(), r122.getValue());     // Catch: JSONException -> L72
        r121 = r121;
        r117 = r117;
        goto L70
    L65:
        r108 = r313;
        goto L66
    L61:
        r118 = r312;
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
