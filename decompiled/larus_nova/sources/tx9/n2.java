package tx9;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class n2 {
    public static final void a(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        if (r101 == null) goto L5;
        r103.put("offline_device_id", r101);
    L5:
        if (r102 == null) goto L7;
        r103.put("computer_type", r102);
    L7:
        by7.a r104 = new by7.a(r100);
        TrackParams r105 = new TrackParams().merge(r103);
        r104.f21463a.merge(r105);
        r104.b();
    }
}
