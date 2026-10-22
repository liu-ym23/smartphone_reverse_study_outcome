package p0a;

import com.ixigua.lib.track.TrackParams;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class j {
    public static final void a(String r100, String r101, int r102, int r103, long r104) {
        JSONObject r105 = new JSONObject();
        r105.put("event_type", r100);
        r105.put("fps_tag", r101);
        switch(r102) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        String r106 = "unknown";
    L17:
        r105.put("type", r106);
        r105.put("position", r103);
        r105.put("duration", r104);
        TrackParams r107 = new TrackParams().merge(r105);
        by7.a r108 = new by7.a("creation_feed_holder_trace");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L5:
        r106 = "replica_entrance";
        goto L17
    L6:
        r106 = "creation_banned";
        goto L17
    L7:
        r106 = "image_to_image";
        goto L17
    L8:
        r106 = "video";
        goto L17
    L9:
        r106 = "self_private";
        goto L17
    L10:
        r106 = "ai_beautify";
        goto L17
    L11:
        r106 = "music";
        goto L17
    L12:
        r106 = "loading_and_retry";
        goto L17
    L13:
        r106 = "header";
        goto L17
    L14:
        r106 = "more";
        goto L17
    L15:
        r106 = "avatar";
        goto L17
    L16:
        r106 = "image";
        goto L17
    }
}
