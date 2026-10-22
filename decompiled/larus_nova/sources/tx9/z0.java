package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class z0 {
    public static void a(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r101 != null) goto L22;
    L7:
        if (r102 == null) goto L9;
        r107.put("bot_id", r102);     // Catch: JSONException -> L5
    L9:
        if (r103 == null) goto L11;
        r107.put("conversation_id", r103);     // Catch: JSONException -> L5
    L11:
        if (r104 == null) goto L13;
        r107.put("chat_type", r104);     // Catch: JSONException -> L5
    L13:
        r107.put("edu_skill", r105);     // Catch: JSONException -> L5
        r107.put("current_page", "chat");     // Catch: JSONException -> L5
        r107.put("is_multi_question", r106);     // Catch: JSONException -> L5
    L16:
        TrackParams r108 = new TrackParams().merge(r107);
        if (r100 == false) goto L19;
        String r109 = "one_more_shoot_show";
    L20:
        by7.a r110 = new by7.a(r109);
        r110.f21463a.merge(r108);
        r110.b();
        return;
    L19:
        r109 = "one_more_shoot_click";
    L5:
        e = move-exception;
        FLogger.f375446a.e("EduCameraEventHelper", "error in EduCameraEventHelper mobOneMoreShotShow " + e.getLocalizedMessage());
        goto L16
    L22:
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L5
        goto L7
    }
}
