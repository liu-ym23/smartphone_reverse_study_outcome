package tx9;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class y2 {
    public static void a(String r100, String r101, Long r102, String r103, String r104, String r105) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("current_page", "chat");     // Catch: JSONException -> L16
        if (r101 == null) goto L6;
        r106.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: JSONException -> L16
    L6:
        if (r100 == null) goto L8;
        r106.put(NoticeInfo.KEY_REPLY_ID, r100);     // Catch: JSONException -> L16
    L8:
        if (r102 == null) goto L10;
        r102.longValue();     // Catch: JSONException -> L16
        r106.put("position", r102.longValue());     // Catch: JSONException -> L16
    L10:
        if (r103 == null) goto L12;
        r106.put("conversation_id", r103);     // Catch: JSONException -> L16
    L12:
        if (r104 == null) goto L14;
        r106.put("bot_id", r104);     // Catch: JSONException -> L16
    L14:
        r106.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r105);     // Catch: JSONException -> L16
    L18:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("prompt_survey_tab_click");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L16:
        e = move-exception;
        FLogger.f375446a.e("PromptEventHelper", "error in PromptEventHelper promptTabClick " + e.getLocalizedMessage());
        goto L18
    }
}
