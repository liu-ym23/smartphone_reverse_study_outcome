package ee8;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class e {
    public static void b(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
    L16:
        e = move-exception;
        FLogger.f375446a.e("CotDetailEventHelper", "onDownloadEvent error: " + e.getLocalizedMessage());
    L18:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("general_agent_end_task");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L4:
        if (o0.d(r100) == false) goto L7;
        r104.put(MusicAppletPage.KEY_MESSAGE_ID, r100);     // Catch: Exception -> L16
    L7:
        if (o0.d(r101) == false) goto L10;
        r104.put("conversation_id", r101);     // Catch: Exception -> L16
    L10:
        if (o0.d(r102) == false) goto L13;
        r104.put("bot_id", r102);     // Catch: Exception -> L16
    L13:
        if (o0.d(r103) == false) goto L18;
        r104.put("click_from", r103);     // Catch: Exception -> L16
        goto L18
    }

    public static void c(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
    L16:
        e = move-exception;
        FLogger.f375446a.e("CotDetailEventHelper", "onDownloadEvent error: " + e.getLocalizedMessage());
    L18:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("general_agent_end_task_confirm");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L4:
        if (o0.d(r100) == false) goto L7;
        r104.put(MusicAppletPage.KEY_MESSAGE_ID, r100);     // Catch: Exception -> L16
    L7:
        if (o0.d(r101) == false) goto L10;
        r104.put("conversation_id", r101);     // Catch: Exception -> L16
    L10:
        if (o0.d(r102) == false) goto L13;
        r104.put("bot_id", r102);     // Catch: Exception -> L16
    L13:
        if (o0.d(r103) == false) goto L18;
        r104.put("click_from", r103);     // Catch: Exception -> L16
        goto L18
    }

    public static void a(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
    L18:
        e = move-exception;
        FLogger.f375446a.e("CotDetailEventHelper", "onDownloadEvent error: " + e.getLocalizedMessage());
    L20:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("general_agent_add_thread");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L4:
        if (o0.d(r100) == false) goto L7;
        r105.put(MusicAppletPage.KEY_MESSAGE_ID, r100);     // Catch: Exception -> L18
    L7:
        if (o0.d(r101) == false) goto L10;
        r105.put("conversation_id", r101);     // Catch: Exception -> L18
    L10:
        if (o0.d(r102) == false) goto L13;
        r105.put("bot_id", r102);     // Catch: Exception -> L18
    L13:
        if (o0.d(r103) == false) goto L15;
        r105.put("click_from", r103);     // Catch: Exception -> L18
    L15:
        if (r104 == null) goto L20;
        r105.put("is_answering", r104);     // Catch: Exception -> L18
        goto L20
    }
}
