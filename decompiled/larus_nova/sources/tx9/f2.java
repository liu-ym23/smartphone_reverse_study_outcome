package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class f2 {
    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("notice_category", r100);     // Catch: JSONException -> L7
        r102.put("notice_type", "number_dot");     // Catch: JSONException -> L7
        if (r101 == null) goto L9;
        r102.put("show_cnt", r101);     // Catch: JSONException -> L7
    L9:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("msg_notice_change");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("MsgEventHelper", "error in MsgEventHelper msgNoticeChange " + e.getLocalizedMessage());
        goto L9
    }

    public static void b(String r100, String r101, String r102, int r103) {
        JSONObject r104 = null;
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r103 & 8) == 0) goto L14;
        r104 = new JSONObject();
    L14:
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r100 != null) goto L27;
    L19:
        if (r101 == null) goto L21;
        r104.put("notice_type", r101);     // Catch: JSONException -> L17
    L21:
        if (r102 == null) goto L25;
        r104.put("show_cnt", r102);     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        FLogger.f375446a.e("MsgEventHelper", "error in MsgEventHelper msgNoticeShow " + e.getLocalizedMessage());
    L25:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("msg_notice_show");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L27:
        r104.put("notice_category", r100);     // Catch: JSONException -> L17
        goto L19
    }
}
