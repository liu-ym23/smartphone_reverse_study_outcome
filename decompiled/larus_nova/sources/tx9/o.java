package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class o {
    public static void a(String r100, String r101, String r102, String r103, by7.e r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L19;
    L7:
        r105.put("click_from", r101);     // Catch: JSONException -> L5
        if (r102 == null) goto L10;
        r105.put("from_activity_name", r102);     // Catch: JSONException -> L5
    L10:
        if (r103 == null) goto L14;
        r105.put("from_activity_module", r103);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("BotEventHelper", "error in BotEventHelper botMakerCardClick " + e.getLocalizedMessage());
    L14:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("bot_maker_card_click");
        if (r104 == null) goto L17;
        r107.f21464b = r104;
    L17:
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L19:
        r105.put("previous_page", r100);     // Catch: JSONException -> L5
        goto L7
    }
}
