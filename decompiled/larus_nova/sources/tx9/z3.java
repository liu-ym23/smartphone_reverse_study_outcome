package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class z3 {
    public static void a(String r100, String r101, String r102, Long r103, JSONObject r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L17;
        r104 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r100 != null) goto L32;
    L22:
        if (r101 == null) goto L24;
        r104.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r101);     // Catch: JSONException -> L20
    L24:
        if (r102 == null) goto L26;
        r104.put(MusicAppletPage.KEY_MESSAGE_ID, r102);     // Catch: JSONException -> L20
    L26:
        if (r103 == null) goto L30;
        r104.put("position", r103.longValue());     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("VideoEventHelper", "error in VideoEventHelper videoCardShow " + e.getLocalizedMessage());
    L30:
        TrackParams r106 = new TrackParams().merge(r104);
        by7.a r107 = new by7.a("video_card_show");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L32:
        r104.put("bot_id", r100);     // Catch: JSONException -> L20
        goto L22
    }
}
