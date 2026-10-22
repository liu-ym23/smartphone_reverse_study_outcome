package wt3;

import com.bytedance.apm.d;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jt3.a;
import nu3.c;
import org.json.JSONArray;
import org.json.JSONObject;
import ss3.i;
import vt3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements c {
    public final double a;
    public final double b;
    public final String c;
    public final boolean d;
    public final List<h> e;

    public final String getLogType() {
        return "cpu_exception_trace";
    }

    public final JSONObject a() {
        JSONObject r1 = new JSONObject();
        r1.put("event_type", "cpu_exception_trace");     // Catch: Throwable -> L24
        r1.put("log_type", "cpu_exception_trace");     // Catch: Throwable -> L24
        r1.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L24
        r1.put("crash_time", System.currentTimeMillis());     // Catch: Throwable -> L24
        r1.put("is_main_process", d.k());     // Catch: Throwable -> L24
        r1.put("process_name", d.c());     // Catch: Throwable -> L24
        if (this.d == false) goto L7;
        r1.put("data_type", "back");     // Catch: Throwable -> L24
    L8:
        r1.put("scene", this.c);     // Catch: Throwable -> L24
        r1.put("report_scene", this.c);     // Catch: Throwable -> L24
        if (d.o > d.h()) goto L14;
        long r2 = d.o;     // Catch: Throwable -> L24
        if (r2 == 0) goto L14;
        r1.put("app_launch_start_time", r2);     // Catch: Throwable -> L24
    L15:
        r1.put("process_speed_avg", this.a);     // Catch: Throwable -> L24
        r1.put("process_speed_max", this.b);     // Catch: Throwable -> L24
        i r3 = i.a.a;     // Catch: Throwable -> L24
        r1.put("battery_temperature", r3.d);     // Catch: Throwable -> L24
        r1.put("battery_recharge_state", r3.e);     // Catch: Throwable -> L24
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L24
        Iterator r4 = ((ArrayList) this.e).iterator();     // Catch: Throwable -> L24
    L17:
        if (r4.hasNext() == false) goto L22;
        h r5 = (h) r4.next();     // Catch: Throwable -> L24
        if (r5 == null) goto L17;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L24
        r6.put("nice", r5.h);     // Catch: Throwable -> L24
        r6.put("weight", CastDoubleProtector.valueOf(r5.e));     // Catch: Throwable -> L24
        r6.put("cpu_usage", r5.d);     // Catch: Throwable -> L24
        r6.put("thread_name", r5.b);     // Catch: Throwable -> L24
        r6.put("thread_back_trace", r5.f);     // Catch: Throwable -> L24
        r6.put("thread_id", r5.a);     // Catch: Throwable -> L24
        r0.put(r6);     // Catch: Throwable -> L24
        goto L17
    L22:
        r1.put("threads_info", r0);     // Catch: Throwable -> L24
    L27:
        r1.toString();
        return r1;
    L14:
        r1.put("app_launch_start_time", d.h());     // Catch: Throwable -> L24
        goto L15
    L7:
        r1.put("data_type", "front");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        av3.b.c("APM-CPU", "cpu_exception_data_assemble", th);
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L29
        r7.put("exception", th.getLocalizedMessage());     // Catch: Throwable -> L29
        a.d(new lt3.a("cpu_exception_no_stack", 0, r7, null, null, null));     // Catch: Throwable -> L29
        goto L27
    }

    public final boolean isValid() {
        List<h> r0 = this.e;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L11;
        if (this.a <= 0.0d) goto L11;
        if (this.b <= 0.0d) goto L11;
        return true;
    }

    public b(double r1, double r3, List<h> r5, String r6, boolean r7) {
        this.a = r1;
        this.b = r3;
        this.c = r6;
        this.d = r7;
        this.e = new ArrayList(r5);
    }
}
