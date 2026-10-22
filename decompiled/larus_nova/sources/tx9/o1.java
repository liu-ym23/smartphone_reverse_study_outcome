package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class o1 {
    public static void a(String r100, Long r101, Long r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L15;
    L7:
        if (r101 == null) goto L9;
        r103.put("badge_count", r101.longValue());     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L13;
        r103.put("read_badge_count", r102.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("L0Part1ChatBotEventHelper", "error in L0Part1ChatBotEventHelper inputStateException " + e.getLocalizedMessage());
    L13:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("dev_log_chat_red_dot_show_exception");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L15:
        r103.put("conversation_id", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
