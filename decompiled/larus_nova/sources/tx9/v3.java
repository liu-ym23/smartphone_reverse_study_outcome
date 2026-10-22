package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class v3 {
    public static void a(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L19;
    L7:
        if (r101 == null) goto L9;
        r105.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r105.put("bot_id", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r105.put("chat_type", r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L17;
        r105.put("conversation_id", r104);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("TtsEventHelper", "error in mobAccessTtsCache " + e.getLocalizedMessage());
    L17:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("access_tts_cache");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L19:
        r105.put(AiProactiveTaskViewModel.PARAM_START_METHOD, r100);     // Catch: JSONException -> L5
        goto L7
    }
}
