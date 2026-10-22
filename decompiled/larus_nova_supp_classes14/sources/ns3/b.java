package ns3;

import android.content.Context;
import com.bytedance.apm.d;
import com.bytedance.apm.util.t;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static boolean a;

    public static JSONObject b(e.b r9) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        long r2 = r9.a;     // Catch: Throwable -> L65
        if (r2 == (-1)) goto L6;
        r1.put("launch_perf_gc_count", r2);     // Catch: Throwable -> L65
    L6:
        long r3 = r9.b;     // Catch: Throwable -> L65
        if (r3 == (-1)) goto L9;
        r1.put("launch_perf_gc_time", r3);     // Catch: Throwable -> L65
    L9:
        long r4 = r9.c;     // Catch: Throwable -> L65
        if (r4 == (-1)) goto L12;
        r1.put("launch_perf_block_gc_count", r4);     // Catch: Throwable -> L65
    L12:
        long r5 = r9.d;     // Catch: Throwable -> L65
        if (r5 == (-1)) goto L15;
        r1.put("launch_perf_block_gc_time", r5);     // Catch: Throwable -> L65
    L15:
        double r6 = r9.h;     // Catch: Throwable -> L65
        if (r6 == (-1.0d)) goto L18;
        r1.put("launch_perf_iowait_time", r6);     // Catch: Throwable -> L65
    L18:
        double r7 = r9.i;     // Catch: Throwable -> L65
        if (r7 == (-1.0d)) goto L21;
        r1.put("launch_perf_runnable_time", r7);     // Catch: Throwable -> L65
    L21:
        double r8 = r9.j;     // Catch: Throwable -> L65
        if (r8 == (-1.0d)) goto L24;
        r1.put("launch_perf_sleep_time", r8);     // Catch: Throwable -> L65
    L24:
        long r10 = r9.l;     // Catch: Throwable -> L65
        if (r10 == (-1)) goto L27;
        r1.put("launch_perf_minfor_fault", r10);     // Catch: Throwable -> L65
    L27:
        long r11 = r9.m;     // Catch: Throwable -> L65
        if (r11 == (-1)) goto L30;
        r1.put("launch_perf_major_fault", r11);     // Catch: Throwable -> L65
    L30:
        double r12 = r9.e;     // Catch: Throwable -> L65
        if (r12 == (-1.0d)) goto L33;
        r1.put("launch_perf_cpu_time", r12);     // Catch: Throwable -> L65
    L33:
        long r13 = r9.f;     // Catch: Throwable -> L65
        if (r13 == (-1)) goto L36;
        r1.put("launch_perf_voluntary_switches", r13);     // Catch: Throwable -> L65
    L36:
        long r14 = r9.g;     // Catch: Throwable -> L65
        if (r14 == (-1)) goto L39;
        r1.put("launch_perf_involuntary_switches", r14);     // Catch: Throwable -> L65
    L39:
        long r15 = r9.n;     // Catch: Throwable -> L65
        if (r15 == (-1)) goto L42;
        r1.put("launch_perf_all_thread_count", r15);     // Catch: Throwable -> L65
    L42:
        long r16 = r9.k;     // Catch: Throwable -> L65
        if (r16 == (-1)) goto L45;
        r1.put("launch_perf_binder_time", r16);     // Catch: Throwable -> L65
    L45:
        r0.put("list_data", r1);     // Catch: Throwable -> L65
        List<String> r17 = r9.o;     // Catch: Throwable -> L65
        if (r17 == null) goto L55;
        if (r17.isEmpty() == true) goto L55;
        JSONArray r18 = new JSONArray();     // Catch: Throwable -> L65
        Iterator<String> r19 = r17.iterator();     // Catch: Throwable -> L65
    L51:
        if (r19.hasNext() == false) goto L53;
        r18.put(r19.next());     // Catch: Throwable -> L65
        goto L51
    L53:
        r0.put("current_thread_list", r18);     // Catch: Throwable -> L65
    L55:
        if (r9.p > 0) goto L57;
    L63:
        a r20 = a.a.a;     // Catch: Throwable -> L65
        r0.toString();     // Catch: Throwable -> L65
        Context r21 = d.a;     // Catch: Throwable -> L65
        return r0;
    L57:
        if (r9.q <= 0) goto L63;
        List<t> r22 = r9.r;     // Catch: Throwable -> L65
        if (r22 == null) goto L63;
        if (r22.size() <= 0) goto L63;
        r0.put("process_cpu_time", r9.p);     // Catch: Throwable -> L65
        r0.put("process_duration", r9.q);     // Catch: Throwable -> L65
        r0.put("thread_cpu_info", a(r9.r, r9.q, r9.p));     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        th.printStackTrace();
        a r23 = a.a.a;
        th.getLocalizedMessage();
        return null;
    }

    public static JSONArray a(List<t> r11, long r12, long r14) throws JSONException {
        JSONArray r0 = new JSONArray();
        Iterator<t> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        t r1 = r13.next();
        JSONObject r2 = new JSONObject();
        r2.put("name", r1.b);
        r2.put("utm", r1.e);
        r2.put("stm", r1.f);
        r2.put("duration", r1.g);
        r2.put("usage_for_t_duration", String.format("%.5f", new Object[]{Float.valueOf(r1.d)}));
        r2.put("usage_for_p_duration", String.format("%.5f", new Object[]{Float.valueOf((r1.c * 1.0f) / r12)}));
        r2.put("usage_for_p_cpu", String.format("%.5f", new Object[]{Float.valueOf((r1.c * 1.0f) / r14)}));
        if (d.j() == false) goto L8;
        av3.b.d("LaunchPerfData", "packThreadItem: " + r2);
    L8:
        r0.put(r2);
        goto L4
    L9:
        return r0;
    }
}
