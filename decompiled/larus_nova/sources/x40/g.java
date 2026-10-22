package x40;

import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f562426a = 0;

    static {
    }

    public static void c(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        ALogger.e("SchemaMonitor", e);
    }

    @JvmStatic
    public static final void b(String r100, String r101, String r102, JSONObject r103) {
        if (e.a(r102) == false) goto L14;
        if (r100 == null) goto L15;
        JSONObject r104 = new JSONObject();
        r104.put("status_code", 0);     // Catch: JSONException -> L8
    L10:
        c(r104, "enter_room_type", "draw");
        c(r104, "enter_method", r101);
        c(r104, "enter_from_merge", r102);
        ActivityMonitor.c("ttlive_enter_room_feed_api_result", r104, null, r103);
        return;
    L8:
        e = move-exception;
        ALogger.e("SchemaMonitor", e);
        goto L10
    L15:
        return;
    }

    @JvmStatic
    public static final void a(String r100, int r101, String r102, String r103, String r104, JSONObject r105) {
        if (r100 == null) goto L15;
        JSONObject r106 = new JSONObject();
        r106.put("status_code", r101);     // Catch: JSONException -> L6
    L8:
        c(r106, "enter_room_type", r104);
        if (e.a(r103) == false) goto L11;
        c(r106, "enter_method", r102);
        c(r106, "enter_from_merge", r103);
    L11:
        ActivityMonitor.c("ttlive_enter_room_schema_param_result", r106, null, r105);
        return;
    L6:
        e = move-exception;
        ALogger.e("SchemaMonitor", e);
        goto L8
    }
}
