package x40;

import am2.x;
import com.bytedance.android.live.core.activity.ActivityHybridMonitor$ContainerType;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f562423a = 0;

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public static void a(int r110, String r111, ActivityHybridMonitor$ContainerType r112, String r113, String r114, String r115, String r210, long r211) {
        String r100 = r115;
        if (ActivityMonitor.a() == false) goto L25;
        JSONObject r101 = new JSONObject();
        r101.put("url", r100);
        r101.put("room_id", r114);
        r101.put("msg", r111);
        r101.put("live_activity", r210);
        o r102 = j0.l().c(x.class);
        if (r102 == null) goto L10;
        Map<String, String> r103 = r102.getMap();
        if (r103 == null) goto L10;
        String r104 = r103.get("enter_method");
        if (r104 == null) goto L10;
    L12:
        if (r102 == null) goto L17;
        Map<String, String> r105 = r102.getMap();
        if (r105 == null) goto L17;
        String r106 = r105.get("enter_from_merge");
        if (r106 == null) goto L17;
    L18:
        JSONObject r107 = new JSONObject();
        r107.put("status_code", r110);
        if (r112 == null) goto L21;
        String r116 = r112.getType();
    L22:
        r107.put("category_1", r116);
        r107.put("category_2", r113);
        r107.put("enter_method", r104);
        r107.put("enter_from_merge", r106);
        ActivityMonitor.c("ttlive_activity_long_touch_container_show", r107, null, r101);
        goto L25
    L21:
        r116 = null;
    L17:
        r106 = "";
    L10:
        r104 = "";
    L25:
        if (ActivityMonitor.f64743a.booleanValue() == false) goto L31;
        HashMap r108 = new HashMap();
        if (r100 != null) goto L29;
        r100 = "";
    L29:
        r108.put("url", r100);
        r108.put("status_code", String.valueOf(r110));
        r108.put("tti", String.valueOf(r211));
        j0.l().sendLog("long_touch_icon_show", r108, new Object[]{IRoom.class, x.class});
        return;
    }
}
