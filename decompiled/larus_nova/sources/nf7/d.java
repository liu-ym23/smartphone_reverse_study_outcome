package nf7;

import com.bytedance.supervisor.runtime.common.Logger;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f518962a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        r102.put(ReportCardMonitorPlugin.EVENT_NAME, r100);     // Catch: JSONException -> L5
    L21:
        r103.put("event_msg", r101);     // Catch: JSONException -> L9
    L11:
        lf7.b r104 = lf7.d.f509087a;
        if (r104 != null) goto L14;
        kf7.c r105 = null;
    L15:
        if (r105 == null) goto L23;
        r105.a("scs_psda_event_monitor", r102, r103);
        return;
    L23:
        return;
    L14:
        r105 = r104.f509070d;
    L9:
        e = move-exception;
        int r106 = Logger.f270338a;
        Logger.b("MonitorUtil", Intrinsics.stringPlus("metricJSONException: ", e.getMessage()));
    L5:
        e = move-exception;
        int r107 = Logger.f270338a;
        Logger.b("MonitorUtil", Intrinsics.stringPlus("categoryJSONException: ", e.getMessage()));
        goto L21
    }

    public static void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "error_msg");
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L15
        r103.put("scene", r100);     // Catch: JSONException -> L15
        r103.put("error_msg", r101);     // Catch: JSONException -> L15
        if (r102 == null) goto L7;
        r103.put("token_list", r102);     // Catch: JSONException -> L15
    L7:
        lf7.b r104 = lf7.d.f509087a;     // Catch: JSONException -> L15
        if (r104 != null) goto L10;
        kf7.c r105 = null;
    L11:
        if (r105 == null) goto L20;
        r105.a("scs_psda_error_monitor", r103, null);     // Catch: JSONException -> L15
        return;
    L20:
        return;
    L10:
        r105 = r104.f509070d;     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        int r106 = Logger.f270338a;
        Logger.b("MonitorUtil", Intrinsics.stringPlus("monitorTokenReadWriteError，JSONException: ", e.getMessage()));
    }
}
