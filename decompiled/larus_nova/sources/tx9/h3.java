package tx9;

import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class h3 {
    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, String r107, String r110, String r111, JSONObject r112, by7.e r113, int r114) {
        if ((r114 & 512) == 0) goto L6;
        r111 = null;
    L6:
        if ((r114 & 1024) == 0) goto L9;
        r112 = new JSONObject();
    L9:
        if ((r114 & 2048) == 0) goto L11;
        r113 = null;
    L11:
        Intrinsics.checkNotNullParameter(r112, "params");
        if (r100 != null) goto L39;
    L16:
        if (r101 == null) goto L18;
        r112.put(NoticeInfo.KEY_REPLY_ID, r101);     // Catch: JSONException -> L14
    L18:
        if (r102 == null) goto L20;
        r112.put("conversation_id", r102);     // Catch: JSONException -> L14
    L20:
        if (r103 == null) goto L22;
        r112.put("bot_id", r103);     // Catch: JSONException -> L14
    L22:
        r112.put("chat_type", r104);     // Catch: JSONException -> L14
        if (r105 == null) goto L25;
        r112.put("shot_id", r105);     // Catch: JSONException -> L14
    L25:
        if (r106 == null) goto L27;
        r112.put("is_last_message", r106.intValue());     // Catch: JSONException -> L14
    L27:
        if (r107 == null) goto L29;
        r112.put("reply_status", r107);     // Catch: JSONException -> L14
    L29:
        r112.put("current_page", r110);     // Catch: JSONException -> L14
        if (r111 == null) goto L34;
        r112.put("ai_creation_message_id", r111);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        FLogger.f375446a.e("ScreenshotEventHelper", "error in ScreenshotEventHelper sami " + e.getLocalizedMessage());
    L34:
        TrackParams r108 = new TrackParams().merge(r112);
        by7.a r109 = new by7.a(IHostShare.ShareType.SCREENSHOT);
        if (r113 == null) goto L37;
        r109.f21464b = r113;
    L37:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L39:
        r112.put("recent_bot_message_id", r100);     // Catch: JSONException -> L14
        goto L16
    }
}
