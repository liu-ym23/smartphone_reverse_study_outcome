package ns3;

import android.content.Context;
import com.bytedance.apm.util.t;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f520288a;

    public static JSONObject b(e.b r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        long r103 = r100.f520300a;     // Catch: Throwable -> L65
        if (r103 == (-1)) goto L6;
        r102.put("launch_perf_gc_count", r103);     // Catch: Throwable -> L65
    L6:
        long r104 = r100.f520301b;     // Catch: Throwable -> L65
        if (r104 == (-1)) goto L9;
        r102.put("launch_perf_gc_time", r104);     // Catch: Throwable -> L65
    L9:
        long r105 = r100.f520302c;     // Catch: Throwable -> L65
        if (r105 == (-1)) goto L12;
        r102.put("launch_perf_block_gc_count", r105);     // Catch: Throwable -> L65
    L12:
        long r106 = r100.f520303d;     // Catch: Throwable -> L65
        if (r106 == (-1)) goto L15;
        r102.put("launch_perf_block_gc_time", r106);     // Catch: Throwable -> L65
    L15:
        double r107 = r100.f520307h;     // Catch: Throwable -> L65
        if (r107 == (-1.0d)) goto L18;
        r102.put("launch_perf_iowait_time", r107);     // Catch: Throwable -> L65
    L18:
        double r108 = r100.f520308i;     // Catch: Throwable -> L65
        if (r108 == (-1.0d)) goto L21;
        r102.put("launch_perf_runnable_time", r108);     // Catch: Throwable -> L65
    L21:
        double r109 = r100.f520309j;     // Catch: Throwable -> L65
        if (r109 == (-1.0d)) goto L24;
        r102.put("launch_perf_sleep_time", r109);     // Catch: Throwable -> L65
    L24:
        long r110 = r100.f520311l;     // Catch: Throwable -> L65
        if (r110 == (-1)) goto L27;
        r102.put("launch_perf_minfor_fault", r110);     // Catch: Throwable -> L65
    L27:
        long r111 = r100.f520312m;     // Catch: Throwable -> L65
        if (r111 == (-1)) goto L30;
        r102.put("launch_perf_major_fault", r111);     // Catch: Throwable -> L65
    L30:
        double r112 = r100.f520304e;     // Catch: Throwable -> L65
        if (r112 == (-1.0d)) goto L33;
        r102.put("launch_perf_cpu_time", r112);     // Catch: Throwable -> L65
    L33:
        long r113 = r100.f520305f;     // Catch: Throwable -> L65
        if (r113 == (-1)) goto L36;
        r102.put("launch_perf_voluntary_switches", r113);     // Catch: Throwable -> L65
    L36:
        long r114 = r100.f520306g;     // Catch: Throwable -> L65
        if (r114 == (-1)) goto L39;
        r102.put("launch_perf_involuntary_switches", r114);     // Catch: Throwable -> L65
    L39:
        long r115 = r100.f520313n;     // Catch: Throwable -> L65
        if (r115 == (-1)) goto L42;
        r102.put("launch_perf_all_thread_count", r115);     // Catch: Throwable -> L65
    L42:
        long r116 = r100.f520310k;     // Catch: Throwable -> L65
        if (r116 == (-1)) goto L45;
        r102.put("launch_perf_binder_time", r116);     // Catch: Throwable -> L65
    L45:
        r101.put("list_data", r102);     // Catch: Throwable -> L65
        List<String> r117 = r100.f520314o;     // Catch: Throwable -> L65
        if (r117 == null) goto L55;
        if (r117.isEmpty() == true) goto L55;
        JSONArray r118 = new JSONArray();     // Catch: Throwable -> L65
        Iterator<String> r119 = r117.iterator();     // Catch: Throwable -> L65
    L51:
        if (r119.hasNext() == false) goto L53;
        r118.put(r119.next());     // Catch: Throwable -> L65
        goto L51
    L53:
        r101.put("current_thread_list", r118);     // Catch: Throwable -> L65
    L55:
        if (r100.f520315p > 0) goto L57;
    L63:
        a r120 = a.C6968a.f520287a;     // Catch: Throwable -> L65
        r101.toString();     // Catch: Throwable -> L65
        Context r121 = com.bytedance.apm.d.f190513a;     // Catch: Throwable -> L65
        return r101;
    L57:
        if (r100.f520316q <= 0) goto L63;
        List<t> r122 = r100.f520317r;     // Catch: Throwable -> L65
        if (r122 == null) goto L63;
        if (r122.size() <= 0) goto L63;
        r101.put("process_cpu_time", r100.f520315p);     // Catch: Throwable -> L65
        r101.put("process_duration", r100.f520316q);     // Catch: Throwable -> L65
        r101.put("thread_cpu_info", a(r100.f520317r, r100.f520316q, r100.f520315p));     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        th.printStackTrace();
        a r123 = a.C6968a.f520287a;
        th.getLocalizedMessage();
        return null;
    }

    public static JSONArray a(List<t> r110, long r111, long r112) throws JSONException {
        JSONArray r100 = new JSONArray();
        Iterator<t> r113 = r110.iterator();
    L4:
        if (r113.hasNext() == false) goto L9;
        t r101 = r113.next();
        JSONObject r102 = new JSONObject();
        r102.put("name", r101.f190685b);
        r102.put("utm", r101.f190688e);
        r102.put("stm", r101.f190689f);
        r102.put("duration", r101.f190690g);
        r102.put("usage_for_t_duration", String.format("%.5f", new Object[]{Float.valueOf(r101.f190687d)}));
        r102.put("usage_for_p_duration", String.format("%.5f", new Object[]{Float.valueOf((r101.f190686c * 1.0f) / r111)}));
        r102.put("usage_for_p_cpu", String.format("%.5f", new Object[]{Float.valueOf((r101.f190686c * 1.0f) / r112)}));
        if (com.bytedance.apm.d.j() == false) goto L8;
        av3.b.d("LaunchPerfData", "packThreadItem: " + r102);
    L8:
        r100.put(r102);
        goto L4
    L9:
        return r100;
    }
}
