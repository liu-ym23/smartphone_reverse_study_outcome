package eh4;

import com.alipay.sdk.m.p.e;
import com.optimize.statistics.FrescoMonitorConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends a {
    public d() {
    }

    public static d c(StackTraceElement r100, String r101, String r102, String r103, boolean r104, String r110, String r111) {
        d r105 = new d();
        String r106 = r100.getClassName();
        String r107 = r100.getMethodName();
        int r108 = r100.getLineNumber();
        r105.a("event_type", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        r105.a(FrescoMonitorConst.LOG_TYPE, r111);
        r105.a("timestamp", Long.valueOf(System.currentTimeMillis()));
        r105.a("crash_time", Long.valueOf(System.currentTimeMillis()));
        r105.a("class_ref", r106);
        r105.a(e.f25671s, r107);
        r105.a("line_num", Integer.valueOf(r108));
        r105.a("stack", r101);
        r105.a("crash_md5", com.bytedance.crash.util.d.a(r101));
        r105.a("exception_type", 1);
        r105.a("ensure_type", r110);
        r105.a("is_core", Integer.valueOf(r104 ? 1 : 0));
        r105.a("message", r102);
        r105.a("process_name", com.bytedance.crash.util.b.c());
        r105.a("crash_thread_name", r103);
        JSONObject r109 = r105.f472653a.optJSONObject("filters");
        if (r109 != null) goto L6;
        r109 = new JSONObject();
        r105.f472653a.put("filters", r109);     // Catch: JSONException -> L8
    L6:
        com.bytedance.crash.dumper.c.a(r109);
        return r105;
    }
}
