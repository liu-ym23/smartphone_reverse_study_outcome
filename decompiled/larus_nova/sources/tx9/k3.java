package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class k3 {
    public static void a(Long r100, String r101, String r102, Long r103, String r104, String r105, JSONObject r106, int r107) {
        if ((r107 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r107 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r107 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r107 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r107 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r107 & 64) == 0) goto L21;
        r105 = null;
    L21:
        if ((r107 & 128) == 0) goto L23;
        r106 = new JSONObject();
    L23:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L42;
    L28:
        if (r101 == null) goto L30;
        r106.put("from_call_scene", r101);     // Catch: JSONException -> L26
    L30:
        if (r102 == null) goto L32;
        r106.put("to_call_scene", r102);     // Catch: JSONException -> L26
    L32:
        if (r103 == null) goto L34;
        r106.put("is_subtitles_mode", r103.longValue());     // Catch: JSONException -> L26
    L34:
        if (r104 == null) goto L36;
        r106.put("conversation_id", r104);     // Catch: JSONException -> L26
    L36:
        if (r105 == null) goto L40;
        r106.put("click_from", r105);     // Catch: JSONException -> L26
    L26:
        e = move-exception;
        FLogger.f375446a.e("SelectEventHelper", "error in SelectEventHelper mobSelectCallScene " + e.getLocalizedMessage());
    L40:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("select_call_scene");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L42:
        r106.put("duration", r100.longValue());     // Catch: JSONException -> L26
        goto L28
    }
}
