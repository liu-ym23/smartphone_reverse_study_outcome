package h1a;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes31.dex */
public final class b {
    public static final void a(String r100, String r101, boolean r102, Long r103, Map<String, Long> r104) {
        TrackParams r105 = new TrackParams();
        if (r100 == null) goto L5;
        r105.put(MusicAppletPage.KEY_MESSAGE_ID, r100);
    L5:
        if (r101 == null) goto L7;
        r105.put("task_id", r101);
    L7:
        r105.put("success", Integer.valueOf(r102 ? 1 : 0));
        if (r103 == null) goto L10;
        r105.put("duration", Long.valueOf(r103.longValue()));
    L10:
        if (r104 == null) goto L15;
        Iterator<Map.Entry<String, Long>> r106 = r104.entrySet().iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        Map.Entry<String, Long> r107 = r106.next();
        r105.put(r107.getKey(), Long.valueOf(r107.getValue().longValue()));
    L15:
        by7.a r108 = new by7.a("first_picture_render_finish");
        r108.f21463a.merge(r105);
        r108.b();
    }
}
