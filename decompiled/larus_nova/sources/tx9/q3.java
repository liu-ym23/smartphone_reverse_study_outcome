package tx9;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class q3 {
    public static final void b(String r100, JSONObject r101) {
        by7.a r102 = new by7.a(r100);
        TrackParams r103 = new TrackParams().merge(r101);
        r102.f21463a.merge(r103);
        r102.b();
    }

    public static final JSONObject a(String r100, String r101, String r102, String r103, boolean r104) {
        JSONObject r105 = new JSONObject();
        r105.put("current_page", "chat");
        r105.put("option_label", r100);
        if (r101 == null) goto L5;
        r105.put("option_sub_label", r101);
    L5:
        if (r102 == null) goto L7;
        r105.put("skill_option_id", r102);
    L7:
        if (r103 == null) goto L9;
        r105.put("skill_tab", r103);
    L9:
        r105.put("is_search_result", r104 ? 1 : 0);
        return r105;
    }
}
