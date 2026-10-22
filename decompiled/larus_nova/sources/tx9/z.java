package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class z {
    public static void b(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L18;
    L7:
        if (r101 == null) goto L11;
        boolean r103 = true;
        if (com.larus.utils.o0.d(r101) != true) goto L11;
    L12:
        if (r103 == false) goto L16;
        r102.put("request_id", r101);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ChatListChangeRecommendEventHelper", "error in ChatListChangeRecommendEventHelper mobChatListChangeRecommendBot " + e.getLocalizedMessage());
    L16:
        TrackParams r104 = new TrackParams().merge(r102);
        by7.a r105 = new by7.a("chat_list_rec_duplicate");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L11:
        r103 = false;
        goto L12
    L18:
        r102.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r100 != null) goto L32;
    L7:
        r107.put("chat_type", r101);     // Catch: JSONException -> L5
        if (r102 == null) goto L10;
        r107.put("click_from", r102);     // Catch: JSONException -> L5
    L10:
        if (r103 == null) goto L12;
        r107.put("current_page", r103);     // Catch: JSONException -> L5
    L12:
        if (r104 == null) goto L14;
        r107.put("is_call_bot", r104);     // Catch: JSONException -> L5
    L14:
        boolean r108 = false;
        if (r105 != null) goto L17;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == false) goto L22;
        r107.put("recommend_from", r105);     // Catch: JSONException -> L5
    L22:
        if (r106 != null) goto L24;
    L26:
        if (r108 == false) goto L30;
        r107.put("req_id", r106);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ChatListChangeRecommendEventHelper", "error in ChatListChangeRecommendEventHelper mobChatListChangeRecommendBot " + e.getLocalizedMessage());
    L30:
        TrackParams r110 = new TrackParams().merge(r107);
        by7.a r111 = new by7.a("chat_list_change_recommend_bot");
        r111.f21463a.merge(r110);
        r111.b();
        return;
    L24:
        if (com.larus.utils.o0.d(r106) != true) goto L26;
        r108 = true;
        goto L26
    L17:
        if (com.larus.utils.o0.d(r105) != true) goto L19;
        r109 = true;
        goto L20
    L32:
        r107.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
