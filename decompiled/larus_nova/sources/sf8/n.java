package sf8;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class n {
    public static final void a(String r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter("suggest_prompt", "enterMethod");
        b("deep_search_button_click", r100, r101, r110, r111, new k());
    }

    public static final void b(String r100, String r101, String r102, String r103, String r104, Function1 r105) {
        JSONObject r106 = new JSONObject();
        r106.put("current_page", "chat");
        if (r101 == null) goto L5;
        r106.put("previous_page", r101);
    L5:
        if (r102 == null) goto L7;
        r106.put(MusicAppletPage.KEY_MESSAGE_ID, r102);
    L7:
        if (r103 == null) goto L9;
        r106.put("conversation_id", r103);
    L9:
        if (r104 == null) goto L11;
        r106.put("bot_id", r104);
    L11:
        r105.invoke(r106);
        by7.a r107 = new by7.a(r100);
        TrackParams r108 = new TrackParams().merge(r106);
        r107.f21463a.merge(r108);
        r107.b();
    }
}
