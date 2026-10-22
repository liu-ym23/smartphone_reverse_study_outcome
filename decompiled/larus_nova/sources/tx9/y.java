package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class y {
    public static void a(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("err_no", r100);     // Catch: JSONException -> L5
        r102.put("error_msg", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("chat_bottom_tab_result");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ChatEventHelper", "error in ChatEventHelper enterChatWithBottomTabResult " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(Long r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("current_page", "chat_list");     // Catch: JSONException -> L8
        if (r100 == null) goto L6;
        r102.put("position", r100.longValue());     // Catch: JSONException -> L8
    L6:
        r102.put("position_name", r101);     // Catch: JSONException -> L8
    L10:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("chat_plus_element_show");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("ChatEventHelper", "error in ChatEventHelper chatPlusElementShow " + e.getLocalizedMessage());
        goto L10
    }
}
