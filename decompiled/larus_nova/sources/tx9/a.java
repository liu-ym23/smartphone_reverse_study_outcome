package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static void a(String r100, String r101, Integer r102, String r103, Integer r104, String r105, String r110, String r111, String r112, String r113) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L29;
    L7:
        if (r101 == null) goto L9;
        r106.put("resource_id", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r106.put("resource_type", r102.intValue());     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r106.put("artifact_meta_id", r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L15;
        r106.put("artifact_type", r104.intValue());     // Catch: JSONException -> L5
    L15:
        if (r105 == null) goto L17;
        r106.put("aippt_task_id", r105);     // Catch: JSONException -> L5
    L17:
        r106.put("current_page", "aippt_new_detail");     // Catch: JSONException -> L5
        if (r110 == null) goto L20;
        r106.put("conversation_id", r110);     // Catch: JSONException -> L5
    L20:
        if (r111 == null) goto L22;
        r106.put("bot_id", r111);     // Catch: JSONException -> L5
    L22:
        if (r112 == null) goto L24;
        r106.put(MusicAppletPage.KEY_MESSAGE_ID, r112);     // Catch: JSONException -> L5
    L24:
        r106.put("canvas_type", "aippt_new");     // Catch: JSONException -> L5
        r106.put("button_name", r113);     // Catch: JSONException -> L5
    L27:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("aippt_picture_selection_board_click");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("AIPPTGenerateImageHelper", "error in AIPPTGenerateImageHelper mobAIPPTPictureSelectionBoardClick " + e.getLocalizedMessage());
        goto L27
    L29:
        r106.put("presentation_id", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
