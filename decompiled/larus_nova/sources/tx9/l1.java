package tx9;

import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class l1 {
    public static void a(String r110, String r111, String r112, String r113, Long r114, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, JSONObject r218, int r219) {
        Object r100 = null;
        if ((r219 & 1) == 0) goto L5;
        Object r101 = null;
    L7:
        if ((r219 & 2) == 0) goto L9;
        Object r102 = null;
    L11:
        if ((r219 & 4) == 0) goto L13;
        Object r103 = null;
    L15:
        if ((r219 & 8) == 0) goto L17;
        Object r104 = null;
    L19:
        if ((r219 & 16) == 0) goto L21;
        Long r105 = null;
    L23:
        if ((r219 & 32) == 0) goto L25;
        Object r106 = null;
    L27:
        if ((r219 & 64) == 0) goto L29;
        Object r107 = null;
    L31:
        if ((r219 & 128) == 0) goto L33;
        Object r108 = null;
    L35:
        if ((r219 & 256) == 0) goto L37;
        Object r115 = null;
    L39:
        if ((r219 & 512) == 0) goto L41;
        Object r116 = null;
    L43:
        if ((r219 & 1024) == 0) goto L45;
        Object r117 = null;
    L47:
        if ((r219 & 2048) == 0) goto L49;
        Object r118 = null;
    L51:
        if ((r219 & 4096) != 0) goto L55;
        r100 = r217;
    L55:
        if ((r219 & 8192) == 0) goto L57;
        JSONObject r119 = new JSONObject();
    L58:
        Intrinsics.checkNotNullParameter(r119, "params");
        if (r101 != null) goto L91;
    L63:
        if (r102 == null) goto L65;
        r119.put("conversation_id", r102);     // Catch: JSONException -> L61
    L65:
        if (r116 == null) goto L67;
        r119.put(PickerReporterConstants.KEY.ENTITY_ID, r116);     // Catch: JSONException -> L61
    L67:
        if (r115 == null) goto L69;
        r119.put(ConversationConstants.KEY_BCM_ID, r115);     // Catch: JSONException -> L61
    L69:
        if (r103 == null) goto L71;
        r119.put("current_page", r103);     // Catch: JSONException -> L61
    L71:
        if (r104 == null) goto L73;
        r119.put(MusicAppletPage.KEY_MESSAGE_ID, r104);     // Catch: JSONException -> L61
    L73:
        if (r105 == null) goto L75;
        r119.put("position", r105.longValue());     // Catch: JSONException -> L61
    L75:
        if (r106 == null) goto L77;
        r119.put("text", r106);     // Catch: JSONException -> L61
    L77:
        if (r118 == null) goto L79;
        r119.put("url", r118);     // Catch: JSONException -> L61
    L79:
        if (r100 == null) goto L81;
        r119.put("doc_id", r100);     // Catch: JSONException -> L61
    L81:
        if (r107 == null) goto L83;
        r119.put("baike_id", r107);     // Catch: JSONException -> L61
    L83:
        if (r108 == null) goto L85;
        r119.put("link_type", r108);     // Catch: JSONException -> L61
    L85:
        if (r117 == null) goto L89;
        r119.put("agent_id", r117);     // Catch: JSONException -> L61
    L61:
        e = move-exception;
        FLogger.f375446a.e("HighlightEventHelper", "error in HighlightEventHelper highlightWordShow " + e.getLocalizedMessage());
    L89:
        TrackParams r109 = new TrackParams().merge(r119);
        by7.a r120 = new by7.a("highlight_word_show");
        r120.f21463a.merge(r109);
        r120.b();
        return;
    L91:
        r119.put("bot_id", r101);     // Catch: JSONException -> L61
        goto L63
    L57:
        r119 = r218;
        goto L58
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
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
}
