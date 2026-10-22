package x40;

import am2.x;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void c(int r100, JSONObject r101, String r102, String r110) {
        JSONObject r103 = new JSONObject();
        r103.put("args", r101);
        r103.put("msg", r102);
        o r104 = j0.l().c(x.class);
        if (r104 == null) goto L8;
        Map<String, String> r105 = r104.getMap();
        if (r105 == null) goto L8;
        String r106 = r105.get("enter_from_merge");
        if (r106 == null) goto L8;
    L10:
        if (e.a(r106) == false) goto L12;
        String r107 = r106;
    L13:
        ActivityMonitor.d("ttlive_jsb_enter_room_result", r100, r103, null, r107, r110, 32);
        return;
    L12:
        r107 = "";
    L8:
        r106 = "";
        goto L10
    }

    @JvmStatic
    public static final void a(int r100, String r101, String r102, JsonObject r110, String r111, String r112) {
        JSONObject r103 = new JSONObject();
        r103.put("url", r101);
        r103.put("params", r110);
        r103.put("msg", r111);
        o r104 = j0.l().c(x.class);
        if (r104 == null) goto L8;
        Map<String, String> r105 = r104.getMap();
        if (r105 == null) goto L8;
        String r106 = r105.get("enter_from_merge");
        if (r106 == null) goto L8;
    L10:
        if (e.a(r106) == false) goto L12;
        String r107 = r106;
    L13:
        ActivityMonitor.d("ttlive_jsb_fetch_result", r100, r103, r102, r107, r112, 32);
        return;
    L12:
        r107 = "";
    L8:
        r106 = "";
        goto L10
    }

    @JvmStatic
    public static final void b(int r100, String r101, String r102, JSONObject r110, String r111, String r112) {
        JSONObject r103 = new JSONObject();
        r103.put("url", r101);
        r103.put("params", r110);
        r103.put("msg", r111);
        o r104 = j0.l().c(x.class);
        if (r104 == null) goto L8;
        Map<String, String> r105 = r104.getMap();
        if (r105 == null) goto L8;
        String r106 = r105.get("enter_from_merge");
        if (r106 == null) goto L8;
    L10:
        if (e.a(r106) == false) goto L12;
        String r107 = r106;
    L13:
        ActivityMonitor.d("ttlive_jsb_fetch_result", r100, r103, r102, r107, r112, 32);
        return;
    L12:
        r107 = "";
    L8:
        r106 = "";
        goto L10
    }
}
