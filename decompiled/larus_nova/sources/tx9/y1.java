package tx9;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class y1 {
    public static final void b(String r100, JSONObject r101) {
        by7.a r102 = new by7.a(r100);
        TrackParams r103 = new TrackParams().merge(r101);
        r102.f21463a.merge(r103);
        r102.b();
    }

    public static final JSONObject a(String r100, String r101, boolean r102) {
        JSONObject r103 = new JSONObject();
        r103.put("current_page", "chat");
        r103.put("skill_id", "");
        r103.put("mention_type", r100);
        r103.put("item_name", r101);
        r103.put("is_search_result", r102 ? 1 : 0);
        return r103;
    }
}
