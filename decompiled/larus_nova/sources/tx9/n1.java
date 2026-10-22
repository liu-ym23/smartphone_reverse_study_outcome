package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class n1 {
    public static void b(String r100, String r101, String r102, String r103, String r104, String r105, String r110) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L23;
    L7:
        r106.put("is_immersive_background", "1");     // Catch: JSONException -> L5
        if (r101 == null) goto L10;
        r106.put("recommend_from", r101);     // Catch: JSONException -> L5
    L10:
        r106.put("click_from", r102);     // Catch: JSONException -> L5
        if (r103 == null) goto L13;
        r106.put("req_id", r103);     // Catch: JSONException -> L5
    L13:
        r106.put("current_page", "chat");     // Catch: JSONException -> L5
        if (r104 == null) goto L16;
        r106.put("previous_page", r104);     // Catch: JSONException -> L5
    L16:
        r106.put("chat_type", r105);     // Catch: JSONException -> L5
        if (r110 == null) goto L21;
        r106.put("conversation_id", r110);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ImmersiveEventHelper", "error in ImmersiveEventHelper mobClickChatHistoryEntrance " + e.getLocalizedMessage());
    L21:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("show_chat_history_entrance");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L23:
        r106.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r110, String r111) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("to_status", r100);     // Catch: JSONException -> L19
        if (r101 == null) goto L6;
        r106.put("bot_id", r101);     // Catch: JSONException -> L19
    L6:
        r106.put("is_immersive_background", "1");     // Catch: JSONException -> L19
        if (r102 == null) goto L9;
        r106.put("recommend_from", r102);     // Catch: JSONException -> L19
    L9:
        r106.put("click_from", r103);     // Catch: JSONException -> L19
        if (r104 == null) goto L12;
        r106.put("req_id", r104);     // Catch: JSONException -> L19
    L12:
        r106.put("current_page", "chat");     // Catch: JSONException -> L19
        if (r105 == null) goto L15;
        r106.put("previous_page", r105);     // Catch: JSONException -> L19
    L15:
        r106.put("chat_type", r110);     // Catch: JSONException -> L19
        if (r111 == null) goto L21;
        r106.put("conversation_id", r111);     // Catch: JSONException -> L19
    L21:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("click_chat_history_entrance");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L19:
        e = move-exception;
        FLogger.f375446a.e("ImmersiveEventHelper", "error in ImmersiveEventHelper mobClickChatHistoryEntrance " + e.getLocalizedMessage());
        goto L21
    }
}
